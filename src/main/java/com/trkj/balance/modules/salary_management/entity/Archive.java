package com.trkj.balance.modules.salary_management.entity;

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
 * 月报表归档表
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ARCHIVE")
@ApiModel(value="Archive对象", description="月报表归档表")
public class Archive implements Serializable {

    private static final long serialVersionUID = 1L;

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
