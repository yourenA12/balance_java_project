package com.trkj.balance.modules.recruitment_management.controller;


import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.service.ResumesService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 简历表 前端控制器
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-24
 */
@RestController
@RequestMapping("/resume")
public class ResumesController {
    @Autowired
    public ResumesService resumeService;

    @PutMapping("/resume/zeliminate")
    public AjaxResponse zeliminate(@RequestBody Resume resume){
        if (resumeService.updateeliminate(resume)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }
    @PutMapping("/updatexin")
    public AjaxResponse updatexin(@RequestBody Resume resume){
        if (resumeService.updateeliminate(resume)>=1){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }
    }

}

