package com.trkj.balance.modules.social_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.social_management.service.socialStaffService;
import com.trkj.balance.modules.social_management.vo.socialStaffVo;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/socialStaffVo")
public class socialStaffController {

    @Autowired
    private socialStaffService socialStaffService;

    @GetMapping("/selectsocialPage")
    public AjaxResponse selectsocialPage(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                          @RequestParam("staffNameSearch") String staffNameSearch,
                                         @RequestParam("deptIds") ArrayList deptIds,
                                         @RequestParam("stateSearch") String stateSearch){

        Page<socialStaffVo> page = new Page<>(currenPage,pagesize);
        IPage<socialStaffVo> list=socialStaffService.selectSocialPage(page,staffNameSearch,deptIds,stateSearch);
        return AjaxResponse.success(list);

    }

}
