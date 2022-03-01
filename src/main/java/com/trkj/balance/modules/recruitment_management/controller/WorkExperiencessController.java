package com.trkj.balance.modules.recruitment_management.controller;


import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;
import com.trkj.balance.modules.recruitment_management.service.WorkExperiencessService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 工作经历表 前端控制器
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-28
 */
@Slf4j
@RestController
@RequestMapping("/workExperiencess")
public class WorkExperiencessController {
//修改工作经历
    @Autowired
    public WorkExperiencessService workExperiencessService;

    @PutMapping("/updateWork")
    public AjaxResponse updateWork(@RequestBody WorkExperiencess workExperiencess){
        return AjaxResponse.success(workExperiencessService.updateWork(workExperiencess));
    }
    //根据id查工作经历
    @GetMapping("/selectWork/{id}")
    public AjaxResponse selectWork(@PathVariable("id") Long id){
        WorkExperiencess workExperiencess=workExperiencessService.selectWork(id);
        return AjaxResponse.success(workExperiencess);
    }
}

