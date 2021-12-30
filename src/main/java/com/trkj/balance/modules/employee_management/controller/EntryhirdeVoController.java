package com.trkj.balance.modules.employee_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/entryhirdeVo")
public class EntryhirdeVoController {

    @Autowired
    private EntryhirdeVoService entryhirdeVoService;

    @GetMapping("/selectEntryhirdeVo/{currenPage}/{pagesize}")
    public AjaxResponse selectEntryhirdeVo(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<EntryhirdeVo> page = new Page<>(currenPage,pagesize);
        IPage<EntryhirdeVo> list=entryhirdeVoService.selectEntryhirde1(page);
        return AjaxResponse.success(list);

    }

//    @GetMapping("/selectEntryhirdeVo1/{currenPage}/{pagesize}")
//    public IPage<EntryhirdeVo> selectEntryhirdeVo1(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){
//
//        Page<EntryhirdeVo> page = new Page<>(currenPage,pagesize);
//        IPage<EntryhirdeVo> list=entryhirdeVoService.selectEntryhirde1(page);
//        return list;
//
//    }

}
