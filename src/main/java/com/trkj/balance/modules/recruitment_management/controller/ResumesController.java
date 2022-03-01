package com.trkj.balance.modules.recruitment_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.recruitment_management.entity.Educationss;
import com.trkj.balance.modules.recruitment_management.entity.RecruitmentPlan;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;
import com.trkj.balance.modules.recruitment_management.service.ResumesService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 简历表 前端控制器
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-24
 */
@Slf4j
@RestController
@RequestMapping("/resume")
public class ResumesController {
    @Autowired
    public ResumesService resumeService;
    //修改状态
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

    //修改简历
    @PutMapping("/updateResume")
    public AjaxResponse updateResume(@RequestBody Map<Object, Object> map){
        Resume resume = JSON.parseObject(JSON.toJSONString(map.get("Resume")), Resume.class); // 取map中的 员工表数据 转换为实体类
        WorkExperiencess workExperiencess = JSON.parseObject(JSON.toJSONString(map.get("WorkExperiencess")), WorkExperiencess.class);
        Educationss educationss = JSON.parseObject(JSON.toJSONString(map.get("Educationss")), Educationss.class);

        log.debug(resume.toString());
        log.debug(workExperiencess.toString());
        log.debug(educationss.toString());

        //调用入职方法，
        return AjaxResponse.success(resumeService.updateResume(resume,educationss,workExperiencess));
    }
    //根据id查简历
    @GetMapping("/selectResumes/{id}")
    public AjaxResponse selectResumes(@PathVariable("id") Long id){
        Resume resume=resumeService.selectResumes(id);
        return AjaxResponse.success(resume);
    }

    //简历添加
    @PostMapping("/resumes")
    private AjaxResponse insertResume(@RequestBody Map<Object, Object> map) {

        Resume resume = JSON.parseObject(JSON.toJSONString(map.get("Resume")), Resume.class); // 取map中的 员工表数据 转换为实体类
        WorkExperiencess workExperiencess = JSON.parseObject(JSON.toJSONString(map.get("WorkExperiencess")), WorkExperiencess.class);
        Educationss educationss = JSON.parseObject(JSON.toJSONString(map.get("Educationss")), Educationss.class);

        log.debug(resume.toString());
        log.debug(workExperiencess.toString());
        log.debug(educationss.toString());

        //调用入职方法，
        return AjaxResponse.success(resumeService.insertResume(resume,educationss,workExperiencess));
    }

}

