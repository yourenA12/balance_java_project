package com.trkj.balance.modules.salary_management.controller;



import com.trkj.balance.modules.salary_management.entity.Dept;
import com.trkj.balance.modules.salary_management.service.DeptSalaryService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@RestController
@RequestMapping("/dept")
public class DeptSalaryController {

    @Autowired
    private DeptSalaryService deptService;

    @GetMapping("/selectAll")
    public AjaxResponse queryCatList(){
        List<Dept> list = deptService.queryList();
        return AjaxResponse.success(list);
    }


}

