package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.service.WageVoService;
import com.trkj.balance.modules.salary_management.vo.WagVo;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import com.trkj.balance.modules.salary_management.mapper.WagenotfiledVoMapper;
import com.trkj.balance.modules.salary_management.service.WagenotfiledVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WagenotfiledVoServicelmpl extends ServiceImpl<WagenotfiledVoMapper, WagenotfiledVo> implements WagenotfiledVoService {

    // 工资未归档 vo
    @Autowired
    private WagenotfiledVoMapper wagenotfiledVoMapper;

    // 工资 service
    @Autowired
    private WageVoService wageVoService;

    //查询工资未归档
    @Override
    public IPage<WagenotfiledVo> selectWagenotfiledVoPage(IPage<WagenotfiledVo> page) {

        // 查询工资未归档
        IPage<WagenotfiledVo> iPages = wagenotfiledVoMapper.selectWagenotfiledVoPage(page);

        Page<WagVo> page1 = new Page<>(1,999);// 分页

        for (WagenotfiledVo record : iPages.getRecords()) {
            // 查询工资 并计算
            wageVoService.selectWagVo(page1, Math.toIntExact(record.getCompensationId()));
        }

        return wagenotfiledVoMapper.selectWagenotfiledVoPage(page);
    }
}
