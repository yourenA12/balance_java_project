package com.trkj.balance.modules.attendance_management.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelVo {
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
    private String staffName;

    @ApiModelProperty(value = "发起人部门")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "出差地点")
    @TableField("TRAVEL_PLACE")
    private String travelPlace;

    @ApiModelProperty(value = "出差事由")
    @TableField("TRAVEL_MATTER")
    private String travelMatter;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "出差开始时间")
    @TableField("TRAVEL_S_DATE")
    private Date travelSDate;

    @JsonFormat(pattern="yyyy-MM-dd")
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
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    //部门名称
    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;
}
