package com.trkj.balance.modules.recruitment_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.recruitment_management.service.RecruitmentPlanVoService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruitmentPlanVo")
public class RecruitmentPlanVoController {

    @Autowired
    private RecruitmentPlanVoService recruitmentPlanVoService;

    @GetMapping("/queryPage")
    public AjaxResponse queryPage(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                  @RequestParam("recruitmentPlanName") String recruitmentPlanName){
        IPage<RecruitmentPlanVo> page = recruitmentPlanVoService.selectPage(currenPage,pagesize,recruitmentPlanName);
        return AjaxResponse.success(page);

    }



}
