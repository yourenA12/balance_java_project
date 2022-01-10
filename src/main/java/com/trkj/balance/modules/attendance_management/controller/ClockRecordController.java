package com.trkj.balance.modules.attendance_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.service.ClockRecordService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.trkj.balance.modules.attendance_management.vo.ClockVo;

/**
 * <p>
 * 打卡记录表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-06
 */
@Slf4j
@RestController
@RequestMapping("/clockRecord")
public class ClockRecordController {

    @Autowired
    public ClockRecordService clockRecordService;

    //删除
    @DeleteMapping("/delete/{id}")
    public AjaxResponse delete(@PathVariable("id") Long id){
        if (clockRecordService.Clodelete(id) >= 1) {
            return AjaxResponse.success("成功");
        }
            return AjaxResponse.success("失败");
            }





}

