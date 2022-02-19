package com.trkj.balance.modules.organization_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.entity.Dept;
import com.trkj.balance.modules.organization_management.entity.Staff;
import com.trkj.balance.modules.organization_management.service.DeptService;
import com.trkj.balance.modules.organization_management.vo.DeptStaffVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-01-12
 */
@RestController
@RequestMapping("/dept")
@Slf4j
public class DeptController {
    @Autowired
    public DeptService deptService;

    //删除
    @DeleteMapping("/deptsc/{id}")
    public AjaxResponse deptsc (@PathVariable("id") Long id){
        if (deptService.deptdelete(id)>= 1){
            return AjaxResponse.success("成功");
        }
            return AjaxResponse.success("失败");
    }

    //新增
    @PostMapping("/add")
    public AjaxResponse depttj(@RequestBody Dept dept) {
        if (deptService.insert(dept) >= 1) {
            return AjaxResponse.success("成功");
        }
        return AjaxResponse.success("失败");
    }

    //修改
    @PutMapping("/deptamend")
     public AjaxResponse deptxg(@RequestBody Dept dept){
        if (deptService.amend(dept) >= 1){
            return AjaxResponse.success("成功");
        }
            return AjaxResponse.success("失败");
     }

     //查询
     @GetMapping("/yyds")
     public AjaxResponse queryList(){
        List<Dept> list = deptService.queryList();
        return AjaxResponse.success(list);
     }

     //模糊搜索
     @GetMapping("/deptmo")
    public AjaxResponse mos(@RequestParam("currenPage") int page, @RequestParam("pagesize") int size,
                            @RequestParam("input") String classesName,@RequestParam("inputs") String deptState){
        IPage<Dept> s = deptService.moss(page, size, classesName,deptState);

        return AjaxResponse.success(s);
    }

    //查询员工
    @GetMapping("/yg")
    public AjaxResponse yg(@RequestParam("currenPage") int page, @RequestParam("pagesize") int pagesize,
                           @RequestParam("staffName") String staffName){
       IPage<DeptStaffVo> ss = deptService.yg(page, pagesize,staffName);
        return AjaxResponse.success(ss);
    }

    //部门状态
    @GetMapping("/state")
    public AjaxResponse state(){
        return AjaxResponse.success(deptService.state());
    }



}

