package com.trkj.balance.modules.organization_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.employee_management.entity.Resume;
import com.trkj.balance.modules.organization_management.entity.DeptPost;
import com.trkj.balance.modules.organization_management.entity.Position;
import com.trkj.balance.modules.organization_management.service.DeptPoService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 * 部门职位中间表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-03-01
 */
@RestController
@RequestMapping("/deptPost")
public class DeptPoController {

    @Autowired
    public DeptPoService deptPoService;

    //新增
    @PostMapping("/add")
    public AjaxResponse deptPo (@RequestBody Map map){

        Position post = JSON.parseObject(JSON.toJSONString(map.get("Post")), Position.class);
        ArrayList<Integer> deptIds = JSON.parseObject(JSON.toJSONString(map.get("DeptIds")), ArrayList.class);

        if (deptPoService.insert(post,deptIds)>=1){
            return AjaxResponse.success("成功");
        }
            return AjaxResponse.success("失败");
    }

}

