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
 * 薪酬组表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COMPENSATION")
@KeySequence(value = "COMPENSATION_ID",clazz = Long.class)
@ApiModel(value="Compensation对象", description="薪酬组表")
public class Compensation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "薪酬组编号")
    @TableId("COMPENSATION_ID")
    private Long compensationId;

    @ApiModelProperty(value = "薪酬组名称")
    @TableField("COMPENSATION_NAME")
    private String compensationName;

    @ApiModelProperty(value = "加班工资方案id")
    @TableField("WORKSCHEME_ID")
    private Long workschemeId;

    @ApiModelProperty(value = "考勤扣款方案id")
    @TableField("ATTENDANDCE_ID")
    private Long attendandceId;

    @ApiModelProperty(value = "出差方案id")
    @TableField("BUSINESS_ID")
    private Long businessId;

    @ApiModelProperty(value = "备注")
    @TableField("COMPENSATION_REMARK")
    private String compensationRemark;

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
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
