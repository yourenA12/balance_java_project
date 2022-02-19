package com.trkj.balance.modules.examine_management.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.service.NoticeVoService;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import com.trkj.balance.modules.system_management.entity.NoticeVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NoticeVoController {
    @Autowired
    private NoticeVoService noticeVoService;
    @GetMapping("/findNoticeVo/{currentPage}/{pagesize}/{staffId}")
    public AjaxResponse findNoticeVo(@PathVariable("currentPage") int currenPage, @PathVariable("pagesize") int pagesize,@PathVariable("staffId") int staffId){
        Page<NoticeVo> page = new Page<>(currenPage,pagesize);
        IPage<NoticeVo> list=noticeVoService.findSelectNoticeVo(page,staffId);
        return AjaxResponse.success(noticeVoService.findSelectNoticeVo(page,staffId));
    }
}
