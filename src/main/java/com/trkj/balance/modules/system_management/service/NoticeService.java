package com.trkj.balance.modules.system_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-05
 */
public interface NoticeService extends IService<Notice> {

    // 分页查询公告
    IPage<Notice> selectAllPage(Page<Notice> page);

    // 删除某条公告
    int deleteOneNotice(Long id);

    // 新增一条公告
    int insertOneNotice(Notice notice);

    // 修改某条公告
    int updateOneNotice(Notice notice);


    // 查询所有部门名称

}
