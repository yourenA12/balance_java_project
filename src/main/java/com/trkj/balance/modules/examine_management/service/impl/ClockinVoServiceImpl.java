package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.ClockinVoMapper;
import com.trkj.balance.modules.examine_management.service.ClockinVoService;
import com.trkj.balance.modules.examine_management.vo.ClockinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockinVoServiceImpl extends ServiceImpl<ClockinVoMapper, ClockinVo> implements ClockinVoService {

    @Autowired
    public ClockinVoMapper clockVoMapper;

    //查询
    @Override
    public ClockinVo daka(Long id) {
        return clockVoMapper.daka(id);
    }

}
