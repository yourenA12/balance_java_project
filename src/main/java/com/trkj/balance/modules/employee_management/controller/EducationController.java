package com.trkj.balance.modules.employee_management.controller;


import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.trkj.balance.modules.employee_management.service.EducationService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 受教育经历表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-01-19
 */
@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    //花名册 编辑里根据id查询查询教育经历表
    @GetMapping("/selectEducationId/{id}")
    public AjaxResponse selectEducationId(@PathVariable("id") Long id){
        return AjaxResponse.success(educationService.selectEducationId(id));
    }

    //修改教育经历表信息
    @PutMapping("/updateEducation")
    public AjaxResponse updateEducationId(@RequestBody Education education){
        return AjaxResponse.success(educationService.updateEducation(education));
    }

    //删除教育经历表信息
    @DeleteMapping("/deleteEducationId/{id}")
    public AjaxResponse deleteEducationId(@PathVariable("id") Long id){
        return AjaxResponse.success(educationService.deleteEducationId(id));
    }

    //添加教育经历表信息
    @PostMapping("/insertEducation")
    public AjaxResponse insertEducation(@RequestBody Education education){
        return AjaxResponse.success(educationService.insertEducation(education));
    }

}

