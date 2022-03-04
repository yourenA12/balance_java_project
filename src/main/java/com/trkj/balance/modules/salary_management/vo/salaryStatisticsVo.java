package com.trkj.balance.modules.salary_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 薪酬统计
@Data
@AllArgsConstructor
@NoArgsConstructor
public class salaryStatisticsVo {

    @TableField(exist = false)
    private String month; // 计薪月份

    @TableField(exist = false)
    private int askperson; // 计薪人数

    @TableField(exist = false)
    private double  salary; // 应发工资

    @TableField(exist = false)
    private double payrollsalary ; // 实发工资

    @TableField(exist = false)
    private double firmpayment ; // 公司缴纳


}
