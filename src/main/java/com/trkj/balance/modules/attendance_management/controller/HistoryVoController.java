package com.trkj.balance.modules.attendance_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.trkj.balance.modules.attendance_management.service.HistoryServie;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/archive")
public class HistoryVoController {
    @Autowired
    public HistoryServie historyServie;


    @GetMapping("/HiS/{currenPage}/{pagesize}")
    public AjaxResponse Arch(@PathVariable("currenPage") int page, @PathVariable("pagesize") int pagesize) {
        Page<Archive> pageable = new Page<>(page, pagesize);
        IPage<Archive> page1 = historyServie.selectHis(pageable);
        return AjaxResponse.success(page1);
    }
}
