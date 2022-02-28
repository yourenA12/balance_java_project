package com.trkj.balance.modules.social_management.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsuredDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保明细编号")
    @TableId("INS_DETAIL_ID")
    private Long insDetailId;

    @ApiModelProperty(value = "社保个人缴费")
    @TableField("INS_DETAIL_SOCIAL_PERSON_PAY")
    private Double insDetailSocialPersonPay;

    @ApiModelProperty(value = "社保公司缴费")
    @TableField("INS_DETAIL_SOCIAL_FIRM_PAY")
    private Double insDetailSocialFirmPay;

    @ApiModelProperty(value = "积金个人缴费")
    @TableField("INS_DETAIL_FUND_PERSON_PAY")
    private Double insDetailFundPersonPay;

    @ApiModelProperty(value = "积金公司缴费")
    @TableField("INS_DETAIL_FUND_FIRM_PAY")
    private Double insDetailFundFirmPay;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

//
    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

//
    @ApiModelProperty(value = "默认参保方案id")
    @TableField("DEF_INSURED_ID")
    private Long defInsuredId;

//
    @ApiModelProperty(value = "默认参保方案名称")
    @TableField("DEF_INSURED_NAME")
    private String defInsuredName;

}
