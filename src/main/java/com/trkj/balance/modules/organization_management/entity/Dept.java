package com.trkj.balance.modules.organization_management.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPT")
@ApiModel(value="Dept对象", description="部门表")
@KeySequence(value = "DEPT_ID",clazz = Long.class) // id 自增
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "上级部门编号")
    @TableField("SUPERIOR_DEPT_ID")
    private Long deptPid;

    @ApiModelProperty(value = "状态;0：启用  1：禁用")
    @TableField("DEPT_STATE")
    private Long deptState;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "部门负责人;提供ID到员工表锁定具体的人")
    @TableField("STAFF_ID")
    private Long staffId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @TableField(exist = false)
    private List<Dept> children =new ArrayList<>();



}
