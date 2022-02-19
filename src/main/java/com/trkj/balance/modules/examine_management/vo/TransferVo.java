package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调动记录编号")
    @TableId("TRANSFER_ID")
    private Long transferId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId1;

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

    @TableField("TAKE_EFFECT_DATE")
    private Date takeEffectDate;


    @ApiModelProperty(value = "标题")
    @TableField("AUDITFLOW_TITLE")
    private String auditflowTitle;

    @ApiModelProperty(value = "审批类型")
    @TableField("AUDITFLOW_TYPE")
    private String auditflowType;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName1;


    @ApiModelProperty(value = "申请状态")
    @TableField("AUDITFLOW_STATE")
    private Long auditflowState;

    @ApiModelProperty(value = "审批流明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Long auditflowdetailId;


    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId2;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "审核备注")
    @TableField("AUDITFLOWDETAI_REMARKS")
    private String auditflowdetaiRemarks;

    @ApiModelProperty(value = "审核时间")
    @TableField("AUDITFLOWDETAI_DATE")
    private Date auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

    //职位编号
    @TableField("POSITION_ID")
    private Long positionId;
    //职位名称
    @TableField("POSITION_NAME")
    private String positionName;
    //部门名称
    @TableField("DEPT_NAME")
    private String deptName;
    //变动后部门名称
    @TableField("DEPT_NAME")
    private String deptName1;


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
    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

}
