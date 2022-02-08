package com.trkj.balance.modules.salary_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;
import com.trkj.balance.modules.salary_management.service.CompensationDeptPostService;
import com.trkj.balance.modules.salary_management.service.CompensationService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 薪酬组表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@RestController
@RequestMapping("/compensation")
public class CompensationController {

    //薪酬组
    @Autowired
    private CompensationService compensationService;


    //添薪酬组
    @PostMapping("/insertcompensation")
    private AjaxResponse insertcompensation(@RequestBody Map<Object, Object> map) {

        Compensation compensation = JSON.parseObject(JSON.toJSONString(map.get("Compensation")), Compensation.class); // 取map中的 员工表数据 转换为实体类
        CompensationDeptPost compensationDeptPost = JSON.parseObject(JSON.toJSONString(map.get("CompensationDeptPost")), CompensationDeptPost.class);

        //调用入职方法，
        return AjaxResponse.success(compensationService.insertCompensation(compensation,compensationDeptPost));
    }


}

