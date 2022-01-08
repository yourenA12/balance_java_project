package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.balance.modules.examine_management.mapper.WorkerMapper;
import com.trkj.balance.modules.examine_management.mapper.WorkerVoMapper;
import com.trkj.balance.modules.examine_management.service.WorkerService;
import com.trkj.balance.modules.examine_management.service.WorkerVoService;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkerVoServiceImpl extends ServiceImpl<WorkerVoMapper,WorkerVo> implements WorkerVoService {
    @Autowired
    private WorkerVoMapper workerVoMapper;

    @Override
    public IPage<WorkerVo> findSelectPageWorker(Page<WorkerVo> page) {
        return workerVoMapper.findSelectPageWorker(page);
    }

    @Override
    public List<WorkerVo> findSelectById(Long id) {
        return workerVoMapper.findSelectById(id);
    }


}
