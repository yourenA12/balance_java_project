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
 * 参保方案部门职位中间表
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_DEPT_POST")
@ApiModel(value="InsuredDeptPost对象", description="参保方案部门职位中间表")
@KeySequence(value = "INSURED_DEPT_POST_ID",clazz = Long.class)
public class InsuredDeptPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参保方案部门职位中间表编号")
    @TableId("INSURED_DEPT_POST_ID")
    private Long insuredDeptPostId;

    @ApiModelProperty(value = "部门职位id")
    @TableField("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "默认参保方案id")
    @TableField("DEF_INSURED_ID")
    private Long defInsuredId;

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
