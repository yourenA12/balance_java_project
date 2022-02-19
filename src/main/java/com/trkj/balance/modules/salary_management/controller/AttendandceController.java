package com.trkj.balance.modules.salary_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Attendandce;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.trkj.balance.modules.salary_management.service.AttendandceService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 考勤扣款方案表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-14
 */
@Slf4j
@RestController
@RequestMapping("/attendandce")
public class AttendandceController {

    @Autowired
    private AttendandceService attendandceService;

    //新增考勤扣款方案
    @PostMapping("/insertAttendandce")
    private AjaxResponse insertAttendandce(@RequestBody Attendandce attendandce ) {
        log.debug(attendandce.toString());
        return AjaxResponse.success(attendandceService.insertAttendandce(attendandce));
    }

    //查询考勤扣款方案
    @GetMapping("/selectAttendandce/{currenPage}/{pagesize}")
    public AjaxResponse selectAttendandce(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<Attendandce> page = new Page<>(currenPage,pagesize);
        IPage<Attendandce> list=attendandceService.selectAttendandce(page);
        return AjaxResponse.success(list);

    }
    //修改考勤扣款方案状态
    @PutMapping("/updateAttendandceState")
    public AjaxResponse updateAttendandceState(@RequestBody Attendandce attendandce){
        return AjaxResponse.success( attendandceService.updateAttendandceState(attendandce) );
    }

    //删除考勤扣款方案
    @DeleteMapping("/deleteAttendandceId/{id}")
    public AjaxResponse deleteAttendandceId(@PathVariable("id") Long id){
        return AjaxResponse.success( attendandceService.deleteAttendandce(id) );
    }

    //根据id查询考勤扣款方案信息

    @GetMapping("/selectAttendandceId/{id}")
    public AjaxResponse selectAttendandceId(@PathVariable("id") Long id){
        Attendandce attendandce=attendandceService.selectAttendandceId(id);
        return AjaxResponse.success(attendandce);
    }
    //修改考勤扣款信息
    @PutMapping("/updateAttendandce")
    public AjaxResponse updateAttendandce(@RequestBody Attendandce attendandce){
        log.debug("123456789098765rfvbhy654edcvgtredc");
        log.debug(attendandce.toString());
        return AjaxResponse.success(attendandceService.updateAttendandce(attendandce));
    }

    //查询考勤扣款名称
    @GetMapping("/selectAttendandceName")
    public AjaxResponse selectAttendandceName(){
        List<Map<String, Object>> list=attendandceService.selectAttendandce();
        return AjaxResponse.success(list);
    }

}

