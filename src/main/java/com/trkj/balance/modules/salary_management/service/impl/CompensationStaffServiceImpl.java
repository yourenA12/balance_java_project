package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.entity.CompensationStaff;
import com.trkj.balance.modules.salary_management.mapper.CompensationStaffMapper;
import com.trkj.balance.modules.salary_management.service.CompensationStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 * 薪酬组员工中间表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-23
 */
@Service
public class CompensationStaffServiceImpl extends ServiceImpl<CompensationStaffMapper, CompensationStaff> implements CompensationStaffService {

    @Autowired
    private CompensationStaffMapper compensationStaffMapper;

    @Autowired
    private StaffMapper staffMapper;

    //根据薪酬组员工中间表查询数据
    @Override
    public String selectCompensationStaffName(ArrayList<Integer> staffIds) {

        // 拿到员工id 查询 薪酬组员工中间表有无数据
        for (Integer staffId : staffIds) {

            //
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.eq("STAFF_ID",staffId);
            // 如果查询到了
            if(compensationStaffMapper.selectCount(wrapper)>0){
                // 再拿员工id 查询员工名称
                QueryWrapper wrapper1 = new QueryWrapper<>();
                wrapper1.select("STAFF_NAME").eq("STAFF_ID",staffId);
                Staff staff = staffMapper.selectOne(wrapper1);
                // 返回员工名称
                return staff.getStaffName();
            }

        }

        return null;
    }
}
