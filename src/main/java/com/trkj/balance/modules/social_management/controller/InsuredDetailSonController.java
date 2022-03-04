package com.trkj.balance.modules.social_management.controller;


import com.trkj.balance.modules.social_management.service.InsuredDetailSonService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/insuredDetailSon")
public class InsuredDetailSonController {

    @Autowired
    private InsuredDetailSonService insuredDetailSonService;

    // 按员工id和月份查询参保明细详情
    @GetMapping("/selectDetailSonId/{id}/{date}")
    public AjaxResponse selectDetailSonId(@PathVariable("id") Long id,@PathVariable("date") String date){
        log.debug("22222222222");
        log.debug(id+"");
        log.debug(date);
        return AjaxResponse.success(insuredDetailSonService.selectInsuredDetailSon(id,date));
    }

}

