package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public  class WorkerVoServiceImpl extends ServiceImpl<WorkerVoMapper,WorkerVo> implements WorkerVoService {
    @Autowired
    private WorkerVoMapper workerVoMapper;

    @Override
    public IPage<WorkerVo> findSelectPageWorker(Page<WorkerVo> page,String auditflowTitle,
                                                String auditflowdetaiState,String staffName) {
        // 声明一个条件构造器
        QueryWrapper<WorkerVo> wrapper = new QueryWrapper<>();
        // 审批流程为 (转正,异动,请假等) 的
        wrapper.eq("a.AUDITFLOW_TITLE",auditflowTitle);

        if(auditflowdetaiState.equals("待办")){
            // 审批状态为 ‘待办’ ，就是待办申请
            wrapper.eq("b.AUDITFLOWDETAI_STATE",1);
        }else{
            // 审批状态为 ‘已办’ ，就是已办申请
            wrapper.gt("b.AUDITFLOWDETAI_STATE",1);
        }
        wrapper.eq("a.IS_DELETED",0);
        // 模糊查询申请人名称
        wrapper.like("a.staff_name",staffName);
        //查询 审核人 员工id 为2 的审核人的审批数据// 当前登录人 id
        wrapper.eq("b.staff_id",2);

        return workerVoMapper.findSelectPageWorker(page,wrapper);
    }

    @Override
    public List<WorkerVo> findSelectById(Long id) {
        return workerVoMapper.findSelectById(id);
    }

    @Override
    public List<WorkerVo> findSelectByIdName(Long id) {
        return workerVoMapper.findSelectByIdName(id);
    }


}
