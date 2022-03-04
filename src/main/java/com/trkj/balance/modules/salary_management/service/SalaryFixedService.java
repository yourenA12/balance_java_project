package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.salary_management.entity.Salary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 调薪表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-21
 */
public interface SalaryFixedService extends IService<Salary> {

    //添加调薪表
    int insertFixedwage(Salary salary,Fixedwage fixedwage);

    //查询调薪记录
    IPage<Salary> selectSalaryPage(IPage<Salary> page,String staffName);


}
