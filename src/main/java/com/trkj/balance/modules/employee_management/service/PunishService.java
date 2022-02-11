package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.entity.Punish;

import java.util.List;

public interface PunishService extends IService<Punish> {

    //查询惩罚表信息
    List<Punish> selectPunishId(Long id);

    //修改惩罚表信息
    int updatePunish(Punish punish);

    //添加惩罚表信息
    int insertPunish(Punish punish);

    //删除惩罚表信息
    int deletePunishId(Long id);

}
