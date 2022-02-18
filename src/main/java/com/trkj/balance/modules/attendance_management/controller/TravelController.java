package com.trkj.balance.modules.attendance_management.controller;


import com.trkj.balance.modules.attendance_management.service.TravelService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 出差表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-23
 */
@RestController
@RequestMapping("/travel")
public class TravelController {
    @Autowired
    public TravelService travelService;

    //删除
    @DeleteMapping("/Traveldelete/{id}")
    public AjaxResponse Traveldelete(@PathVariable("id") Long id){
        if (travelService.Traveldelete(id) >=1 ){
            return AjaxResponse.success("成功");
        }else
            return AjaxResponse.success("失败");
    }

}

