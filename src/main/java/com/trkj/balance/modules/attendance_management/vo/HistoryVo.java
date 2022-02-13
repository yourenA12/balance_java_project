package com.trkj.balance.modules.attendance_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryVo {

    @ApiModelProperty(value = "归档编号")
    @TableId("ARCHIVE_ID")
    private Long archiveId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门名称")
    @TableField("CLSS_NAME")
    private String clssName;

    @ApiModelProperty(value = "正常次数")
    @TableField("NORMAL_FREQUENCY")
    private Long normalFrequency;

    @ApiModelProperty(value = "迟到次数")
    @TableField("LATE_FREQUENCY")
    private Long lateFrequency;

    @ApiModelProperty(value = "旷工次数")
    @TableField("ABSENTEEISM_FREQUENCY")
    private Long absenteeismFrequency;

    @ApiModelProperty(value = "早退次数")
    @TableField("LEAVE_EARLY_FREQUENCY")
    private Long leaveEarlyFrequency;

    @ApiModelProperty(value = "是否全勤")
    @TableField("PRESENT")
    private String present;

    @TableField("REVISION")
    private Long revision;

    @TableField("IS_DELETED")
    private Long isDeleted;

    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("UPDATED_TIME")
    private Date updatedTime;
}
