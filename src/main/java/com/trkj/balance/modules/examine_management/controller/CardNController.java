package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Card;
import com.trkj.balance.modules.examine_management.entity.Quit;
import com.trkj.balance.modules.examine_management.service.CardNService;
import com.trkj.balance.modules.examine_management.service.NoticeVoService;
import com.trkj.balance.modules.system_management.entity.NoticeVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 补打卡表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
@RestController
@Slf4j
public class CardNController {
    @Autowired
    private CardNService cardNService;
    @PostMapping("/insertCard")
    public AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {
        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        List<Auditflowdetail> auditflowdetails = JSON.parseArray(JSON.toJSONString(map.get("AuditflowDetail")), Auditflowdetail.class);
        Card card = JSON.parseObject(JSON.toJSONString(map.get("card")), Card.class);

        return AjaxResponse.success(cardNService.insertStaff(auditflow,auditflowdetails,card));
    }

}

