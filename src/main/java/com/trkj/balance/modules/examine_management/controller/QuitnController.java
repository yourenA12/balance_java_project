package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Quit;
import com.trkj.balance.modules.examine_management.entity.Travel;
import com.trkj.balance.modules.examine_management.service.QuitnService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 离职表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-02-21
 */
@RestController
@Slf4j
public class QuitnController {
    //添加方法
    @Autowired
    private QuitnService quitnService;
    @PostMapping("/insertQuit")
    public AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {
        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        List<Auditflowdetail> auditflowdetails = JSON.parseArray(JSON.toJSONString(map.get("AuditflowDetail")), Auditflowdetail.class);
        Quit quit = JSON.parseObject(JSON.toJSONString(map.get("quit")), Quit.class);

      /*  log.debug("222222222");
        log.debug(travel.toString());*/

        return AjaxResponse.success(quitnService.insertStaff(auditflow,auditflowdetails,quit));
    }
}

