package com.trkj.balance.modules.recruitment_management.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.recruitment_management.service.ResumeVoService;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ResumeVo")
public class ResumeVoController {

    @Autowired
    private ResumeVoService resumeVoService;
    //全部简历
    @GetMapping("/ResumePage/{currenPage}/{pagesize}")
    public AjaxResponse queryPage(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize) {
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        return AjaxResponse.success(resumeVoService.ResumePage(page));


    }
    //新简历
    @GetMapping("/ResumePage_a/{currenPage}/{pagesize}")
    public AjaxResponse aPage(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize) {
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        return AjaxResponse.success(resumeVoService.ResumePage_a(page));
    }

    //候选人
    @GetMapping("/ResumePage_H/{currenPage}/{pagesize}")
    public AjaxResponse HPage(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize) {
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        return AjaxResponse.success(resumeVoService.ResumePage_H(page));
    }

    //淘汰
    @GetMapping("/ResumePage_D/{currenPage}/{pagesize}")
    public AjaxResponse DPage(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize) {
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        return AjaxResponse.success(resumeVoService.ResumePage_D(page));
    }
    //已邀约
    @GetMapping("/ResumePage_Y/{currenPage}/{pagesize}")
    public AjaxResponse YPage(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize) {
        Page<ResumeVo> page = new Page<>(currenPage, pagesize);
        return AjaxResponse.success(resumeVoService.ResumePage_D(page));
    }
}
