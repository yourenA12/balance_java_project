package com.trkj.balance.modules.employee_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 调动记录表
 * </p>
 *
 * @author 林落。
 * @since 2022-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRANSFER")
@KeySequence(value = "TRANSFER_ID",clazz = Long.class)
@ApiModel(value="Transfer对象", description="调动记录表")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调动记录编号")
    @TableId("TRANSFER_ID")
    private Long transferId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "异动类型")
    @TableField("TRANSFER_TYPE")
    private String transferType;

    @ApiModelProperty(value = "原部门编号")
    @TableField("CREATED_DEPT_ID")
    private Long createdDeptId;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRANSFER_STATE")
    private Long transferState;

    @ApiModelProperty(value = "变动后部门编号")
    @TableField("UPDATED_DEPT_ID")
    private Long updatedDeptId;

    @ApiModelProperty(value = "原部门职位编号")
    @TableField("TRANSFER_RAWPOST_ID")
    private Long transferRawpostId;

    @ApiModelProperty(value = "变动后部门职位编号")
    @TableField("TRANSFER_AFTERPOST_ID")
    private Long transferAfterpostId;

    @JsonFormat(pattern="yyyy-MM-dd")
    @TableField("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

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

    // 变动前
    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    // 变动后
    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName2;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName2;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;


}
