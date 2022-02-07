package com.trkj.balance.modules.employee_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/entryhirdeVo")
public class EntryhirdeVoController {

    @Autowired
    private EntryhirdeVoService entryhirdeVoService;

    //查询待入职员工
    @GetMapping("/selectEntryhirdeVo")
    public AjaxResponse selectEntryhirdeVo(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                           @RequestParam("staffNameSearch") String staffNameSearch,
                                           @RequestParam("deptSearch") String deptSearch,
                                           @RequestParam("postSearch") String postSearch,
                                           @RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                           @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd){

        Page<EntryhirdeVo> page = new Page<>(currenPage,pagesize);
        IPage<EntryhirdeVo> list=entryhirdeVoService.selectEntryhirde1(page,staffNameSearch,deptSearch,postSearch,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(list);

    }


    //查询放弃入职员工
    @GetMapping("/selectEntryhirdeVoFQ")
    public AjaxResponse selectEntryhirdeVoFQ(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                             @RequestParam("staffNameSearch") String staffNameSearch,
                                             @RequestParam("deptSearch") String deptSearch,
                                             @RequestParam("postSearch") String postSearch){

        Page<EntryhirdeVo> page = new Page<>(currenPage,pagesize);
        IPage<EntryhirdeVo> list=entryhirdeVoService.selectEntryhirdeFQ(page,staffNameSearch,deptSearch,postSearch);
        return AjaxResponse.success(list);

    }
}
