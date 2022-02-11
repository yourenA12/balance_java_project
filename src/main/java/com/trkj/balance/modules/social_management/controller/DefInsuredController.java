package com.trkj.balance.modules.social_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * <p>
 * 默认参保方案表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
@RestController
@RequestMapping("/defInsured")
public class DefInsuredController {

    @Autowired
    private DefInsuredService defInsuredService;

    // 查询所有参保方案
    @GetMapping("/selectAllPage")
    public AjaxResponse selectAllPage(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                      @RequestParam("input") String name, @RequestParam("state") Object state){
        Page<DefInsured> page = new Page<>(currenPage,pagesize);
        IPage<DefInsured> list = defInsuredService.selectAllPage(page,name,state);
        return AjaxResponse.success(list);
    }

    // 按id删除某参保方案
    @DeleteMapping("/deleteDefInsured/{id}")
    public AjaxResponse deleteNotices(@PathVariable("id") Long id){
        return AjaxResponse.success( defInsuredService.deleteDefInsured(id) );
    }

    // 修改参保方案状态
    @PutMapping("/updateDefInsuredState")
    public AjaxResponse updateDefInsuredState(@RequestBody DefInsured defInsured){
        return AjaxResponse.success( defInsuredService.updateDefInsuredState(defInsured) );
    }


}

