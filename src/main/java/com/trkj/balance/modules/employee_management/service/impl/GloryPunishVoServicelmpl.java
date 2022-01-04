package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.mapper.EntryhirdeVoMapper;
import com.trkj.balance.modules.employee_management.mapper.GloryPunishVoMapper;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import com.trkj.balance.modules.employee_management.service.GloryPunishVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GloryPunishVoServicelmpl extends ServiceImpl<GloryPunishVoMapper, GloryPunishVo> implements GloryPunishVoService {
    @Autowired
    private GloryPunishVoMapper gloryPunishVoMapper;

    @Override
    public IPage<GloryPunishVo> selectGloryPunish(IPage<GloryPunishVo> page) {
        return gloryPunishVoMapper.selectGloryPunish(page);
    }
}
