package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.vo.GloryVo;

import java.util.ArrayList;

public interface GloryVoService extends IService<GloryVo> {

    //分页查询奖励表
    IPage<GloryVo> selectGloryPage(IPage<GloryVo> page, String staffName, ArrayList deptIds);


}
