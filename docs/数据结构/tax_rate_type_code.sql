
DROP TABLE IF EXISTS tax_rate_type_code;
CREATE TABLE tax_rate_type_code(
                                             id VARCHAR(36) NOT NULL   COMMENT '主键' ,
                                             good_num VARCHAR(20)    COMMENT '商品编码' ,
                                             good_name VARCHAR(50)    COMMENT '商品名称' ,
                                             good_brief_name VARCHAR(20)    COMMENT '商品简称' ,
                                             remark VARCHAR(2048)    COMMENT '说明' ,
                                             tax_rate VARCHAR(20)    COMMENT '增值税税率' ,
                                             key_word VARCHAR(2048)    COMMENT '关键字' ,
                                             summary_item VARCHAR(20)    COMMENT '汇总项' ,
                                             frozen TINYINT(1)    COMMENT '是否可用' ,
                                             value_tax_special_manage VARCHAR(128)    COMMENT '增值税特殊管理' ,
                                             value_tax_dependence_policy VARCHAR(258)    COMMENT '增值税政策依据' ,
                                             value_tax_special_manage_code VARCHAR(128)    COMMENT '增值税特殊管理代码' ,
                                             sale_tax_special_manage VARCHAR(128)    COMMENT '消费税特殊管理' ,
                                             sale_tax_dependence_policy VARCHAR(258)    COMMENT '消费税政策依据' ,
                                             sale_tax_special_manage_code VARCHAR(128)    COMMENT '消费税特殊管理代码' ,
                                             statistics_code VARCHAR(1024)    COMMENT '统计编码' ,
                                             customs_good VARCHAR(2048)    COMMENT '海关品目' ,
                                             pid VARCHAR(20)    COMMENT '商品编码的上级节点' ,
                                             version VARCHAR(20)    COMMENT '版本' ,
                                             star_day VARCHAR(20)    COMMENT '启用时间' ,
                                             end_day VARCHAR(20)    COMMENT '过渡期截止时间' ,
                                             update_time VARCHAR(20)    COMMENT '更新时间' ,
                                             creator_id VARCHAR(36)    COMMENT '创建人id' ,
                                             created_date DATETIME    COMMENT '创建时间' ,
                                             creator_account VARCHAR(20)    COMMENT '创建人账号' ,
                                             creator_name VARCHAR(20)    COMMENT '创建人名称' ,
                                             last_editor_id VARCHAR(36)    COMMENT '最后修改人id' ,
                                             last_editor_account VARCHAR(20)    COMMENT '最后修改人账号' ,
                                             last_editor_name VARCHAR(20)    COMMENT '最后修改人名称' ,
                                             last_edited_date DATETIME    COMMENT '最后修改时间' ,
                                             tenant_code VARCHAR(36)    COMMENT '租户代码' ,
                                             PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT = '税收分类编码';

CREATE INDEX idx_good_num ON tax_rate_type_code(good_num);
CREATE INDEX idx_pid ON tax_rate_type_code(pid);
