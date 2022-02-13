package com.trkj.balance.modules.attendance_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.attendance_management.service.TravelVoService;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/TravelVo")
public class TravelVoController {
    @Autowired
    public TravelVoService travelVoService;

    @GetMapping("/Trainquire")
    public AjaxResponse Trainquire(@RequestParam("currenPage") int page, @RequestParam("pagesize") int size
                                    ,@RequestParam("staffName") String staffName,@RequestParam("optionsDeptId") Object optionsDeptId
                                    ,@RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                   @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd){
        IPage<TravelVo> ss = travelVoService.selectTravel(page, size ,staffName,optionsDeptId,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(ss);
    }

    //查询部门部门
    @GetMapping("/Dept")
    public AjaxResponse Dept(){
        return AjaxResponse.success(travelVoService.dept());
    }

}
