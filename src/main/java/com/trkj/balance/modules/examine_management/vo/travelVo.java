package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class travelVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出差编号")
    @TableId("TRAVEL_ID")
    private Long travelId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;


    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName1;


    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName2;

    @ApiModelProperty(value = "发起人部门")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "出差地点")
    @TableField("TRAVEL_PLACE")
    private String travelPlace;

    @ApiModelProperty(value = "出差事由")
    @TableField("TRAVEL_MATTER")
    private String travelMatter;

    @ApiModelProperty(value = "出差开始时间")
    @TableField("TRAVEL_S_DATE")
    private Date travelSDate;

    @ApiModelProperty(value = "出差结束时间")
    @TableField("TRAVEL_E_DATE")
    private Date travelEDate;

    @ApiModelProperty(value = "出差总时长")
    @TableField("TRAVEL_TOTAL_DATE")
    private Long travelTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRAVEL_STATE")
    private Long travelState;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

}
