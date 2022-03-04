package com.trkj.balance.modules.examine_management.controller;


import com.trkj.balance.modules.examine_management.entity.NoticeStaff;
import com.trkj.balance.modules.examine_management.service.NoticeStaffNService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公告员工表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-03-03
 */
@RestController
@RequestMapping("/noticeStaff")
public class NoticeStaffNController {

    @Autowired
    private NoticeStaffNService noticeStaffNService;
    //
    @PutMapping("/findNoticeStaffById")
    public AjaxResponse findNoticeStaffById(@RequestBody NoticeStaff noticeStaff){

     return AjaxResponse.success(noticeStaffNService.updataNoticeStaff(noticeStaff));
    }
}

