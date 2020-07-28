package com.changhong.sei.mdms.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据类型(DataType)DTO类
 *
 * @author sei
 * @since 2020-07-28 17:34:20
 */
@ApiModel(description = "$tool.trim($!{tableInfo.comment})DTO")
public class DataTypeDto extends BaseEntityDto {
    private static final long serialVersionUID = -39848755904743677L;
    /**
     * 标识符
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String name;
    /**
     * 长度
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer dataLength;
    /**
     * 精度
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Integer precision;
    /**
     * java类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String javaType;
    /**
     * mysql类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String mysqlType;
    /**
     * postgre类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String postgreType;
    /**
     * oracle类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String oracleType;
    /**
     * mssql类型
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String mssqlType;
    /**
     * 描述说明
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private String remark;
    /**
     * 冻结
     */
    @ApiModelProperty(value = "$tool.trim(${column.comment})")
    private Boolean frozen;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getMysqlType() {
        return mysqlType;
    }

    public void setMysqlType(String mysqlType) {
        this.mysqlType = mysqlType;
    }

    public String getPostgreType() {
        return postgreType;
    }

    public void setPostgreType(String postgreType) {
        this.postgreType = postgreType;
    }

    public String getOracleType() {
        return oracleType;
    }

    public void setOracleType(String oracleType) {
        this.oracleType = oracleType;
    }

    public String getMssqlType() {
        return mssqlType;
    }

    public void setMssqlType(String mssqlType) {
        this.mssqlType = mssqlType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}