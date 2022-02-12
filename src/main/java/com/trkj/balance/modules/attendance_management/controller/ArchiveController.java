package com.trkj.balance.modules.attendance_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.attendance_management.service.ArchiveService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 月报表归档表 前端控制器
 * </p>
 *
 * @author 晚风
 * @since 2022-02-07
 */
@RestController
@RequestMapping("/archive")
public class ArchiveController {
    @Autowired
    public ArchiveService archiveService;

    @GetMapping("/ss/{currenPage}/{pagesize}")
    public AjaxResponse Arch(@PathVariable("currenPage") int page, @PathVariable("pagesize") int pagesize) {
        Page<Archive> pageable = new Page<>(page, pagesize);
        IPage<Archive> page1 = archiveService.selectArchive(pageable);
        return AjaxResponse.success(page1);
    }

    //模糊搜索
    @GetMapping("/dim/{currenPage}/{pagesize}/{input}")
    public AjaxResponse search(@PathVariable("currenPage") int page, @PathVariable("pagesize") int size,@PathVariable("input") String classesName) {
        IPage<Archive> sss = archiveService.moss(page, size, classesName);
        return AjaxResponse.success(sss);

    }

}

