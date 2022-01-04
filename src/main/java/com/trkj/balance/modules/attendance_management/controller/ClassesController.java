package com.trkj.balance.modules.attendance_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.attendance_management.service.ClassesService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 班次方案表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2021-12-30
 */
@Slf4j
@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    public ClassesService classesService;

    //分页查询
    @GetMapping("/fy")
    public AjaxResponse clafy(@RequestParam("currenPage") int page, @RequestParam("pagesize") int pagesize){
        Page<Classes> pageable = new Page<>(page,pagesize);
        IPage<Classes> page1 = classesService.selsefy(pageable);
        return AjaxResponse.success(page1);
    }


    //新增
    @PostMapping("/add")
    public String add(@RequestBody Classes classes){
        try {
            if (classesService.selsetj(classes) >=1){
                return "成功！";
            }else{
                return "失败！";
            }
        }catch (Exception e){
                return "失败！";
        }
    }

    //删除
    @PostMapping("/delete")
    public AjaxResponse selectsc(@RequestBody Classes classes){
        if (classesService.selsesc(classes.getClassesId())>0){
            return AjaxResponse.success("成功");
        }else {
            return AjaxResponse.success("失败");
        }


    }


}

