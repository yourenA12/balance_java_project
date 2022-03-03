package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.CardVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardVoNService extends IService<CardVo> {

    //查询补打卡详情
    List<CardVo> findSelectCardById(Long id);

}
