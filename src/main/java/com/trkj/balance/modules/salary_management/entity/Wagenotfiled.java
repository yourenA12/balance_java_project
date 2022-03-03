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
 * 工资未归档表
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WAGENOTFILED")
@KeySequence(value = "WAGENOTFILED_ID",clazz = Long.class)
@ApiModel(value="Wagenotfiled对象", description="工资未归档表")
public class Wagenotfiled implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工资归档编号")
    @TableId("WAGENOTFILED_ID")
    private Long wagenotfiledId;

    @ApiModelProperty(value = "薪酬组")
    @TableField("COMPENSATION_ID")
    private Long compensationId;

    @ApiModelProperty(value = "计薪人数")
    @TableField("WAGENOTFILED_ASKPERSON")
    private Long wagenotfiledAskperson;

    @ApiModelProperty(value = "应发工资")
    @TableField("WAGENOTFILED_SALARY")
    private Double wagenotfiledSalary;

    @ApiModelProperty(value = "实发工资")
    @TableField("WAGENOTFILED_PAYROLLSALARY")
    private Double wagenotfiledPayrollsalary;

    @ApiModelProperty(value = "公司缴纳")
    @TableField("WAGENOTFILED_FIRMPAYMENT")
    private Double wagenotfiledFirmpayment;

    @ApiModelProperty(value = "员工成本")
    @TableField("WAGENOTFILED_STAFFCOST")
    private Double wagenotfiledStaffcost;

    @ApiModelProperty(value = "日期")
    @TableField("WAGENOTFILED_DATE")
    private Date wagenotfiledDate;

    @ApiModelProperty(value = "状态;0：未归档，1：已归档")
    @TableField("WAGENOTFILED_STATE")
    private Long wagenotfiledState;

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

//    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

}
