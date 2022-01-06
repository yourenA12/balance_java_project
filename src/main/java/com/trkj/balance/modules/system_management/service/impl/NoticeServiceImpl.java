package com.trkj.balance.modules.system_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.modules.system_management.mapper.NoticeMapper;
import com.trkj.balance.modules.system_management.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-05
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    // 分页查询公告
    @Override
    public IPage<Notice> selectAllPage(Page<Notice> page) {
        return noticeMapper.selectPage(page,null);
    }

    // 删除某条公告
    @Override
    @Transactional
    public int deleteOneNotice(Long id) {
        return noticeMapper.deleteById(id);
    }

    // 新增一条公告
    @Override
    public int insertOneNotice(Notice notice) {
        return noticeMapper.insert(notice);
    }

    // 修改一条公告
    @Override
    public int updateOneNotice(Notice notice) {
        return 0;
    }
}
