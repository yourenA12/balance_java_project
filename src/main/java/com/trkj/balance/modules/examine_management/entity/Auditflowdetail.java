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
 * 审批流明细表
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AUDITFLOWDETAIL")
@KeySequence(value = "AUDITFLOWDETAIL_ID",clazz = Long.class)
@ApiModel(value="Auditflowdetail对象", description="审批流明细表")
public class Auditflowdetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审批流明细编号")
    @TableId("AUDITFLOWDETAIL_ID")
    private Long auditflowdetailId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "审核备注")
    @TableField("AUDITFLOWDETAI_REMARKS")
    private String auditflowdetaiRemarks;

    @ApiModelProperty(value = "审核时间")
    @TableField("AUDITFLOWDETAI_DATE")
    private Date auditflowdetaiDate;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

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
