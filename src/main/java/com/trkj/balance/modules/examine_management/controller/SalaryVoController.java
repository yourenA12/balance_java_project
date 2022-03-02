package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.SalaryVoService;
import com.trkj.balance.modules.examine_management.service.TranseferVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SalaryVoController {
    @Autowired
    private SalaryVoService salaryVoService;

    //根据id查询调薪详情
    @GetMapping("/findSelectSalaryById/{id}")
    public AjaxResponse findSelectSalaryById(@PathVariable("id") Long id){
        return AjaxResponse.success(salaryVoService.findSelectSalaryById(id));
    }
}
