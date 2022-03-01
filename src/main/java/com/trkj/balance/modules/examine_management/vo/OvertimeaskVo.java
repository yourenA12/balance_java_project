package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OvertimeaskVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加班表编号")
    @TableId("OVERTIMEASK_ID")
    private Long overtimeaskId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "审批流明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Long auditflowdetailId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId1;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId2;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "发起人部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "加班类型")
    @TableField("OVERTIMEASK_TYPE")
    private String overtimeaskType;

    @ApiModelProperty(value = "加班事由")
    @TableField("OVERTIMEASK_MATTER")
    private String overtimeaskMatter;

    @ApiModelProperty(value = "备注")
    @TableField("OVERTIMEASK_REMARKS")
    private String overtimeaskRemarks;

    @ApiModelProperty(value = "加班开始时间")
    @TableField("OVERTIMEASK_S_DATE")
    private Date overtimeaskSDate;

    @ApiModelProperty(value = "加班结束时间")
    @TableField("OVERTIMEASK_E_DATE")
    private Date overtimeaskEDate;

    @ApiModelProperty(value = "加班总小时")
    @TableField("OVERTIMEASK_TOTAL_DATE")
    private Long overtimeaskTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("OVERTIMEASK_STATE")
    private Long overtimeaskState;

    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;



}
