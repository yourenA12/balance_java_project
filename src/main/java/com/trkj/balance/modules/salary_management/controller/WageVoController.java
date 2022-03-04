package com.trkj.balance.modules.salary_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.service.WageVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/WageVo")
public class WageVoController {

    @Autowired
    private WageVoService wageVoService;

    //查询工资
    @GetMapping("/selectWageVo/{currenPage}/{pagesize}/{id}")
    public AjaxResponse selectWageVo(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize, @PathVariable("id") int compensationId){

        Page<WagVo> page = new Page<>(currenPage,pagesize);
        IPage<WagVo> list=wageVoService.selectWagVo(page,compensationId);
        return AjaxResponse.success(list);

    }
}
