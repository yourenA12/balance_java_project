package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.TranseferVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TransferVoController {
    @Autowired
    private TranseferVoService transeferVoService;

    //根据id查询 人事异动的详情
    @GetMapping("/findSelectTranseferById/{id}")
    public AjaxResponse findSelectTranseferById(@PathVariable("id") Long id){
        return AjaxResponse.success(transeferVoService.findSelectTranseferById(id));
    }
}
