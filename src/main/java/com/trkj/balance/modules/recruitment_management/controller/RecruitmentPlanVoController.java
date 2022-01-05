package com.trkj.balance.modules.recruitment_management.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.recruitment_management.service.RecruitmentPlanVoService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruitmentPlanVo")
public class RecruitmentPlanVoController {

    @Autowired
    private RecruitmentPlanVoService recruitmentPlanVoService;

    @GetMapping("/queryPage/{currenPage}/{pagesize}")
    public AjaxResponse queryPage(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){
        Page<RecruitmentPlanVo> page = new Page<>(currenPage,pagesize);
        return AjaxResponse.success(recruitmentPlanVoService.selectPage(page));

    }


}
