package com.trkj.balance.modules.salary_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WagenotfiledVo {

    @ApiModelProperty(value = "薪酬组")
    @TableField("COMPENSATION_ID")
    private Long compensationId;

//    @ApiModelProperty(value = "薪酬组人数")
//    @TableField("COMPENSATION_NUMBER")
//    private Long compensationNumber;
//
//    @ApiModelProperty(value = "应发工资")
//    @TableField(exist = false)
//    private Double  wagesShould;
//
//    @ApiModelProperty(value = "实发工资")
//    @TableField(exist = false)
//    private Double  payroll;
//
//    @ApiModelProperty(value = "公司缴纳")
//    @TableField(exist = false)
//    private Double  companyMoney;

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

    @ApiModelProperty(value = "状态;0：未归档，1：已归档")
    @TableField("WAGENOTFILED_STATE")
    private Long wagenotfiledState;

    @ApiModelProperty(value = "薪酬组名称")
    @TableField("COMPENSATION_NAME")
    private String compensationName;

}
