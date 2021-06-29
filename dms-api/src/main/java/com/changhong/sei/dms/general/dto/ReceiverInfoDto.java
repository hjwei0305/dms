package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实现功能: 收款方信息Dto
 *
 * @author 王锦光 wangjg
 * @version 2020-10-21 8:59
 */
@ApiModel("收款方信息Dto")
public class ReceiverInfoDto extends BaseEntityDto {
    private static final long serialVersionUID = -3813060547700767544L;
    /**
     * 收款方代码
     */
    @ApiModelProperty(value = "收款方代码")
    private String code;

    /**
     * 收款方名称
     */
    @ApiModelProperty(value = "收款方名称")
    private String name;

    /**
     * 收款方类型
     */
    @ApiModelProperty(value = "收款方类型")
    private ReceiverTypeEnum receiverType;

    /**
     * 账户组
     */
    @ApiModelProperty(value = "账户组")
    private String accountGroup;


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

    public ReceiverTypeEnum getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(ReceiverTypeEnum receiverType) {
        this.receiverType = receiverType;
    }

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup;
    }
}
