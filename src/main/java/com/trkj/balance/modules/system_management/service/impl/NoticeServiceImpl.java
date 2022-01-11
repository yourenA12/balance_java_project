package com.trkj.balance.modules.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.modules.system_management.mapper.Dept_NoticeMapper;
import com.trkj.balance.modules.system_management.mapper.NoticeDeptMapper;
import com.trkj.balance.modules.system_management.mapper.NoticeMapper;
import com.trkj.balance.modules.system_management.mapper.NoticeStaffMapper;
import com.trkj.balance.modules.system_management.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    // 公告表
    @Autowired
    private NoticeMapper noticeMapper;

    // 部门表
    @Autowired
    private Dept_NoticeMapper deptMapper_notice;

    // 公告部门表
    @Autowired
    private NoticeDeptMapper noticeDeptMapper;

    // 公告员工表
    @Autowired
    private NoticeStaffMapper noticeStaffMapper;

    // 分页查询公告
    @Override
    public IPage<Notice> selectAllPage(Page<Notice> page) {
        return noticeMapper.selectPage(page,null);
    }

    // 删除某条公告 、、 先删除公告部门表中的数据（和公告员工表的数据），再删除公告表中的数据， 、、
    @Override
    @Transactional
    public int deleteOneNotice(Long NoticeId) {

        // 先删除公告部门表
        QueryWrapper noticeDeptWrapper = new QueryWrapper<>();
        // 删除公告部门表中，带公告ID的数据
        noticeDeptWrapper.eq("NOTICE_ID",NoticeId);
        noticeDeptMapper.delete(noticeDeptWrapper);

        // 再删除公告员工表
        QueryWrapper noticeStaffWrapper = new QueryWrapper<>();
        // 删除公告部门表中，带公告ID的数据
        noticeStaffWrapper.eq("NOTICE_ID",NoticeId);
        noticeStaffMapper.delete(noticeStaffWrapper);

        // 再按照公告ID删除公告表
        return noticeMapper.deleteById(NoticeId);
    }

    // 新增一条公告 、、 增加公告表后 还需要新增公告部门表 -- 部门id数据
    @Override
    public int insertOneNotice(Notice notice) {

        // 先新增公告表
        return noticeMapper.insert(notice);

    }

    // 修改某条公告 、、首先删除在进行添加？ 还是直接修改，重新读取一遍， ？、详情见删除公告
    @Override
    public int updateOneNotice(Notice notice) {

        // 先删除公告部门表
        QueryWrapper noticeDeptWrapper = new QueryWrapper<>();
        // 删除公告部门表中，带公告ID的数据
        noticeDeptWrapper.eq("NOTICE_ID",notice.getNoticeId());
        noticeDeptMapper.delete(noticeDeptWrapper);

        // 再删除公告员工表
        QueryWrapper noticeStaffWrapper = new QueryWrapper<>();
        // 删除公告部门表中，带公告ID的数据
        noticeStaffWrapper.eq("NOTICE_ID",notice.getNoticeId());
        noticeStaffMapper.delete(noticeStaffWrapper);

        // 修改原公告表中的数据
        noticeMapper.updateById(notice);

        // 再添加公告部门表
       /* for( int i =0;部门id.size();i++ ){

            // 新建一个部门公告表对象
            NoticeDept noticeDept = new NoticeDept();
            noticeDept.setNoticeId( notice.getNoticeId() );// 公告表id
            noticeDept.setDeptId(部门id[i]);// 部门表id
            // 添加公告部门表
            noticeDeptMapper.insert(noticeDept);

        }
*/
        return 0;
    }

    // 查询所有部门id 与 部门名称
    @Override
    public List<Map<Object, Object>> selectAllDeptName() {
        // SELECT DEPT_ID,DEPT_NAME FROM DEPT WHERE IS_DELETED = ?
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.eq("IS_DELETED",0);
        return deptMapper_notice.selectMaps(wrapper);
    }

    // 按公告id查询部门id 与 部门名称
    @Override
    public List<Map<Object, Object>> selectAllDeptByNoticeId(Long NoticeId) {
        // SELECT DEPT_ID,DEPT_NAME  FROM DEPT
        //      WHERE DEPT_ID IN (
        //            select DEPT_ID from NOTICE_DEPT
        //            where
        //                NOTICE_ID=1
        //        )
        //        AND IS_DELETED = ?
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.inSql("DEPT_ID","select DEPT_ID from NOTICE_DEPT where NOTICE_ID="+NoticeId);
        wrapper.eq("IS_DELETED",0);
        return deptMapper_notice.selectMaps(wrapper);
    }
}
