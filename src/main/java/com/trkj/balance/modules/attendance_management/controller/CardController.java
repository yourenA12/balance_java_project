package com.trkj.balance.modules.attendance_management.controller;


import com.trkj.balance.modules.attendance_management.service.CardService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 补打卡表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-02-05
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    public CardService cardService;

    //删除
    @DeleteMapping("/Traveldelete/{id}")
    public AjaxResponse Carddelete(@PathVariable("id") Long id){
        if (cardService.Carddelete(id) >=1 ){
            return AjaxResponse.success("成功");
        }else
            return AjaxResponse.success("失败");
    }

}

