package com.trkj.balance.modules.organization_management.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.service.DeptVoService;
import com.trkj.balance.modules.organization_management.vo.DeptVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-10
 */
@RestController
@RequestMapping("/deptVo")
public class DeptVoController {
    @Autowired
    public DeptVoService deptVoService;

    //部门分页查询
    @GetMapping("/dept/{currenPage}/{pagesize}")
    public AjaxResponse inquire(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pageSize){
        Page<DeptVo> page = new Page<>(currenPage, pageSize);
        return AjaxResponse.success(deptVoService.selectDeptVo(page));
    }

}

