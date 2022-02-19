package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import com.trkj.balance.modules.system_management.entity.NoticeVo;

public interface NoticeVoService extends IService<NoticeVo> {
    //分页查询
    IPage<NoticeVo> findSelectNoticeVo(Page<NoticeVo> page,int staffId);

}
