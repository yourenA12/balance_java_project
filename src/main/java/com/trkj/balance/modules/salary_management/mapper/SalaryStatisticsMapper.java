package com.trkj.balance.modules.salary_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 薪酬统计
@Mapper
public interface SalaryStatisticsMapper extends BaseMapper<com.trkj.balance.modules.salary_management.vo.salaryStatisticsVo> {

    // 薪酬统计
    @Select("select TO_CHAR(CREATED_TIME,'yyyy-MM') month,COUNT(wagenotfiled_askperson) askperson,SUM(wagenotfiled_salary) salary,\n" +
            "SUM(wagenotfiled_payrollsalary) payrollsalary,SUM(wagenotfiled_firmpayment) firmpayment\n" +
            "from wagenotfiled where WAGENOTFILED_STATE=0 GROUP BY TO_CHAR(CREATED_TIME,'yyyy-MM') ORDER BY TO_CHAR(CREATED_TIME,'yyyy-MM') desc")
    List<com.trkj.balance.modules.salary_management.vo.salaryStatisticsVo> salaryStatistics();

    //查询工资已归档
    @Select("select * from COMPENSATION c LEFT JOIN WAGENOTFILED w on c.COMPENSATION_ID=w.COMPENSATION_ID \n" +
            "where w.WAGENOTFILED_STATE=0 and TO_CHAR(w.CREATED_TIME,'yyyy-MM') = TO_CHAR(TO_DATE(#{date}, 'yyyy-MM'),'yyyy-MM')")
    List<WagenotfiledVo> selectWagenotfiledVo(String date);


}
