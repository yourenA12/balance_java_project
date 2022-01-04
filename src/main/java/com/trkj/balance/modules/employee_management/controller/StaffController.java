package com.trkj.balance.modules.employee_management.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.*;

import com.trkj.balance.modules.employee_management.service.StaffService;
import com.trkj.balance.modules.employee_management.service.StaffVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import com.alibaba.fastjson.JSON; // Map 转实体类


/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffVoService staffVoService;

    //添加员工表
    @PostMapping("/insertStaff")
    private AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {

        Staff staff = JSON.parseObject(JSON.toJSONString(map.get("Staff")), Staff.class); // 取map中的 员工表数据 转换为实体类
        WorkExperience workExperience = JSON.parseObject(JSON.toJSONString(map.get("Work")), WorkExperience.class);
        Education education = JSON.parseObject(JSON.toJSONString(map.get("Education")), Education.class);
        EmploymentTable employmentTable = JSON.parseObject(JSON.toJSONString(map.get("EmploymentTable")), EmploymentTable.class);

        //调用入职方法，
        return AjaxResponse.success(staffService.insertStaff(staff,workExperience,education,employmentTable));
    }

    //查询员工信息
    @GetMapping("/selectStaffVo/{currenPage}/{pagesize}")
    public AjaxResponse selectStaffVo(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<StaffVo> page = new Page<>(currenPage,pagesize);
        IPage<StaffVo> list=staffVoService.selectStaffVo(page);
        return AjaxResponse.success(list);

    }


    }



