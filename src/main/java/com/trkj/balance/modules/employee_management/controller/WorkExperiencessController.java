package com.trkj.balance.modules.employee_management.controller;



import com.trkj.balance.modules.employee_management.entity.WorkExperiencess;
import com.trkj.balance.modules.employee_management.service.WorkExperiencessService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/workExperiencess")
public class WorkExperiencessController {
    @Autowired
    private WorkExperiencessService workExperiencessService;

    @PostMapping("/insertWorkExperience")
    private AjaxResponse insertWorkExperience(@RequestBody WorkExperiencess workExperience){
        int staff1 =workExperiencessService.insertWorkExperience(workExperience);
        return AjaxResponse.success(staff1);
    }
}

