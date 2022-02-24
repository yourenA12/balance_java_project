package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.QuitVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuitVoController {
    @Autowired
    private QuitVoService quitVoService;

    @GetMapping("/findSelectByid/{id}")
    public AjaxResponse finSelectByid(@PathVariable("id")Long id){

        return AjaxResponse.success(quitVoService.findSelectById(id));
    }
}
