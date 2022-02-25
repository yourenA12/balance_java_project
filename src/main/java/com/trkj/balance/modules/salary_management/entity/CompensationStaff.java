package com.trkj.balance.modules.salary_management.entity;

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
 * 薪酬组员工中间表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COMPENSATION_STAFF")
@KeySequence(value = "COMPENSATION_STAFF_ID",clazz = Long.class)
@ApiModel(value="CompensationStaff对象", description="薪酬组员工中间表")
public class CompensationStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "薪酬组员工中间表编号")
    @TableId("COMPENSATION_STAFF_ID")
    private Long compensationStaffId;

    @ApiModelProperty(value = "薪酬组编号")
    @TableField("COMPENSATION_ID")
    private Long compensationId;

    @ApiModelProperty(value = "员工id")
    @TableField("STAFF_ID")
    private Long staffId;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
