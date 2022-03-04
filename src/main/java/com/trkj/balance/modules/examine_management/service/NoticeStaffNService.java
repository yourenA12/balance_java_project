package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.NoticeStaff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 公告员工表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2022-03-03
 */
public interface NoticeStaffNService extends IService<NoticeStaff> {
    //根据id 修改
    int updataNoticeStaff(NoticeStaff noticeStaff);

}
