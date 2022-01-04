package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;
import org.springframework.stereotype.Service;


public interface GloryPunishVoService extends IService<GloryPunishVo> {

    IPage<GloryPunishVo> selectGloryPunish (IPage<GloryPunishVo> page);
}
