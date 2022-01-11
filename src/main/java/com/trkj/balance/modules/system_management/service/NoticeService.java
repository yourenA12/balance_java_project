package com.trkj.balance.modules.system_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

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

    // 删除某条公告 、、 先删除公告部门表中的数据（和公告员工表的数据），再删除公告表中的数据， 、、
    int deleteOneNotice(Long NoticeId);

    // 新增一条公告 、、 增加公告表后 还需要新增公告部门表 -- 部门id数据
    int insertOneNotice(Notice notice);

    // 修改某条公告 、、首先删除在进行添加？ 还是直接修改，重新读取一遍， ？、详情见删除公告
    int updateOneNotice(Notice notice);


    // 查询所有部门id 以及部门名称
    List<Map<Object,Object>> selectAllDeptName();

    // 按照公告表中的公告id 查询公告部门表中的部门名称
    List<Map<Object,Object>> selectAllDeptByNoticeId(Long NoticeId);


}
