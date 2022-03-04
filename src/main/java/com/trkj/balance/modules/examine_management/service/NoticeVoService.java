package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.system_management.entity.NoticeVo;

import java.util.List;

public interface NoticeVoService extends IService<NoticeVo> {
    //分页查询
    IPage<NoticeVo> findSelectNoticeVo(Page<NoticeVo> page,int staffId);
    //根据id查询 公告详情
    List<NoticeVo> findSelectNotice(Long id);
    //根据id查询公告已读详情
    List<NoticeVo> findSelectByIdNotice1(Long id);

}
