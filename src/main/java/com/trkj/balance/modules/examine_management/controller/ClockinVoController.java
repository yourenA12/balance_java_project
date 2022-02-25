package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.ClockinVoService;
import com.trkj.balance.modules.examine_management.vo.ClockinVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ClockinVoController {

    @Autowired
    public ClockinVoService clockVoService;

    //查询
    @GetMapping("/card/{id}")
    public AjaxResponse dk(@PathVariable("id") Long id){
        return AjaxResponse.success(clockVoService.daka(id));

    }

}
