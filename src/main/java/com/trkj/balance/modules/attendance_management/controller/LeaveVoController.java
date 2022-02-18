package com.trkj.balance.modules.attendance_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.attendance_management.service.LeaveVoService;
import com.trkj.balance.modules.attendance_management.vo.LeaveVo;
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
@RequestMapping("/LeaveVo")
public class LeaveVoController {
    @Autowired
    public LeaveVoService leaveVoService;

    //查询
    @GetMapping("inquire")
    public AjaxResponse Leave(@RequestParam("currenPage") int page, @RequestParam("pagesize") int size,
                              @RequestParam("staffName") String staffName,@RequestParam("optionsDeptId") Object optionsDeptId,
                              @RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                              @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd ) {
        IPage<LeaveVo> ss = leaveVoService.selsectLeave(page, size, staffName ,optionsDeptId,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(ss);
    }

    //查询所有部门
    @GetMapping("/Dept")
    public AjaxResponse Dept() {
        return AjaxResponse.success(leaveVoService.selectDept());

    }

}
