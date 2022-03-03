package com.trkj.balance.modules.social_management.controller;

import com.trkj.balance.modules.social_management.service.InsuredMonthVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/insuredMonthVo")
public class InsuredMonthVoController {

    @Autowired
    private InsuredMonthVoService insuredMonthVoService;

    //查询社保月度报表
    @GetMapping("/selectinsuredMonthVo")
    public AjaxResponse selectDetailSonId(){
        return AjaxResponse.success(insuredMonthVoService.selectInsuredMonthVo());
    }

}
