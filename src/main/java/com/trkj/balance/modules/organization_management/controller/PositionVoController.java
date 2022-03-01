package com.trkj.balance.modules.organization_management.controller;

import com.trkj.balance.modules.organization_management.service.PositionVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/positionVo")
@Slf4j
public class PositionVoController {

    @Autowired
    public PositionVoService positionVoService;


}
