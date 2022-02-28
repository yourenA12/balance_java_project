package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.entity.ClockRecord;
import com.trkj.balance.modules.examine_management.service.ClockinssService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClockinssController {

    @Autowired
    public ClockinssService clockinssService;


    //添加
    @PostMapping("/add")
    public AjaxResponse add(@RequestBody ClockRecord clockRecord){

        if (clockinssService.addclock(clockRecord) >=1 ){
            return AjaxResponse.success("成功");
        }
        return AjaxResponse.success("失败");
    }

    //修改
    @PutMapping("/amend")
    public AjaxResponse amend(@RequestBody ClockRecord clockRecord){
        if (clockinssService.amendclock(clockRecord) >=1){
            return AjaxResponse.success("成功");
        }
            return AjaxResponse.success("失败");
    }
}
