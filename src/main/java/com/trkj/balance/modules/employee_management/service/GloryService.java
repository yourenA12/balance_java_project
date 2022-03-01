package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface GloryService extends IService<Glory> {
    //查询奖励表信息
    List<Glory> selectGloryId(Long id);

    //修改荣誉/奖励信息
    int updateGlory(Glory glory);

    //删除荣誉/奖励信息
    int deleteGlory(Long id);

    //添加荣誉/奖励信息
    int insertGlory(Glory glory);


}
