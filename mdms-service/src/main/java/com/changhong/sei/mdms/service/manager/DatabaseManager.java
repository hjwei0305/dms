package com.changhong.sei.mdms.service.manager;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.mdms.dto.ColumnDto;
import com.changhong.sei.mdms.dto.TableDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-08-13 23:59
 */
@Component
public class DatabaseManager {

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return conn;
    }

    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ignored) {
            }
        }
    }

    public List<String> getDatabases() {
        Connection conn = getConnection();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
//            String catalog = conn.getCatalog();
            ResultSet catalogs = metaData.getCatalogs();
            List<String> rs = new ArrayList<>();
            while (catalogs.next()) {
                String db = catalogs.getString("TABLE_CAT");
                if (StringUtils.equalsIgnoreCase(db, "information_schema")) {
                    continue;
                }
                rs.add(db);
            }
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * 获取当前数据库所有的表
     * https://cloud.tencent.com/developer/article/1011788
     */
    public ResultData<List<TableDto>> getAllTableName() {
        Connection conn = getConnection();
        try {
            String catalog = conn.getCatalog();
            String schema = conn.getSchema();

            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(catalog, schema, "%", new String[]{"TABLE"});

            TableDto table;
            List<TableDto> ls = new ArrayList<>();
            while (rs.next()) {
                table = new TableDto(rs.getString("TABLE_NAME"), rs.getString("REMARKS"));
                ls.add(table);
            }
            return ResultData.success(ls);
        } catch (SQLException e) {
            LogUtil.error("获取当前数据库表信息异常", e);
            return ResultData.fail("获取当前数据库表信息异常");
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * 获取指定表字段信息
     *
     * @param tableName 表名
     * @return 返回指定表字段清单
     */
    public ResultData<List<ColumnDto>> getAllColumn(String tableName) {
        Connection conn = getConnection();
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
            String primaryKey = null;
            while (primaryKeys.next()) {
                primaryKey = primaryKeys.getString("COLUMN_NAME");
            }
            ResultSet rs = metaData.getColumns(null, null, tableName, null);

            ColumnDto column;
            List<ColumnDto> ls = new ArrayList<>();
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                column = new ColumnDto(columnName, rs.getString("REMARKS"), rs.getString("DATA_TYPE"));
                if (StringUtils.equals(columnName, primaryKey)) {
                    column.setPrimary(true);
                }
                ls.add(column);
            }
            return ResultData.success(ls);
        } catch (SQLException e) {
            LogUtil.error("获取指定表字段信息异常", e);
            return ResultData.fail("获取指定表字段信息异常");
        } finally {
            closeConnection(conn);
        }
    }
}
