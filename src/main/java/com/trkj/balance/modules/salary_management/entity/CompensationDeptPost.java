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
 * 薪酬组部门职位中间表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("COMPENSATION_DEPT_POST")
@KeySequence(value = "COMPENSATION_DEPT_POST_ID",clazz = Long.class)
@ApiModel(value="CompensationDeptPost对象", description="薪酬组部门职位中间表")
public class CompensationDeptPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门职位中间表编号")
    @TableId("COMPENSATION_DEPT_POST_ID")
    private Long compensationDeptPostId;

    @ApiModelProperty(value = "薪酬组编号")
    @TableField("COMPENSATION_ID")
    private Long compensationId;

    @ApiModelProperty(value = "部门职位id")
    @TableField("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "默认参保方案id")
    @TableField("DEF_INSURED_ID")
    private Long defInsuredId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

//    @Version // 乐观锁注解
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
