package com.trkj.balance.modules.organization_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.organization_management.entity.Dept;
import com.trkj.balance.modules.organization_management.service.DeptService;
import com.trkj.balance.modules.organization_management.service.impl.DeptServiceImpl;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-10
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    public DeptService deptService;

    //部门分页查询
    @DeleteMapping("/dept/{currenPage}/{currenPage}")
    public AjaxResponse inquire(@PathVariable("currenPage") int page, @PathVariable("currenPage") int pagesize){
        Page<Dept> pageable = new Page<>(page, pagesize);
        IPage<Dept> page1 = deptService.deptfy(pageable);
        return AjaxResponse.success(page1);
    }

}

