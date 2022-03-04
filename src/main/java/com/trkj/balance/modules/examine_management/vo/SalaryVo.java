package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调薪编号")
    @TableId("SALARY_ID")
    private Long salaryId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "审批流明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Long auditflowdetailId;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId1;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName2;

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

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "备注")
    @TableField("SALARY_REMARKS")
    private String salaryRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("SALARY_STATE")
    private Long salaryState;

    @ApiModelProperty(value = "生效日期")
    @TableField("TAKE_EFFECT_DATE")
    private Date takeEffectDate;

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
