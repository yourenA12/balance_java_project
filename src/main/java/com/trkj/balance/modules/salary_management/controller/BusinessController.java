package com.trkj.balance.modules.salary_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Business;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.trkj.balance.modules.salary_management.service.BusinessService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;

/**
 * <p>
 * 出差方案表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-13
 */
@Slf4j
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    //添加出差方案
    @PostMapping("/insertBusiness")
    private AjaxResponse insertBusiness(@RequestBody Business business ) {
        log.debug(business.toString());
        return AjaxResponse.success(businessService.insertBusiness(business));
    }

    //查询出差方案
    @GetMapping("/selectBusiness/{currenPage}/{pagesize}")
    public AjaxResponse selectBusiness(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<Business> page = new Page<>(currenPage,pagesize);
        IPage<Business> list=businessService.selectBusiness(page);
        return AjaxResponse.success(list);

    }

    //修改出差方案状态
    @PutMapping("/updateBusinessState")
    public AjaxResponse updateBusinessState(@RequestBody Business business ){
        return AjaxResponse.success( businessService.updateBusinessState(business) );
    }

    //删除出差方案
    @DeleteMapping("/deleteBusinessId/{id}")
    public AjaxResponse deleteBusinessId(@PathVariable("id") Long id){
        return AjaxResponse.success( businessService.deleteBusiness(id) );
    }

    //根据id查询出差方案信息
    @GetMapping("/selectBusinessId/{id}")
    public AjaxResponse selectBusinessId(@PathVariable("id") Long id){
        Business business=businessService.selectBusinessId(id);
        return AjaxResponse.success(business);
    }

    //修改出差信息
    @PutMapping("/updateBusiness")
    public AjaxResponse updateBusiness(@RequestBody Business business){
        log.debug("123456789098765rfvbhy654edcvgtredc");
        log.debug(business.toString());
        return AjaxResponse.success(businessService.updateBusiness(business));
    }


}

