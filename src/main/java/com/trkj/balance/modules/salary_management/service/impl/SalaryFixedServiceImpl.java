package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.mapper.FixedwageMapper;
import com.trkj.balance.modules.salary_management.entity.Salary;
import com.trkj.balance.modules.salary_management.mapper.SalaryFixedMapper;
import com.trkj.balance.modules.salary_management.service.SalaryFixedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 调薪表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-21
 */
@Service
public class SalaryFixedServiceImpl extends ServiceImpl<SalaryFixedMapper, Salary> implements SalaryFixedService {

    //调薪表
    @Autowired
    private SalaryFixedMapper salaryFixedMapper;

    //固定工资表
    @Autowired
    private FixedwageMapper fixedwageMapper;

    //添加调薪表
    @Override
    @Transactional
    public int insertFixedwage(Salary salary,Fixedwage fixedwage) {
        if(salaryFixedMapper.insert(salary)>0){
            return fixedwageMapper.updateById(fixedwage);
        }
        return 0;
    }

    //查询调薪记录
    @Override
    public IPage<Salary> selectSalaryPage(IPage<Salary> page,String staffName) {
        QueryWrapper wrapper=new QueryWrapper();

        if(staffName!="" && staffName!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("st.STAFF_NAME",staffName);
        }
        return salaryFixedMapper.selectSalaryPage(page,wrapper);
    }
}
