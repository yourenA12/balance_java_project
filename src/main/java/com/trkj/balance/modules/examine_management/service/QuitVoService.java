package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.QuitnVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuitVoService extends IService<QuitnVo> {
    //根据id查询离职表的详情
    List<QuitnVo> findSelectById(Long id);
}
