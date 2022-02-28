package com.trkj.balance.modules.recruitment_management.controller;


import com.trkj.balance.modules.recruitment_management.entity.Educationss;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.service.EducationssService;
import com.trkj.balance.modules.recruitment_management.service.ResumesService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 受教育经历表 前端控制器
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-28
 */
@Slf4j
@RestController
@RequestMapping("/educationss")
public class EducationssController {

    //修改简历
    @Autowired
    public EducationssService educationssService;

    @PutMapping("/updateEducationss")
    public AjaxResponse updateEducationss(@RequestBody Educationss educationss){
        return AjaxResponse.success(educationssService.updateEdcationss(educationss));
    }
    //根据id查教育经历
    @GetMapping("/selectEducationss/{id}")
    public AjaxResponse selectEdcationss(@PathVariable("id") Long id){
        Educationss educationss=educationssService.selectEdcationss(id);
        return AjaxResponse.success(educationss);
    }

}

