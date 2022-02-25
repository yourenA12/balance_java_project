package com.trkj.balance.modules.examine_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.service.WorkerVoService;
import com.trkj.balance.modules.examine_management.vo.AuditflowdataVo;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class WorkerVoController {
    @Autowired
    private WorkerVoService workervoService;
    //待办申请分页查询方法 返回ajaxlist
    @GetMapping("/findSelectPageWorker")
    public AjaxResponse findSelectPageWorker(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
        @RequestParam("auditflowTitle") String auditflowTitle,@RequestParam("auditflowdetaiState") String auditflowdetaiState,@RequestParam("staffName") String staffName){
        Page<WorkerVo> page = new Page<>(currenPage,pagesize);
        IPage<WorkerVo> list=workervoService.findSelectPageWorker(page,auditflowTitle,auditflowdetaiState,staffName);
        return AjaxResponse.success(list);
    }
    //通过id 查询 审批数据的详情信息
    @GetMapping("/findSelectPageById/{id}")
    public AjaxResponse findSelectPageById(@PathVariable("id") Long id){
        return AjaxResponse.success(workervoService.findSelectById(id));
    }
/*
    //通过id 查询 查看步骤条的名称
    @GetMapping("/findSelectPageByIdName/{id}")
    public AjaxResponse findSelectPageByIdName(@PathVariable("id") Long id){
        return AjaxResponse.success(workervoService.findSelectById(id));
    }
*/
    //通过id 查询 审批数据的详情信息
    @GetMapping("/findByIdUser/{id}/{currentPage}/{pagesize}")
    public AjaxResponse findByIdUser(@PathVariable("id") Long id,@PathVariable("currentPage") int currenPage, @PathVariable("pagesize") int pagesize){
        Page<WorkerVo> page = new Page<>(currenPage,pagesize);
        IPage<WorkerVo> list=workervoService.findByIdUser(page,id);
        return AjaxResponse.success(list);
    }

//    //修改审批主表的状态
//    @PutMapping("/updateWorkerVo")
//    public AjaxResponse updateWorkerVo(@RequestBody WorkerVo workerVo){
//        return AjaxResponse.success(workerVoService.updateWorkerVo(workerVo));
//    }
}
