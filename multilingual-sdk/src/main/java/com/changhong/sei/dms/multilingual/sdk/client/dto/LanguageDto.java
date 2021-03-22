package com.changhong.sei.dms.multilingual.sdk.client.dto;

import com.changhong.sei.core.dto.BaseEntityDto;

/**
 * 实现功能: 语言类型DTO
 *
 * @author 王锦光 wangjg
 * @version 2020-03-21 22:07
 */
public class LanguageDto extends BaseEntityDto {
    public static final String DEFAULT_LANG = "zh_CN";
    private static final long serialVersionUID = -5835904584335555441L;
    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 基础语言码
     */
    private String baseCode;

    /**
     * 排序号
     */
    private Integer rank = 0;

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

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
