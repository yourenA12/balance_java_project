package com.trkj.balance.modules.examine_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.service.WorkerVoService;
import com.trkj.balance.modules.examine_management.vo.AuditflowdataVo;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WorkerVoController {
    @Autowired
    private WorkerVoService workerVoService;

    @GetMapping("/findSelectPageWorker/{currenPage}/{pagesize}")
    public AjaxResponse findSelectPageWorker(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){
        Page<WorkerVo> page = new Page<>(currenPage,pagesize);
        IPage<WorkerVo> list=workerVoService.findSelectPageWorker(page);
        return AjaxResponse.success(list);
    }
    @GetMapping("/findSelectPageById/{id}")
    public AjaxResponse findSelectPageById(@PathVariable("id") Long id){
        return AjaxResponse.success(workerVoService.findSelectById(id));
    }

}
