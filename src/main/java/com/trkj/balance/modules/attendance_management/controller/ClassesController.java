package com.trkj.balance.modules.attendance_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.attendance_management.service.ClassesService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
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
    @GetMapping("/fy/{currenPage}/{pagesize}")
    public AjaxResponse clafy(@PathVariable("currenPage") int page, @PathVariable("pagesize") int pagesize) {
        Page<Classes> pageable = new Page<>(page, pagesize);
        IPage<Classes> page1 = classesService.selsefy(pageable);
        return AjaxResponse.success(page1);
    }


    //新增
    @PostMapping("/add")
    public AjaxResponse add(@RequestBody Classes classes) {

        if (classesService.selsetj(classes) >= 1) {
            return AjaxResponse.success("成功");
        }

        return AjaxResponse.success("失败");

    }

    //删除
    @DeleteMapping("/delete/{id}")
    public AjaxResponse selectsc(@PathVariable Long id) {

        if (classesService.selsesc(id) >= 1) {
            return AjaxResponse.success("成功");
        }
        return AjaxResponse.success("失败");
    }

    //修改
    @PutMapping("/amend")
    public AjaxResponse amend(@RequestBody Classes classes) {
        if (classesService.amend(classes) >= 1) {
            return AjaxResponse.success("成功");
        }
        return AjaxResponse.success("失败");
    }


    //模糊搜索
    @GetMapping("/dim/{currenPage}/{pagesize}/{input}")
    public AjaxResponse search(@PathVariable("currenPage") int page, @PathVariable("pagesize") int size,@PathVariable("input") String classesName){
        IPage<Classes> sss = classesService.dimsearch(page,size,classesName);
        return AjaxResponse.success(sss);
    }


}
























