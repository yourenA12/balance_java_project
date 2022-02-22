package com.trkj.balance.modules.salary_management.entity;

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
 * 调薪表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SALARY")
@KeySequence(value = "SALARY_ID",clazz = Long.class)
@ApiModel(value="Salary对象", description="调薪表")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调薪编号")
    @TableId("SALARY_ID")
    private Long salaryId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "调薪原因")
    @TableField("SALARY_CAUSE")
    private String salaryCause;

    @ApiModelProperty(value = "调薪前基本工资")
    @TableField("FRONT_SALARY")
    private Double frontSalary;

    @ApiModelProperty(value = "调薪后基本工资")
    @TableField("AFTER_SALARY")
    private Double afterSalary;

    @ApiModelProperty(value = "操作人")
    @TableField("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "备注")
    @TableField("SALARY_REMARKS")
    private String salaryRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("SALARY_STATE")
    private Long salaryState;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生效日期")
    @TableField("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd")
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

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;


}
