package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.mapper.EntryhirdeVoMapper;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryhirdeVoServicelmpl extends ServiceImpl<EntryhirdeVoMapper, EntryhirdeVo> implements EntryhirdeVoService {

    @Autowired
    private EntryhirdeVoMapper entryhirdeMapper;

    @Override
    public IPage<EntryhirdeVo> selectEntryhirde1(Page<EntryhirdeVo> page) {
        return entryhirdeMapper.selectEntryhirde(page);
    }

    @Override
    public IPage<EntryhirdeVo> selectEntryhirdeFQ(Page<EntryhirdeVo> page) {
        return entryhirdeMapper.selectEntryhirdeFQ(page);
    }
}
