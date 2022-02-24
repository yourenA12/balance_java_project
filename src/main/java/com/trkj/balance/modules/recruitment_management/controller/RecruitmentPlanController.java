package com.trkj.balance.modules.recruitment_management.controller;


import com.trkj.balance.modules.recruitment_management.entity.RecruitmentPlan;
import com.trkj.balance.modules.recruitment_management.service.RecruitmentPlanReService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 招聘计划表 前端控制器
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-22
 */
@Slf4j
@RestController
@RequestMapping("/recruitmentPlan")
public class RecruitmentPlanController {

    @Autowired
    private RecruitmentPlanReService recruitmentPlanService;

    //添加招聘计划
    @PostMapping("/insertzpjh")
    private AjaxResponse insertzpjh(@RequestBody RecruitmentPlan recruitmentPlan ) {
        log.debug("1111111");
        log.debug(recruitmentPlan.toString());
        return AjaxResponse.success(recruitmentPlanService.insertzp(recruitmentPlan));
    }

    //删除
    @DeleteMapping("/jihua/{id}")
    public AjaxResponse jiahuasc(@PathVariable("id")Long id){
        if (recruitmentPlanService.jihuasc(id) >= 1){
            return AjaxResponse.success("成功");
        }
        return AjaxResponse.success("失败");
        }

    //修改招聘计划
    @PutMapping("/updateRectruitmentPlan")
    public AjaxResponse updateRectruitmentPlan(@RequestBody RecruitmentPlan recruitmentPlan ){
        return AjaxResponse.success( recruitmentPlanService.updateRecruitmentPlan(recruitmentPlan));
    }

    //根据id查询招聘计划信息
    @GetMapping("/selectRectruitmentPlanId/{id}")
    public AjaxResponse selectRectruitmentPlanId(@PathVariable("id") Long id){
        RecruitmentPlan rectruitmentPlan=recruitmentPlanService.selectRecruitmentPlanId(id);
        return AjaxResponse.success(rectruitmentPlan);
    }
    }





