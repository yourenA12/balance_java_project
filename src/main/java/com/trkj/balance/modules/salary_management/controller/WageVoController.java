package com.trkj.balance.modules.salary_management.controller;

import com.trkj.balance.modules.salary_management.service.WageVoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/WageVo")
public class WageVoController {

    @Autowired
    private WageVoService wageVoService;
}
