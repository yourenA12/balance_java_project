package com.trkj.balance.modules.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考勤表
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ATTENDANCE_SHEET")
@ApiModel(value="AttendanceSheet对象", description="考勤表")
public class AttendanceSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤编号")
    @TableId("ATTENDANCE_SHEET_ID")
    private Long attendanceSheetId;

    @ApiModelProperty(value = "打卡记录编号")
    @TableField("CLOCK_RECORD_ID")
    private Long clockRecordId;

    @ApiModelProperty(value = "考勤状态")
    @TableField("CHECK_STATE")
    private String checkState;

    @ApiModelProperty(value = "考勤扣款编号")
    @TableField("CHECK_DEDUCT_ID")
    private Long checkDeductId;

    @ApiModelProperty(value = "班次方案编号")
    @TableField("CLASSES_ID")
    private Long classesId;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
