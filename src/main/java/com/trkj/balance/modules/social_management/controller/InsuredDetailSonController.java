package com.trkj.balance.modules.social_management.controller;


import com.trkj.balance.modules.social_management.service.InsuredDetailSonService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/insuredDetailSon")
public class InsuredDetailSonController {

    @Autowired
    private InsuredDetailSonService insuredDetailSonService;

    @GetMapping("/selectDetailSonId/{id}")
    public AjaxResponse selectDetailSonId(@PathVariable("id") Long id){
        return AjaxResponse.success(insuredDetailSonService.selectInsuredDetailSon(id));
    }

}

