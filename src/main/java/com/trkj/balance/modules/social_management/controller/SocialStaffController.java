package com.trkj.balance.modules.social_management.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.social_management.service.SocialStaffService;
import com.trkj.balance.modules.social_management.vo.SocialStaffVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/socialStaffVo")
public class SocialStaffController {

    @Autowired
    private SocialStaffService socialStaffService;

    @GetMapping("/selectsocialPage")
    public AjaxResponse selectsocialPage(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                          @RequestParam("staffNameSearch") String staffNameSearch,
                                         @RequestParam("deptIds") ArrayList deptIds,
                                         @RequestParam("stateSearch") String stateSearch){

        Page<SocialStaffVo> page = new Page<>(currenPage,pagesize);
        IPage<SocialStaffVo> list=socialStaffService.selectSocialPage(page,staffNameSearch,deptIds,stateSearch);
        return AjaxResponse.success(list);

    }

    @PostMapping("/insertsocial")
    private AjaxResponse insertsocial(@RequestBody Map<Object, Object> map) {

        int id = JSON.parseObject(JSON.toJSONString(map.get("zbId")), Integer.class); // 取map中的 员工表数据 转换为实体类

        ArrayList<Integer> staffIds = JSON.parseObject(JSON.toJSONString(map.get("staffIds")), ArrayList.class);

        log.debug("111111111111111111");
        log.debug(id+"");
        log.debug(staffIds.toString());
        return null;

            }

}
