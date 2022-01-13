package com.trkj.balance.modules.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.employee_management.service.WorkExperienceService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2021-12-31
 */
@Slf4j
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

    //花名册 编辑里根据id查询工作经历
    @GetMapping("/selectWorkExperienceId/{id}")
    public AjaxResponse selectWorkExperienceId(@PathVariable("id") Long id){
        return AjaxResponse.success(workExperienceService.selectWorkExperienceId(id));
    }

    //修改工作经历
    @PutMapping("/updateWorkExperienceId")
    public AjaxResponse updateWorkExperienceId(@RequestBody WorkExperience workExperience){
        return AjaxResponse.success(workExperienceService.updateWorkExperienceId(workExperience));
    }

    //删除工作经历
    @DeleteMapping("/deleteWorkExperienceId/{id}")
    public AjaxResponse deleteWorkExperienceId(@PathVariable("id") Long id){
        return AjaxResponse.success(workExperienceService.deleteWorkExperienceId(id));
    }

    //添加工作经历
    @PostMapping("/insertWorkExperience")
    public AjaxResponse insertWorkExperience(@RequestBody WorkExperience workExperience){
        log.debug(workExperience.toString());
        return AjaxResponse.success(workExperienceService.insertWorkExperience(workExperience));
    }
}

