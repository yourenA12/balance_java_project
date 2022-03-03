package com.trkj.balance.modules.salary_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WagVo {

    @ApiModelProperty(value = "获奖人编号")
    @TableId("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "职位编号")
    @TableId("POSITION_ID")
    private Long positionId;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "员工状态")
    @TableField("STAFF_STATE")
    private Long staffState;

    @ApiModelProperty(value = "固定工资编号")
    @TableId("FIXEDWAGE_ID")
    private Long fixedwageId;

    @ApiModelProperty(value = "试用期基本工资")
    @TableField("FIXEDWAGE_PERIODMONEY")
    private Double fixedwagePeriodmoney;

    @ApiModelProperty(value = "正式期基本工资")
    @TableField("FIXEDWAGE_OFFICIALMONEY")
    private Double fixedwageOfficialmoney;


    @ApiModelProperty(value = "工作日加班工资")
    @TableField(exist = false)
    private Double workdayMoney;

    @ApiModelProperty(value = "节假日加班工资")
    @TableField(exist = false)
    private Double holidaysMoney;

    @ApiModelProperty(value = "休息日加班工资")
    @TableField(exist = false)
    private Double restMoney;

    @ApiModelProperty(value = "工资合计")
    @TableField(exist = false)
    private Double totalWages;

    @ApiModelProperty(value = "出差")
    @TableField(exist = false)
    private Double evection;

    @ApiModelProperty(value = "迟到")
    @TableField(exist = false)
    private Double tardy;

    @ApiModelProperty(value = "早退")
    @TableField(exist = false)
    private Double leave;

    @ApiModelProperty(value = "旷工")
    @TableField(exist = false)
    private Double absenteeism;

    @ApiModelProperty(value = "病假")
    @TableField(exist = false)
    private Double fallLeave;

    @ApiModelProperty(value = "事假")
    @TableField(exist = false)
    private Double matterLeave;

    @ApiModelProperty(value = "社保个人缴费")
    @TableField("INS_DETAIL_SOCIAL_PERSON_PAY")
    private Double insDetailSocialPersonPay;

    @ApiModelProperty(value = "社保公司缴费")
    @TableField("INS_DETAIL_SOCIAL_FIRM_PAY")
    private Double insDetailSocialFirmPay;

    @ApiModelProperty(value = "积金个人缴费")
    @TableField("INS_DETAIL_FUND_PERSON_PAY")
    private Double insDetailFundPersonPay;

    @ApiModelProperty(value = "积金公司缴费")
    @TableField("INS_DETAIL_FUND_FIRM_PAY")
    private Double insDetailFundFirmPay;

    @ApiModelProperty(value = "应发工资")
    @TableField(exist = false)
    private Double  wagesShould;

    @ApiModelProperty(value = "实发工资")
    @TableField(exist = false)
    private Double  payroll;


}
