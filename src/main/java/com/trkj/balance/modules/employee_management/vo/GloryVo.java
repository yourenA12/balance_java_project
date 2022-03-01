package com.trkj.balance.modules.employee_management.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence(value = "GLORY_ID",clazz = Long.class)
@ApiModel(value="Glory对象", description="荣誉/奖励表")
public class GloryVo {
    @ApiModelProperty(value = "荣誉/奖励编号")
    @TableId("GLORY_ID")
    private Long gloryId;

    @ApiModelProperty(value = "荣誉/奖励名称")
    @TableField("GLORY_NAME")
    private String gloryName;

    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "颁发单位名称")
    @TableField("GLORY_UNITNAME")
    private String gloryUnitname;

    @ApiModelProperty(value = "备注")
    @TableField("GLORY_REMARK")
    private String gloryRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @Version // 乐观锁注解
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;
}
