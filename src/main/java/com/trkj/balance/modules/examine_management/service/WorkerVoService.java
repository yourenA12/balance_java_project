package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface WorkerVoService extends IService<WorkerVo> {
    IPage<WorkerVo> findSelectPageWorker(Page<WorkerVo> page);
    List<WorkerVo> findSelectById(Long id);
}
