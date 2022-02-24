package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.InsuredStaffMapper;
import com.trkj.balance.modules.social_management.service.InsuredStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 * 参保方案员工中间表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
@Service
public class InsuredStaffServiceImpl extends ServiceImpl<InsuredStaffMapper, InsuredStaff> implements InsuredStaffService {

    @Autowired
    private InsuredStaffMapper insuredStaffMapper;

    @Autowired
    private StaffMapper staffMapper;

    //根据薪酬组员工中间表查询数据
    @Override
    public String selectInsuredStaffName(ArrayList<Integer> staffIds) {

        // 拿到员工id 查询 薪酬组员工中间表有无数据
        for (Integer staffId : staffIds) {

            //
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.eq("STAFF_ID",staffId);
            // 如果查询到了
            if(insuredStaffMapper.selectCount(wrapper)>0){
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
