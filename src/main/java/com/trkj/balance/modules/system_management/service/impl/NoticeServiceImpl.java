package com.trkj.balance.modules.system_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.trkj.balance.modules.system_management.entity.NoticeDept;
import com.trkj.balance.modules.system_management.entity.NoticeStaff;
import com.trkj.balance.modules.system_management.mapper.Dept_NoticeMapper;
import com.trkj.balance.modules.system_management.mapper.NoticeDeptMapper;
import com.trkj.balance.modules.system_management.mapper.NoticeMapper;
import com.trkj.balance.modules.system_management.mapper.NoticeStaffMapper;
import com.trkj.balance.modules.system_management.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 员工表
    @Autowired
    private StaffMapper staffMapper;

    // 分页查询公告
    @Override
    public IPage<Notice> selectAllPage(Page<Notice> page,String noticeTitle,String noticePeople,String noticeType) {

        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        if(noticeTitle!=null && noticeTitle!=""){
            wrapper.like("NOTICE_TITLE",noticeTitle);
        }

        if(noticePeople!=null && noticePeople!=""){
            wrapper.like("NOTICE_PEOPLE",noticePeople);
        }

        if(noticeType!=null && noticeType!=""){
            wrapper.eq("NOTICE_TYPE",noticeType);
        }

        return noticeMapper.selectPage(page,wrapper);
    }

    // 删除某条公告 、、 先删除公告部门表中的数据（和公告员工表的数据），再删除公告表中的数据， 、、
    // 多删
    @Override
    @Transactional
    public int deleteNotices(ArrayList<Long> noticeIds) {

        if(noticeIds.size()<1){
            return 0;
        }

        for (Long noticeId : noticeIds) {
            // 先删除公告部门表
            // 删除公告部门表中，带公告ID的数据
            noticeDeptMapper.deleteNoticeDept(noticeId);

            // 再删除公告员工表
            // 删除公告部门表中，带公告ID的数据
            noticeStaffMapper.deleteNoticeStaff(noticeId);

            // 再按照公告ID删除公告表
            noticeMapper.deleteById(noticeId);
        }

        return 1;

    }

    // 新增一条公告 、、 增加公告表后 还需要新增公告部门表 -- 部门id数据
    @Override
    @Transactional
    public int insertOneNotice(Notice notice) {

        // 先新增公告表
        noticeMapper.insert(notice);
        // 新增公告部门表
        NoticeDept noticeDept = new NoticeDept();
        noticeDept.setNoticeId(notice.getNoticeId());// 公告id
        // 循环部门id
        for (Long deptId : notice.getDeptIds()) {
            noticeDept.setDeptId(deptId);// 部门id
            noticeDeptMapper.insert(noticeDept);// 新增公告部门表
        }


        return 1;

    }

    // 修改某条公告 、、首先删除在进行添加？ 还是直接修改，重新读取一遍， ？、详情见删除公告
    @Override
    @Transactional
    public int updateOneNotice(Notice notice) {

        // 先删除公告部门表
        // 删除公告部门表中，带公告ID的数据
        noticeDeptMapper.deleteNoticeDept(notice.getNoticeId());

        // 再删除公告员工表
        // 删除公告部门表中，带公告ID的数据
        noticeStaffMapper.deleteNoticeStaff(notice.getNoticeId());

        // 修改原公告表中的数据
        noticeMapper.updateById(notice);

        // 新建一个部门公告表对象
        NoticeDept noticeDept = new NoticeDept();
        noticeDept.setNoticeId( notice.getNoticeId() );// 公告表id
        // 再添加公告部门表
        for( int i =0;i<notice.getDeptIds().size();i++ ){

            noticeDept.setDeptId(notice.getDeptIds().get(i));// 部门表id
            // 添加公告部门表
            noticeDeptMapper.insert(noticeDept);

        }

        // 按部门id查询员工表
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("DEPT_ID",notice.getDeptIds());
        List<Staff> staffs = staffMapper.selectList(wrapper);

        // 新增公告员工表
        NoticeStaff noticeStaff = new NoticeStaff();
        noticeStaff.setNoticeId(notice.getNoticeId());// 公告id
        //循环员工id
        for (Staff staff : staffs) {
            noticeStaff.setStaffId(staff.getStaffId());// 员工id
            noticeStaffMapper.insert(noticeStaff);// 新增公告员工表
        }

        return 1;
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
    public List<Map<Object, Object>> selectAllDeptByNoticeId(Long noticeId) {
        // SELECT DEPT_ID,DEPT_NAME  FROM DEPT
        //      WHERE DEPT_ID IN (
        //            select DEPT_ID from NOTICE_DEPT
        //            where
        //                NOTICE_ID=1
        //        )
        //        AND IS_DELETED = ?
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.inSql("DEPT_ID","select DEPT_ID from NOTICE_DEPT where NOTICE_ID="+noticeId);
        wrapper.eq("IS_DELETED",0);
        return deptMapper_notice.selectMaps(wrapper);
    }

    // 按公告id查询公告员工表
    @Override
    public List<Map<Object, Object>> selectNoticeStaffByNoticeId(Long noticeId, Long staffId) {
        return noticeStaffMapper.selectNoticeStaffByNoticeId(noticeId , staffId);
    }

}
