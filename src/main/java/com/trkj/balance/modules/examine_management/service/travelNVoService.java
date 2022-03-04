package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.travelVo;

import java.util.List;

public interface travelNVoService extends IService<travelVo> {
    //根据id查询出差表
    List<travelVo> findSelectTravelVoById(Long id);

}
