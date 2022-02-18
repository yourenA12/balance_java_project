package com.trkj.balance.modules.organization_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.entity.Position;
import com.trkj.balance.modules.organization_management.service.PositionService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 职位表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-02-13
 */
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    public PositionService positionService;

    @GetMapping("/Po/{currenPage}/{pagesize}")
    public AjaxResponse posi(@PathVariable("currenPage") int page, @PathVariable("pagesize") int pagesize){
        Page<Position> page1 = new Page<>(page,pagesize);
        IPage<Position> page2 = positionService.selectPo(page1);
        return AjaxResponse.success(page2);
    }
}

