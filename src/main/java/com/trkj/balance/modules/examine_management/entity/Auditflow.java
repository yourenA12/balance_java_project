package com.trkj.balance.modules.examine_management.entity;

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
 * 审批主表
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AUDITFLOW")
@ApiModel(value="Auditflow对象", description="审批主表")
@KeySequence(value = "AUDITFLOW_ID",clazz = Long.class)
public class Auditflow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批编号")
    @TableId("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "标题")
    @TableField("AUDITFLOW_TITLE")
    private String auditflowTitle;

    @ApiModelProperty(value = "审批类型")
    @TableField("AUDITFLOW_TYPE")
    private String auditflowType;

    @ApiModelProperty(value = "申请人编号（员工表/员工编号）")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "申请人")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "申请状态")
    @TableField("AUDITFLOW_STATE")
    private Long auditflowState;

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
