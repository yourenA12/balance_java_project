package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.examine_management.entity.NoticeStaff;
import com.trkj.balance.modules.examine_management.mapper.NoticeStaffNMapper;
import com.trkj.balance.modules.examine_management.service.NoticeStaffNService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.system_management.mapper.NoticeStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告员工表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2022-03-03
 */
@Service
public class NoticeStaffNServiceImpl extends ServiceImpl<NoticeStaffNMapper, NoticeStaff> implements NoticeStaffNService {

    @Autowired
    private NoticeStaffNMapper noticeStaffNMapper;

    //公告表修改状态
    @Override
    public int updataNoticeStaff(NoticeStaff noticeStaff) {
        QueryWrapper<NoticeStaff> wrapper = new QueryWrapper<>();
        wrapper.eq("NOTICE_Id",noticeStaff.getNoticeId());
        wrapper.eq("STAFF_ID",noticeStaff.getStaffId());
        noticeStaff.setNoticeState(1l);
        return noticeStaffNMapper.update(noticeStaff,wrapper);
    }
}
