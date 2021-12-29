package com.trkj.balance.modules.employee_management.service.impl;

import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.employee_management.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> list() {
        return staffMapper.selectList(null);
    }
}
