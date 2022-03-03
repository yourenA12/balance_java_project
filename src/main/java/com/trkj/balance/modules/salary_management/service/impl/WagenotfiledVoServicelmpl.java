package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.Vo.WagenotfiledVo;
import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;
import com.trkj.balance.modules.salary_management.mapper.WagenotfiledMapper;
import com.trkj.balance.modules.salary_management.mapper.WagenotfiledVoMapper;
import com.trkj.balance.modules.salary_management.service.WagenotfiledService;
import com.trkj.balance.modules.salary_management.service.WagenotfiledVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WagenotfiledVoServicelmpl extends ServiceImpl<WagenotfiledVoMapper, WagenotfiledVo> implements WagenotfiledVoService {
    @Autowired
    private WagenotfiledVoMapper wagenotfiledVoMapper;

    //查询工资未归档
    @Override
    public IPage<WagenotfiledVo> selectWagenotfiledVoPage(IPage<WagenotfiledVo> page) {
        return wagenotfiledVoMapper.selectWagenotfiledVoPage(page);
    }
}
