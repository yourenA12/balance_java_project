package com.trkj.balance.modules.employee_management.service.impl;

import com.trkj.balance.modules.employee_management.entity.Quit;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.Quit_StaffMapper;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.employee_management.service.Quit_StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 离职表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-08
 */
@Service
public class Quit_StaffServiceImpl extends ServiceImpl<Quit_StaffMapper, Quit> implements Quit_StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private Quit_StaffMapper quitMapper;

    //员工办理离职 添加离职表和修改员工状态
    @Override
    @Transactional
    public int insertDimission(Quit quit, Staff staff) {

        if(quitMapper.insert(quit)>0){
            // 从离职表里面取到员工id,根据id修改员工表状态
            staff.setStaffId( quit.getStaffId() );
            return staffMapper.updateById(staff);
        }
        return 0;

    }

}
