package com.trkj.balance.modules.employee_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 离职表
 * </p>
 *
 * @author 林落。
 * @since 2022-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("QUIT")
@KeySequence(value = "QUIT_ID",clazz = Long.class)
@ApiModel(value="Quit对象", description="离职表")
public class Quit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "离职编号")
    @TableId("QUIT_ID")
    private Long quitId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "离职类型")
    @TableField("QUIT_TYPE")
    private String quitType;

    @ApiModelProperty(value = "离职说明")
    @TableField("QUIT_EXPLAIN")
    private String quitExplain;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("QUIT_STATE")
    private Long quitState;

    @ApiModelProperty(value = "申请离职日期")
    @TableField("APPLY_QUIT_DATE")
    private Date applyQuitDate;

    @ApiModelProperty(value = "正式离职日期")
    @TableField("FORMAL_QUIT_DATE")
    private Date formalQuitDate;

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


}
