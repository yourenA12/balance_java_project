package com.trkj.balance.modules.attendance_management.controller;


import com.trkj.balance.modules.attendance_management.service.impl.LeaveServiceImpl;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 请假表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-22
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    public LeaveServiceImpl leaveService;

    //删除
    @DeleteMapping("/Leadelete/{id}")
    public AjaxResponse Ovedelete(@PathVariable("id") Long id){
        if (leaveService.Leavedelete(id) >=1 ){
            return AjaxResponse.success("成功");
        }else
            return AjaxResponse.success("失败");
    }

}

