package com.trkj.balance.modules.system_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.modules.system_management.service.NoticeService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-01-05
 */
@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 查询所有公告
    @GetMapping("/selectAllPage")
    public AjaxResponse selectAllPage(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                      @RequestParam("noticeTitle") String noticeTitle,@RequestParam("noticePeople") String noticePeople,
                                      @RequestParam("noticeType") String noticeType){
        Page<Notice> page = new Page<>(currenPage,pagesize);
        IPage<Notice> list = noticeService.selectAllPage(page,noticeTitle,noticePeople,noticeType);
        return AjaxResponse.success(list);
    }

    // 按id删除某条公告,或删除多条公告
    @DeleteMapping("/deleteNotices/{deleteNoticeIds}")
    public AjaxResponse deleteNotices(@PathVariable("deleteNoticeIds") ArrayList<Long> noticeIds){
        return AjaxResponse.success( noticeService.deleteNotices(noticeIds) );
    }

    // 新增一条公告
    @PostMapping("/insertOneNotice")
    public AjaxResponse insertOneNotice(@RequestBody Notice notice){

        // 先添加 公告表  =》再添加 公告部门表

        return AjaxResponse.success( noticeService.insertOneNotice(notice) );
    }


    // 修改某条公告
    @PutMapping("/updateOneNotice")
    public AjaxResponse updateOneNotice(@RequestBody Notice notice){
        return AjaxResponse.success( noticeService.updateOneNotice(notice) );
    }


    // 查询所有部门id与名称
    @GetMapping("/selectAllDept")
    public AjaxResponse selectAllDept(){
        return AjaxResponse.success( noticeService.selectAllDeptName() );
    }

    // 按公告id查询部门id 与 部门名称
    @GetMapping("/selectAllDeptByNoticeId/{noticeId}")
    public AjaxResponse selectAllDeptByNoticeId(@PathVariable("noticeId") Long noticeId ){
        return AjaxResponse.success( noticeService.selectAllDeptByNoticeId(noticeId) );
    }

    // 按公告id查询公告员工表
    @GetMapping("/selectNoticeStaffByNoticeId/{noticeId}/{staffId}")
    public AjaxResponse selectNoticeStaffByNoticeId(@PathVariable("noticeId") Long noticeId,@PathVariable("staffId") Long staffId ){
        return AjaxResponse.success( noticeService.selectNoticeStaffByNoticeId(noticeId,staffId) );
    }

}

