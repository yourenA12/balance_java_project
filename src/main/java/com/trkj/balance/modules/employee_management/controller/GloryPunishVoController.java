package com.trkj.balance.modules.employee_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.service.GloryPunishVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/GloryPunishVo")
public class GloryPunishVoController {

    @Autowired
    private GloryPunishVoService gloryPunishVoService;

    @GetMapping("/selectGloryPunishVo/{currenPage}/{pagesize}")
    public AjaxResponse selectGloryPunish(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<GloryPunishVo> page = new Page<>(currenPage,pagesize);
        IPage<GloryPunishVo> list=gloryPunishVoService.selectGloryPunish(page);
        return AjaxResponse.success(list);

    }


}
