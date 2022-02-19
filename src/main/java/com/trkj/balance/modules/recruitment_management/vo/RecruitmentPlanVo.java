package com.trkj.balance.modules.recruitment_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 招聘计划表
 * </p>
 *
 * @author 友人A
 * @since 2021-12-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentPlanVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "招聘计划名称")
    @TableField("RECRUITMENT_PLAN_NAME")
    private String recruitmentPlanName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "部门职位编号")
    @TableField("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "学历名称")
    @TableField("EDUCATION_NAME")
    private String educationName;

    @ApiModelProperty(value = "需招聘人数")
    @TableField("RECRUITMENT_PLAN_NUMBER")
    private Long recruitmentPlanNumber;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    @TableField("RECRUITMENT_PLAN_START_TIME")
    private Date recruitmentPlanStartTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("RECRUITMENT_PLAN_END_TIME")
    private Date recruitmentPlanEndTime;

    @ApiModelProperty(value = "月薪范围")
    @TableField("RECRUITMENT_PLAN_SALARY_ID")
    private Long recruitmentPlanSalaryId;

    @ApiModelProperty(value = "招聘计划状态: 0 招聘中，1 已结束")
    @TableField("RECRUITMENT_ZT")
    private Long recruitmentZt;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Long deptState;


    @ApiModelProperty(value = "部门负责人;提供ID到员工表锁定具体的人")
    @TableField("STAFF_ID")
    private Long staffId;
    @ApiModelProperty(value = "职位编号")
    @TableId("POSITION_ID")
    private Long positionId;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "职位说明")
    @TableField("POSITION_DESCRIPTION")
    private String positionDescription;

    @ApiModelProperty(value = "月薪起始金额")
    @TableField("MONTHLY_SALARY_STAR")
    private Double monthlySalaryStar;

    @ApiModelProperty(value = "月薪结束金额")
    @TableField("MONTHLY_SALARY_END")
    private Double monthlySalaryEnd;


}
