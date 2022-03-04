package com.trkj.balance.modules.social_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 参保明细表
 * </p>
 *
 * @author 友人A
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_DETAIL")
@KeySequence(value = "INSURED_DETAIL_ID",clazz = Long.class)
@ApiModel(value="InsuredDetail对象", description="参保明细表")
public class InsuredDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保明细编号")
    @TableId("INS_DETAIL_ID")
    private Long insDetailId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

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

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

//    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @TableField(exist = false)
    private String insuredMonth;


}
