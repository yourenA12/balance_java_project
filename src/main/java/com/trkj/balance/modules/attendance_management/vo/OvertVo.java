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
public class OvertVo {


    @ApiModelProperty(value = "加班表编号")
    @TableId("OVERTIMEASK_ID")
    private Long overtimeaskId;


    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "加班开始时间")
    @TableField("OVERTIMEASK_S_DATE")
    private Date overtimeaskSDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "加班结束时间")
    @TableField("OVERTIMEASK_E_DATE")
    private Date overtimeaskEDate;

    @ApiModelProperty(value = "加班总小时")
    @TableField("OVERTIMEASK_TOTAL_DATE")
    private Long overtimeaskTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("OVERTIMEASK_STATE")
    private Long overtimeaskState;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd")
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
