package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.Vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.Salary;

public interface WageVoService extends IService<WagVo> {

    //查询工资表
    IPage<WagVo> selectWagVo(IPage<WagVo> page,int compensationId);
}
