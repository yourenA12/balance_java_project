package com.trkj.balance.modules.attendance_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.service.ClockRecordService;
import com.trkj.balance.modules.attendance_management.service.ClockVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.trkj.balance.modules.attendance_management.vo.ClockVo;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

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
@RequestMapping("/clockVo")
public class ClockVoController {
    @Autowired
    public ClockVoService clockVoService;

    //模糊分页查询 + 搜索
    @GetMapping("/punchcard")
    public AjaxResponse punchcard(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                  @RequestParam("staffName") String staffName, @RequestParam("optionsDeptId") Object optionsDeptId,
                                  @RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                  @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd ){



        IPage<ClockVo> ss = clockVoService.dimsearch(currenPage,pagesize,staffName,optionsDeptId,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(ss);
    }

    //查询所有部门
    @GetMapping("/selectAllDept")
    public AjaxResponse selectAllDept(){
        return AjaxResponse.success(clockVoService.selectAllDept());
    }

}

