package com.trkj.balance.modules.employee_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.trkj.balance.modules.employee_management.service.PunishService;
import com.trkj.balance.modules.employee_management.service.PunishVoService;
import com.trkj.balance.modules.employee_management.vo.PunishVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/Punish")
public class PunishController {

    @Autowired
    private PunishService punishService;

    @Autowired
    private PunishVoService punishVoService;

    //花名册 编辑里根据id查询查询惩罚表
    @GetMapping("/selectPunishId/{id}")
    public AjaxResponse selectPunishId(@PathVariable("id") Long id) {
        return AjaxResponse.success(punishService.selectPunishId(id));
    }

    //修改惩罚表信息
    @PutMapping("/updatePunish")
    public AjaxResponse updatePunishId(@RequestBody Punish punish) {
        return AjaxResponse.success(punishService.updatePunish(punish));
    }

    //删除惩罚表信息
    @DeleteMapping("/deletePunishId/{id}")
    public AjaxResponse deletePunishId(@PathVariable("id") Long id) {
        return AjaxResponse.success(punishService.deletePunishId(id));
    }

    //添加惩罚表信息
    @PostMapping("/insertPunish")
    public AjaxResponse insertPunish(@RequestBody Punish punish) {
        return AjaxResponse.success(punishService.insertPunish(punish));
    }

    //分页查询惩罚表
    @GetMapping("/selectPunishPage")
    public AjaxResponse selectPunishPage(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                         @RequestParam("staffNameSearch") String staffNameSearch, @RequestParam("deptIds") ArrayList deptIds) {

        Page<PunishVo> page = new Page<>(currenPage, pagesize);
        IPage<PunishVo> list = punishVoService.selectPunishPage(page,staffNameSearch,deptIds);
        return AjaxResponse.success(list);

    }

}
