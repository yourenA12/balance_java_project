package com.trkj.balance.modules.attendance_management.controller;


import com.trkj.balance.modules.attendance_management.service.OvertimeaskService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 加班表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-18
 */
@RestController
@RequestMapping("/overtimeask")
public class OvertimeaskController {

    @Autowired
    public OvertimeaskService overtimeaskService;

    //删除
    @DeleteMapping("/ovedelete/{id}")
    public AjaxResponse Ovedelete(@PathVariable("id") Long id){
        if (overtimeaskService.Overtdelete(id) >=1 ){
            return AjaxResponse.success("成功");
        }else
            return AjaxResponse.success("失败");
    }

}

