package com.trkj.balance.modules.social_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.trkj.balance.modules.social_management.entity.DefScheme;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 * 默认参保方案表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
@Slf4j
@RestController
@RequestMapping("/defInsured")
public class DefInsuredController {

    @Autowired
    private DefInsuredService defInsuredService;

    // 查询所有参保方案
    @GetMapping("/selectAllPage")
    public AjaxResponse selectAllPage(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                      @RequestParam("input") String name, @RequestParam("state") Object state){
        Page<DefInsured> page = new Page<>(currenPage,pagesize);
        IPage<DefInsured> list = defInsuredService.selectAllPage(page,name,state);
        return AjaxResponse.success(list);
    }

    // 按id删除某参保方案
    @DeleteMapping("/deleteDefInsured/{id}")
    public AjaxResponse deleteNotices(@PathVariable("id") Long id){
        return AjaxResponse.success( defInsuredService.deleteDefInsured(id) );
    }

    // 修改参保方案状态
    @PutMapping("/updateDefInsuredState")
    public AjaxResponse updateDefInsuredState(@RequestBody DefInsured defInsured){
        return AjaxResponse.success( defInsuredService.updateDefInsuredState(defInsured) );
    }

    // 新增参保方案状态
    @PostMapping("/insertDefInsured")
    public AjaxResponse insertDefInsured(@RequestBody Map<Object, Object> map){

        // 默认参保方案
        DefInsured defInsured = JSON.parseObject(JSON.toJSONString(map.get("defInsured")), DefInsured.class);
        // 社保方案
        ArrayList<DefScheme> defScheme1 = JSON.parseObject(JSON.toJSONString(map.get("defScheme1")), ArrayList.class);
        // 公积金方案
        ArrayList<DefScheme> defScheme2 = JSON.parseObject(JSON.toJSONString(map.get("defScheme2")), ArrayList.class);
        // 基数上限
        String upper = JSON.parseObject(JSON.toJSONString(map.get("upper")), String.class);
        // 基数下限
        String lower = JSON.parseObject(JSON.toJSONString(map.get("lower")), String.class);

        ArrayList<Integer> deptIds = JSON.parseObject(JSON.toJSONString(map.get("deptIds")), ArrayList.class);
        ArrayList<Integer> postIds = JSON.parseObject(JSON.toJSONString(map.get("postIds")), ArrayList.class);
        ArrayList<Integer> staffIds = JSON.parseObject(JSON.toJSONString(map.get("staffIds")), ArrayList.class);


        log.debug("1111111111111111111");

        log.debug(defInsured.toString());

        log.debug(defScheme1.toString());

        log.debug(defScheme2.toString());

        log.debug(upper);

        log.debug(lower);

        log.debug(deptIds.toString());

        log.debug(postIds.toString());

        log.debug(staffIds.toString());


        return AjaxResponse.success("");
    }


}

