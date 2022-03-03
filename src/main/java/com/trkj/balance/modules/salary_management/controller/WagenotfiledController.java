package com.trkj.balance.modules.salary_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.service.WagenotfiledVoService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 工资未归档表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/wagenotfiled")
public class WagenotfiledController {

    @Autowired
    private WagenotfiledVoService wagenotfiledVoService;

    //查询未归档数据
    @GetMapping("/selectwagenotfiledVo/{currenPage}/{pagesize}")
    public AjaxResponse selectCompensation(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<WagenotfiledVo> page = new Page<>(currenPage,pagesize);
        IPage<WagenotfiledVo> list=wagenotfiledVoService.selectWagenotfiledVoPage(page);
        return AjaxResponse.success(list);

    }


}

