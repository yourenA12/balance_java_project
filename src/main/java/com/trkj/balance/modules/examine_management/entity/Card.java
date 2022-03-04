package com.trkj.balance.modules.examine_management.entity;

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
 * 补打卡表
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CARD")
@ApiModel(value="Card对象", description="补打卡表")
@KeySequence(value = "CARD_ID",clazz = Long.class)
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "补打卡编号")
    @TableId("CARD_ID")
    private Long cardId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "补打卡类型")
    @TableField("CARD_TYPE")
    private String cardType;

    @ApiModelProperty(value = "补打卡时间")
    @TableField("CARD_DATE")
    private Date cardDate;

    @ApiModelProperty(value = "备注")
    @TableField("CARD_REMARKS")
    private String cardRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("CARD_STATE")
    private Long cardState;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
