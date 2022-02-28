package com.trkj.balance.modules.employee_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.employee_management.service.GloryService;
import com.trkj.balance.modules.employee_management.service.GloryVoService;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;
import com.trkj.balance.modules.employee_management.vo.GloryVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/Glory")
public class GloryController {

    @Autowired
    private GloryService gloryService;

    @Autowired
    private GloryVoService gloryVoService;

    //花名册 编辑里根据id查询查询奖励表信息
    @GetMapping("/selectGloryId/{id}")
    public AjaxResponse selectGloryId(@PathVariable("id") Long id){
        return AjaxResponse.success(gloryService.selectGloryId(id));
    }

    //修改荣誉/奖励信息
    @PutMapping("/updateGlory")
    public AjaxResponse updateWorkExperienceId(@RequestBody Glory glory){
        return AjaxResponse.success(gloryService.updateGlory(glory));
    }

    //删除荣誉/奖励信息
    @DeleteMapping("/deleteGloryId/{id}")
    public AjaxResponse deleteWorkExperienceId(@PathVariable("id") Long id){
        return AjaxResponse.success(gloryService.deleteGlory(id));
    }

    //添加荣誉/奖励信息
    @PostMapping("/insertGlory")
    public AjaxResponse insertWorkExperience(@RequestBody Glory glory){
        return AjaxResponse.success(gloryService.insertGlory(glory));
    }

    //分页查询奖励表
    @GetMapping("/selectGloryPage")
    public AjaxResponse selectGloryPage(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                        @RequestParam("staffNameSearch") String staffNameSearch,@RequestParam("deptIds") ArrayList deptIds ){

        Page<GloryVo> page = new Page<>(currenPage,pagesize);
        IPage<GloryVo> list=gloryVoService.selectGloryPage(page,staffNameSearch,deptIds);
        return AjaxResponse.success(list);

    }

}
