package com.trkj.balance.modules.social_management.entity;

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
 * 参保方案员工中间表
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_STAFF")
@ApiModel(value="InsuredStaff对象", description="参保方案员工中间表")
@KeySequence(value = "INSURED_STAFF_ID",clazz = Long.class)
public class InsuredStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "薪酬组员工中间表编号")
    @TableId("INSURED_STAFF_ID")
    private Long insuredStaffId;

    @ApiModelProperty(value = "员工id")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "默认参保方案id")
    @TableField("DEF_INSURED_ID")
    private Long defInsuredId;

    @ApiModelProperty(value = "微调参保方案id")
    @TableField("TRI_INSURED_ID")
    private Long triInsuredId;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
