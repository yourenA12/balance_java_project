package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.FixedVoMapper;
import com.trkj.balance.modules.examine_management.service.FixedVoService;
import com.trkj.balance.modules.examine_management.vo.FixedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedVoServiceImpl extends ServiceImpl<FixedVoMapper, FixedVo> implements FixedVoService {
    //注入Vomapper
    @Autowired
    private FixedVoMapper fixedVoMapper;

    @Override
    public List<FixedVo> findSelectByIdFix(Long id) {
        return fixedVoMapper.findSelectByidFix(id);
    }
}
