package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.trkj.balance.modules.employee_management.vo.PunishVo;

import java.util.ArrayList;

public interface PunishVoService extends IService<PunishVo> {

    //分页查询惩罚表数据
    IPage<PunishVo> selectPunishPage(IPage<PunishVo> page, String staffName, ArrayList deptIds);

}
