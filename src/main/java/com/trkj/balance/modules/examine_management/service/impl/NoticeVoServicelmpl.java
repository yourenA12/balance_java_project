package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.NoticeVoMapper;
import com.trkj.balance.modules.examine_management.service.NoticeVoService;
import com.trkj.balance.modules.system_management.entity.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeVoServicelmpl extends ServiceImpl<NoticeVoMapper, NoticeVo> implements NoticeVoService {
    @Autowired
    private NoticeVoMapper noticeVoMapper;

    @Override
    public IPage<NoticeVo> findSelectNoticeVo(Page<NoticeVo> page,int staffId) {
        QueryWrapper<NoticeVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("S.STAFF_ID",staffId);
        queryWrapper.eq("N.IS_DELETED",0).orderByDesc("N.UPDATED_TIME");
        return noticeVoMapper.findNoticeVo(page,queryWrapper);
    }
    //查询未读公告
    @Override
    public List<NoticeVo> findSelectNotice(Long id) {
        return noticeVoMapper.findSelectByIdNotice(id);
    }
    //查询已读公告
    @Override
    public List<NoticeVo> findSelectByIdNotice1(Long id) {
        return noticeVoMapper.findSelectByIdNotice1(id);
    }
    //修改公告状态

}
