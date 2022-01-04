package com.trkj.balance.modules.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.employee_management.service.WorkExperienceService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2021-12-31
 */
@RestController
@RequestMapping("/workExperience")
public class WorkExperienceController {
    @Autowired
    private WorkExperienceService workExperienceService;

    @GetMapping("/selectWorkExperience/{currenPage}/{pagesize}")
    public AjaxResponse selectEntryhirdeVo(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<WorkExperience> page = new Page<>(currenPage,pagesize);
        IPage<WorkExperience> list=workExperienceService.selectWorkExperience(page);
        return AjaxResponse.success(list);

    }
}

