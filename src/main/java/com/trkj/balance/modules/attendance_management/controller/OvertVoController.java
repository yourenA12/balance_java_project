package com.trkj.balance.modules.attendance_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.service.OvertVoService;
import com.trkj.balance.modules.attendance_management.vo.OvertVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/OvertVo")
public class OvertVoController {
    @Autowired
    public OvertVoService overtVoService;

    @GetMapping("/ovfy")
    public AjaxResponse ovpaging (@RequestParam("currenPage") int page, @RequestParam("pagesize") int size
                              ,@RequestParam("staffName") String staffName,@RequestParam("optionsDeptId") Object optionsDeptId
                                ,@RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                  @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd){
        IPage<OvertVo> ss = overtVoService.selectOvert(page,size,staffName,optionsDeptId,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(ss);
    }

    //查询所有部门
    @GetMapping("/Dept")
    public AjaxResponse Dept(){
        return AjaxResponse.success(overtVoService.selectDept());
    }


}
