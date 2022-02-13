package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.attendance_management.mapper.ArchiveMapper;
import com.trkj.balance.modules.attendance_management.service.ArchiveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 月报表归档表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-07
 */
@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveMapper, Archive> implements ArchiveService {
    @Autowired
    public ArchiveMapper archiveMapper;

    @Override
    public IPage<Archive> selectArchive(Page<Archive> page) {
        return archiveMapper.selectArchive(page);
    }

    @Override
    public IPage<Archive> moss(int page, int size, String staffName) {
        Page<Archive> pagess=new Page<>(page,size);
        QueryWrapper<Archive> wrapper = new QueryWrapper<>();
        wrapper.like("STAFF_NAME",staffName);
        IPage<Archive> namepage=archiveMapper.selectPage(pagess,wrapper);
        return namepage;
    }
}
