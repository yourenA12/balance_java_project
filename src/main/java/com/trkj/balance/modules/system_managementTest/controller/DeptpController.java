package com.trkj.balance.modules.system_managementTest.controller;


import com.trkj.balance.modules.system_managementTest.entity.Deptp;
import com.trkj.balance.modules.system_managementTest.service.DeptpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-01-16
 */
@RestController
@RequestMapping("/deptp")
public class DeptpController {

    @Autowired
    private DeptpService deptpService;

    @GetMapping("/selectAll")
    public List<Deptp> queryCatList(){
        List<Deptp> list = deptpService.queryList();
        return list;
    }

}

