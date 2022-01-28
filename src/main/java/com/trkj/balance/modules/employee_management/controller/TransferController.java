package com.trkj.balance.modules.employee_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.employee_management.service.StaffService;
import com.trkj.balance.modules.employee_management.service.TransferService;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 调动记录表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
@Slf4j
@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;


    @PostMapping("/insertTransfer")
    private AjaxResponse insertTransfer(@RequestBody Map<Object, Object> map) {

        Transfer transfer = JSON.parseObject(JSON.toJSONString(map.get("Transfer")), Transfer.class);
        Staff staff = JSON.parseObject(JSON.toJSONString(map.get("Staff")), Staff.class); // 取map中的 员工表数据 转换为实体类
        log.debug(transfer.toString()+"0000000000000");
        log.debug(staff.toString());
        //调用入职方法，
        return AjaxResponse.success(transferService.insertTransfer(transfer,staff));
    }

    //查询调动记录
    @GetMapping("/selectTransfer/{currenPage}/{pagesize}")
    public AjaxResponse selectHistorical(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize){

        Page<Transfer> page = new Page<>(currenPage,pagesize);
        IPage<Transfer> list=transferService.selectTransfer(page);
        return AjaxResponse.success(list);
    }


}

