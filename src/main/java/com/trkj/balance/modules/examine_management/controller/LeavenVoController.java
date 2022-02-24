package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.LeavenVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class LeavenVoController {
    //注入
    @Autowired
    private LeavenVoService leavenVoService;
    //根据id查询 人事异动的详情
    @GetMapping("/findeSeelectById/{id}")
    public AjaxResponse findeSeelectById(@PathVariable("id") Long id){
        return AjaxResponse.success(leavenVoService.findeSeelectById(id));
    }
}
