package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.InsuredStaffMapper;
import com.trkj.balance.modules.social_management.mapper.SocialStaffMapper;
import com.trkj.balance.modules.social_management.service.SocialStaffService;
import com.trkj.balance.modules.social_management.vo.SocialStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialStaffServicelmpl extends ServiceImpl<SocialStaffMapper, SocialStaffVo> implements SocialStaffService {

    // 员工
    @Autowired
    private SocialStaffMapper socialStaffMapper;

    // 参保方案员工中间表
    @Autowired
    private InsuredStaffMapper insuredStaffMapper;

    //查询全部员工
    @Override
    public IPage<SocialStaffVo> selectSocialPage(IPage<SocialStaffVo> page, String staffNameSearch, ArrayList deptIds, String stateSearch) {
        QueryWrapper<SocialStaffVo> wrapper=new QueryWrapper();

        if(staffNameSearch!="" && staffNameSearch!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("s.STAFF_NAME",staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }

        if(stateSearch!="" && stateSearch!=null){
            // 按员工状态
            wrapper.eq("s.STAFF_STATE",stateSearch);
        }

        wrapper.ne("s.STAFF_STATE",1);

        // 员工ids
        List<Integer> staffIds = new ArrayList<>();

        // 查询参保方案员工表
        List<InsuredStaff> insuredStaffs = insuredStaffMapper.selectList(null);
        for (InsuredStaff insuredStaff : insuredStaffs) {
            staffIds.add(Math.toIntExact(insuredStaff.getStaffId()));
        }
        // 查询员工编号不在参保方案员工表中
        if(staffIds.size()!=0){
            wrapper.notIn("s.STAFF_ID",staffIds);
        }

        return socialStaffMapper.selectSocialPage(page,wrapper);
    }


}
