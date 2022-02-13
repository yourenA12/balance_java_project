package com.trkj.balance.modules.organization_management.controller;


import com.trkj.balance.modules.organization_management.entity.Dept;
import com.trkj.balance.modules.organization_management.service.DeptService;
import com.trkj.balance.vo.AjaxResponse;
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

     //
     @GetMapping("/yyds")
     public AjaxResponse queryList(){
        List<Dept> list = deptService.queryList();
        return AjaxResponse.success(list);
     }


}

