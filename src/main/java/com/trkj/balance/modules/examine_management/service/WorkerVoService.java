package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;

import java.util.List;

public interface WorkerVoService extends IService<WorkerVo> {
    //分页查询
    IPage<WorkerVo> findSelectPageWorker(Page<WorkerVo> page, String auditflowTitle,String auditflowdetaiState, String staffName,int staffId);
    //根据id查询
    List<WorkerVo> findSelectById(Long id);

    //根据id查询 废弃sql 步骤条的名称
    List<WorkerVo> findSelectByIdName(Long id);
    //根据id查询申请人的审批
    IPage<WorkerVo> findByIdUser(Page<WorkerVo> page,Long id);
}
