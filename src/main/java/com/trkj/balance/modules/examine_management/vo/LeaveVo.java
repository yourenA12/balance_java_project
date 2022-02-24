package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.*;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "标题")
    @TableField("AUDITFLOW_TITLE")
    private String auditflowTitle;

    @ApiModelProperty(value = "审批类型")
    @TableField("AUDITFLOW_TYPE")
    private String auditflowType;

    @ApiModelProperty(value = "申请人编号（员工表/员工编号）")
    @TableField("STAFF_ID")
    private Long staffId1;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "申请状态")
    @TableField("AUDITFLOW_STATE")
    private Long auditflowState;


    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "请假事由")
    @TableField("LEAVE_MATTER")
    private String leaveMatter;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "请假开始时间")
    @TableField("LEAVE_S_DATE")
    private Date leaveSDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "请假结束时间")
    @TableField("LEAVE_E_DATE")
    private Date leaveEDate;

    @ApiModelProperty(value = "请假总小时")
    @TableField("LEAVE_TOTAL_DATE")
    private Long leaveTotalDate;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;


    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId2;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "备注")
    @TableField("LEAVE_REMARKS")
    private String leaveRemarks;


}
