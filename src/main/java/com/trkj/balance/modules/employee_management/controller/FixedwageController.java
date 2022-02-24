package com.trkj.balance.modules.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.service.FixedwageService;
import com.trkj.balance.modules.salary_management.entity.Attendandce;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 固定工资表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-01-25
 */
@RestController
@RequestMapping("/fixedwage")
public class FixedwageController {

    @Autowired
    private FixedwageService fixedwageService;

    //查询固定工资
    @GetMapping("/selectFixedwage")
    public AjaxResponse selectFixedwage(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                        @RequestParam("staffNameSearch") String staffNameSearch,
                                        @RequestParam("deptIds") ArrayList deptIds,
                                        @RequestParam("postSearch") String postSearch){

        Page<Fixedwage> page = new Page<>(currenPage,pagesize);
        IPage<Fixedwage> list=fixedwageService.selectFixedwagePage(page,staffNameSearch,deptIds,postSearch);
        return AjaxResponse.success(list);

    }



}

