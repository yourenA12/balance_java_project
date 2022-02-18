package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Attendandce;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.entity.Workscheme;

/**
 * <p>
 * 考勤扣款方案表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-14
 */
public interface AttendandceService extends IService<Attendandce> {

    //新增考勤扣款方案
    int insertAttendandce(Attendandce attendandce);

    //查询考勤扣款方案
    IPage<Attendandce> selectAttendandce(Page<Attendandce> page);

    //修改考勤扣款方案状态
    int updateAttendandceState(Attendandce attendandce);

    //删除考勤扣款方案
    int deleteAttendandce(Long id);

    //根据id查询考勤扣款方案信息
    Attendandce selectAttendandceId(Long id );

    //修改考勤扣款方案
    int updateAttendandce(Attendandce attendandce);

}
