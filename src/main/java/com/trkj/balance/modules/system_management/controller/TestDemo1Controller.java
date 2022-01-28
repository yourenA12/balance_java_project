package com.trkj.balance.modules.system_management.controller;

import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.vo.AjaxResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/testDemo1")
public class TestDemo1Controller {

    // 前台传多个id方法
    @DeleteMapping("/listGet/{listIds}")
    public AjaxResponse listGet(@PathVariable("listIds") Long[] listIds ){

        log.debug( listIds.toString() + "11111" );

        for (Long id : listIds) {
            log.debug( id +"222");
        }

        return AjaxResponse.success(listIds);

    }

    // 前台传多个实体类的方法
    @PostMapping("/listEntity")
    public AjaxResponse listEntitys(@RequestBody Staff staff,@RequestBody Dept dept,@RequestBody Long[] listIds){

        log.debug( staff.toString() + "11111" );
        log.debug( dept.toString() + "22222" );

        for (Long id : listIds) {
            log.debug( id +"xxx");
        }

        return AjaxResponse.success(staff);

    }

    // 前台传多个复杂参数的方法
    @GetMapping("/listData")
    public AjaxResponse listData(@RequestParam("data1") int data1,@RequestParam("data2") String data2,@RequestParam("data3") ArrayList<Long> listIds){

        log.debug( data1 + "data1" );
        log.debug( data2 + "data2" );

        for (Long id : listIds) {
            log.debug( id +"xxx");
        }

        return AjaxResponse.success(listIds);

    }

    // 前台传多个复杂参数的方法
    @GetMapping("/listData2/{data1}/{data2}/{data3}")
    public AjaxResponse listData2(@PathVariable("data1") int data1,@PathVariable("data2") String data2,@PathVariable("data3") ArrayList<Long> listIds){

        log.debug( data1 + "data1" );
        log.debug( data2 + "data2" );

        for (Long id : listIds) {
            log.debug( id +"xxx");
        }

        return AjaxResponse.success(listIds);

    }


}
