package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Travel;
import com.trkj.balance.modules.examine_management.service.TravelExService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 出差表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-02-24
 */
@RestController
@Slf4j
public class TravelExController {
    //添加方法
    @Autowired
    private TravelExService travelService;
    @PostMapping("/insertTravel")
    public AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {
        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        List<Auditflowdetail> auditflowdetails = JSON.parseArray(JSON.toJSONString(map.get("AuditflowDetail")), Auditflowdetail.class);
        Travel travel = JSON.parseObject(JSON.toJSONString(map.get("travel")), Travel.class);

        log.debug("222222222");
        log.debug(travel.toString());

        return AjaxResponse.success(travelService.insertStaff(auditflow,auditflowdetails,travel));
    }
}

