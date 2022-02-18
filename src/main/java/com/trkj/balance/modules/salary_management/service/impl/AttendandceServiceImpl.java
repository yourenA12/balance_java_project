package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Attendandce;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.trkj.balance.modules.salary_management.mapper.AttendandceMapper;
import com.trkj.balance.modules.salary_management.service.AttendandceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤扣款方案表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-14
 */
@Service
public class AttendandceServiceImpl extends ServiceImpl<AttendandceMapper, Attendandce> implements AttendandceService {

    @Autowired
    private AttendandceMapper attendandceMapper;
    //新增考勤扣款方案
    @Override
    public int insertAttendandce(Attendandce attendandce) {
        return attendandceMapper.insert(attendandce);
    }
    //查询考勤扣款方案
    @Override
    public IPage<Attendandce> selectAttendandce(Page<Attendandce> page) {
        return attendandceMapper.selectPage(page,null);
    }

    //修改考勤扣款方案状态
    @Override
    public int updateAttendandceState(Attendandce attendandce) {
        return attendandceMapper.updateById(attendandce);
    }

    //删除考勤扣款方案
    @Override
    public int deleteAttendandce(Long id) {
        return attendandceMapper.deleteById(id);
    }

    //根据id查询考勤扣款方案信息
    @Override
    public Attendandce selectAttendandceId(Long id) {
        return attendandceMapper.selectById(id);
    }

    //修改考勤扣款方案
    @Override
    public int updateAttendandce(Attendandce attendandce) {
        return attendandceMapper.updateById(attendandce);
    }
}
