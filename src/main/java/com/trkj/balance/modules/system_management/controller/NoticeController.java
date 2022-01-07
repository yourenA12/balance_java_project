package com.trkj.balance.modules.system_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.modules.system_management.service.NoticeService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-01-05
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 查询所有公告
    @GetMapping("/selectAllPage/{currentPage}/{pagesize}")
    public AjaxResponse selectAllPage(@PathVariable("currentPage") int currenPage, @PathVariable("pagesize") int pagesize){
        Page<Notice> page = new Page<>(currenPage,pagesize);
        IPage<Notice> list = noticeService.selectAllPage(page);
        return AjaxResponse.success(list);
    }

    // 按id删除某条公告
    @DeleteMapping("/deleteOneNotice/{id}")
    public AjaxResponse deleteOneNotice(@PathVariable Long id){
        return AjaxResponse.success( noticeService.deleteOneNotice(id) );
    }

    // 新增一条公告
    @PostMapping("/insertOneNotice")
    public AjaxResponse insertOneNotice(@RequestBody Notice notice){

        // 先添加 公告表  =》再添加 公告部门表

        return AjaxResponse.success( noticeService.insertOneNotice(notice) );
    }


    // 查询所有部门id与名称
    @GetMapping("/selectAllDept")
    public AjaxResponse selectAllDept(){
        return AjaxResponse.success( noticeService.selectAllDeptName() );
    }


}

