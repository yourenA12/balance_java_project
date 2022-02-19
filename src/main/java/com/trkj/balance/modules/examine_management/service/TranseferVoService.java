package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.TransferVo;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TranseferVoService extends IService<TransferVo> {
    //根据id 查询人事异动的详情
    List<TransferVo> findSelectTranseferById(Long id);
}
