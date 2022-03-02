package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.travelNVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TravelVoNController {
    //注入service
    @Autowired
    private travelNVoService travelNVoService;
    //通过id 查询 审批数据的详情信息
    @GetMapping("/findSelecttravelById/{id}")
    public AjaxResponse findSelectPageById(@PathVariable("id") Long id){
        return AjaxResponse.success(travelNVoService.findSelectTravelVoById(id));
    }
}
