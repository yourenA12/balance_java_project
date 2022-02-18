package com.trkj.balance.modules.salary_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.trkj.balance.modules.salary_management.service.WorkschemeService;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 加班方案表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-12
 */
@Slf4j
@RestController
@RequestMapping("/workscheme")
public class WorkschemeController {

    @Autowired
    private WorkschemeService workschemeService;

    //添加加班方案
    @PostMapping("/insertWorkscheme")
    private AjaxResponse insertWorkscheme(@RequestBody Workscheme workscheme ) {
        log.debug(workscheme.toString());
        return AjaxResponse.success(workschemeService.insertWorkscheme(workscheme));
    }
    //查询加班方案
    @GetMapping("/selectWorkscheme/{currenPage}/{pagesize}")
    public AjaxResponse selectWorkscheme(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<Workscheme> page = new Page<>(currenPage,pagesize);
        IPage<Workscheme> list=workschemeService.selectWorkscheme(page);
        return AjaxResponse.success(list);

    }
    //修改加班方案状态
    @PutMapping("/updateWorkschemeState")
    public AjaxResponse updateWorkschemeState(@RequestBody Workscheme workscheme){
        return AjaxResponse.success( workschemeService.updateWorkschemeState(workscheme) );
    }

    //删除加班方案
    @DeleteMapping("/deleteWorkschemeId/{id}")
    public AjaxResponse deleteWorkschemeId(@PathVariable("id") Long id){
        return AjaxResponse.success( workschemeService.deleteWorkscheme(id) );
    }

    //根据id查询加班方案信息

    @GetMapping("/selectWorkschemeId/{id}")
    public AjaxResponse selectWorkschemeId(@PathVariable("id") Long id){
        Workscheme workscheme=workschemeService.selectWorkschemeId(id);
        return AjaxResponse.success(workscheme);
    }
    //修改加班信息
    @PutMapping("/updateWorkscheme")
    public AjaxResponse updateWorkscheme(@RequestBody Workscheme workscheme){
        log.debug("123456789098765rfvbhy654edcvgtredc");
        log.debug(workscheme.toString());
        return AjaxResponse.success(workschemeService.updateWorkscheme(workscheme));
    }
}

