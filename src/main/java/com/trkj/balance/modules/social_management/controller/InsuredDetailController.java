package com.trkj.balance.modules.social_management.controller;


import com.trkj.balance.modules.social_management.service.InsuredDetailVoService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 参保明细表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-02-28
 */
@RestController
@RequestMapping("/insuredDetail")
public class InsuredDetailController {

    @Autowired
    private InsuredDetailVoService detailVoService;

    // 查询社保缴费明细
    @GetMapping("/selectInsuredDetail")
    public AjaxResponse selectInsuredDetail(){
        return AjaxResponse.success(detailVoService.selectInsuredDetail());
    }

    // 删除参保方案
    @DeleteMapping("/deleteInsuredDetail/{ids}")
    public AjaxResponse deleteInsuredDetail(@PathVariable("ids") List<Integer> ids){
        return AjaxResponse.success(detailVoService.selectInsuredDetail());
    }


}













