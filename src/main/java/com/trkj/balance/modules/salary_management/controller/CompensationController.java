package com.trkj.balance.modules.salary_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.salary_management.entity.*;
import com.trkj.balance.modules.salary_management.service.CompensationDeptPostService;
import com.trkj.balance.modules.salary_management.service.CompensationService;
import com.trkj.balance.modules.salary_management.service.CompensationStaffService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 薪酬组表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Slf4j
@RestController
@RequestMapping("/compensation")
public class CompensationController {

    //薪酬组
    @Autowired
    private CompensationService compensationService;

    @Autowired
    private CompensationStaffService compensationStaffService;

    @Autowired
    private CompensationDeptPostService compensationDeptPostService;


    //添薪酬组
    @PostMapping("/insertcompensation")
    private AjaxResponse insertcompensation(@RequestBody Map<Object, Object> map) {

        Compensation compensation = JSON.parseObject(JSON.toJSONString(map.get("Compensation")), Compensation.class); // 取map中的 员工表数据 转换为实体类

        ArrayList<Integer> deptIds = JSON.parseObject(JSON.toJSONString(map.get("deptIds")), ArrayList.class);
        ArrayList<Integer> postIds = JSON.parseObject(JSON.toJSONString(map.get("postIds")), ArrayList.class);
        ArrayList<Integer> staffIds = JSON.parseObject(JSON.toJSONString(map.get("staffIds")), ArrayList.class);


        log.debug("1111111111111111111");

        log.debug(compensation.toString());

        log.debug(deptIds.toString());

        log.debug(postIds.toString());

        log.debug(staffIds.toString());

//        // 判断删除
//        if(compensation.getCompensationId()+""!="" && compensation.getCompensationId()!=null){
//            if( defInsuredService.deleteDefInsured(Math.toIntExact(defInsured.getDefInsuredId()))<1){
//                return AjaxResponse.success("出错了，请稍后再试");
//            }
//        }

        // 查询薪酬组名称是否重复
        String a=compensationService.selectCompensationNames(compensation.getCompensationName());
        if(a!=null) return AjaxResponse.success(a+",重复");

        // 查询薪酬组员工中间表是否有重复员工
        String b=compensationStaffService.selectCompensationStaffName(staffIds);
        if(b!=null) return AjaxResponse.success(b+",已设置薪酬组");

        // 查询薪酬组部门职位中间表是否有重复部门职位
        String c=compensationDeptPostService.selectCompensationDeptPost(deptIds,postIds);
        if(c!=null) return AjaxResponse.success(c+",已设置薪酬组");

        //调用新增薪酬组的方法，
        return AjaxResponse.success( compensationService.insertCompensation(compensation,deptIds,postIds,staffIds) >0?"添加成功":"添加失败" );
    }

    //查询薪酬组名称
    @GetMapping("/selectCompensationName")
    public AjaxResponse selectCompensationName(){
        List<Map<String, Object>> list=compensationService.selectCompensationName();
        return AjaxResponse.success(list);
    }
    //根据id查询薪酬组数据
    @GetMapping("/selectCompensationId/{id}")
    public AjaxResponse selectCompensationId(@PathVariable("id") Long id){
        Compensation compensation=compensationService.selectCompensationById(id);
        return AjaxResponse.success(compensation);
    }

    //修改薪酬组数据
    @PutMapping("/updateCompensation")
    public AjaxResponse updateCompensation(@RequestBody Compensation compensation){
        log.debug("123456789098765rfvbhy654edcvgtredc");
        log.debug(compensation.toString());
        return AjaxResponse.success(compensationService.updateCompensation(compensation));
    }
    //根据薪酬组名称查询
    @PostMapping("/selectCompensationNmames")
    public AjaxResponse selectCompensationNmames(@RequestBody Map<Object, Object> map){

        String name = JSON.parseObject(JSON.toJSONString(map.get("name")), String.class); // 取map中的 员工表数据 转换为实体类

        ArrayList<Integer> deptIds = JSON.parseObject(JSON.toJSONString(map.get("deptIds")), ArrayList.class);
        ArrayList<Integer> postIds = JSON.parseObject(JSON.toJSONString(map.get("postIds")), ArrayList.class);
        ArrayList<Integer> staffIds = JSON.parseObject(JSON.toJSONString(map.get("staffIds")), ArrayList.class);

        log.debug("1111111111111111111");

        log.debug(name);

        log.debug(deptIds.toString());

        log.debug(postIds.toString());

        log.debug(staffIds.toString());



        String a=compensationService.selectCompensationNames(name);
        if(a!=null) return AjaxResponse.success(a);

        String b=compensationStaffService.selectCompensationStaffName(staffIds);
        if(b!=null) return AjaxResponse.success(b);

        String c=compensationDeptPostService.selectCompensationDeptPost(deptIds,postIds);
        if(c!=null) return AjaxResponse.success(c);

        return AjaxResponse.success(null);

    }

    //查询薪酬组
    @GetMapping("/selectCompensation/{currenPage}/{pagesize}")
    public AjaxResponse selectCompensation(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<Compensation> page = new Page<>(currenPage,pagesize);
        IPage<Compensation> list=compensationService.selectCompensationPage(page);
        return AjaxResponse.success(list);

    }



    // 按薪酬组id查询部门id
    @GetMapping("/selectDeptId/{id}")
    public AjaxResponse selectDeptId(@PathVariable("id") int id){
        return AjaxResponse.success(compensationService.selectDeptId(id));
    }

    // 按薪酬组id查询职位id
    @GetMapping("/selectPostId/{id}")
    public AjaxResponse selectPostId(@PathVariable("id") int id){
        return AjaxResponse.success(compensationService.selectPostId(id));
    }

    // 按薪酬组id查询员工
    @GetMapping("/selectStaffId/{id}")
    public AjaxResponse selectStaffId(@PathVariable("id") int id){
        return AjaxResponse.success(compensationService.selectStaffId(id));
    }


    //删除薪酬组
    @DeleteMapping("/deleteCompensationId/{id}")
    public AjaxResponse deleteCompensationId(@PathVariable("id") Long id){
        return AjaxResponse.success(compensationService.deleteCompensation(id));
    }

}

