package com.trkj.balance.modules.salary_management.entity;

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
 * 考勤扣款方案表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ATTENDANDCE")
@KeySequence(value = "ATTENDANDCE_ID",clazz = Long.class)
@ApiModel(value="Attendandce对象", description="考勤扣款方案表")
public class Attendandce implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤扣款方案编号")
    @TableId("ATTENDANDCE_ID")
    private Long attendandceId;

    @ApiModelProperty(value = "迟到一次金额")
    @TableField("ATTENDANDCE_LITEMONEY")
    private Double attendandceLitemoney;

    @TableField("ATTENDANDCE_NAME")
    private String attendandceName;

    @ApiModelProperty(value = "早退一次金额")
    @TableField("ATTENDANDCE_LEAVEMONEY")
    private Double attendandceLeavemoney;

    @ApiModelProperty(value = "未签到一次金额")
    @TableField("ATTENDANDCE_DIDNOTMONEY")
    private Double attendandceDidnotmoney;

    @ApiModelProperty(value = "未签退一次金额")
    @TableField("ATTENDANDCE_DIDBACKMONEY")
    private Double attendandceDidbackmoney;

    @ApiModelProperty(value = "旷工一天金额")
    @TableField("ATTENDANDCE_ABSCNTMONEY")
    private Double attendandceAbscntmoney;

    @ApiModelProperty(value = "状态;0：启用，1：禁用")
    @TableField("ATTENDANDCE_STATE")
    private Long attendandceState;

    @ApiModelProperty(value = "备注")
    @TableField("ATTENDANDCE_REMARK")
    private String attendandceRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version // 乐观锁注解
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
