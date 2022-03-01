package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.FixedVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FixedVoController {

    //注入service
    @Autowired
    private FixedVoService fixedVoService;

    @GetMapping("/findSelectByIdFix/{id}")
    public AjaxResponse findSelectByIdFix(@PathVariable("id") Long id){
        return AjaxResponse.success(fixedVoService.findSelectByIdFix(id));
    }
}
