package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.Vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.*;
import com.trkj.balance.modules.salary_management.mapper.*;
import com.trkj.balance.modules.salary_management.service.SalaryFixedService;
import com.trkj.balance.modules.salary_management.service.WageVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WageVoServicelmpl extends ServiceImpl<WageVoMapper, WagVo> implements WageVoService {
    //工资表
    @Autowired
    private WageVoMapper wageVoMapper;

    //薪酬组
    @Autowired
    private CompensationMapper compensationMapper;

    //薪酬组员工中间表
    @Autowired
    private CompensationStaffMapper compensationStaffMapper;

    //加班方案
    @Autowired
    private WorkschemeMapper workschemeMapper;

    //考勤扣款方案
    @Autowired
    private AttendandceMapper attendandceMapper;

    //出差方案
    @Autowired
    private BusinessMapper businessMapper;

    //查询工资
    @Override
    public IPage<WagVo> selectWagVo(IPage<WagVo> page,int compensationId) {
        QueryWrapper wrapper=new QueryWrapper<>();
        wrapper.eq("COMPENSATION_ID",compensationId);
        //按薪酬组id查询薪酬组里面的员工
        List<CompensationStaff> compensationStaffs = compensationStaffMapper.selectList(wrapper);

        //声明一个员工id
        List<Integer> staffIds=new ArrayList<>();
        for (CompensationStaff compensationStaff : compensationStaffs) {
            // 将员工id循环添加到List中
            staffIds.add(Math.toIntExact(compensationStaff.getStaffId()));

        }

        //如果staffIds为0,直接返回null
        if(staffIds.size()==0) return null;

        //根据员工id查询全部的员工
        QueryWrapper wrapper1=new QueryWrapper<>();
        wrapper1.in("c.STAFF_ID",staffIds);
      IPage<WagVo> wagVos=  wageVoMapper.selectWagVo(page,wrapper1);

        //根据薪酬组id查询 （加班方案id，扣款方案id，出差方案id）
        QueryWrapper wrapper2=new QueryWrapper();
        wrapper2.eq("COMPENSATION_ID",compensationId);
       Compensation compensation= compensationMapper.selectOne(wrapper2);

        // 查询加班方案 （节假日加班比例，休息日加班比例，工作日加班比例）
        QueryWrapper wrapper3=new QueryWrapper();
        wrapper3.eq("WORKSCHEME_ID",compensation.getWorkschemeId());
       Workscheme workscheme= workschemeMapper.selectOne(wrapper3);

       //-- 考勤扣款方案（迟到一次金额，早退一次金额，旷工一天金额）
        QueryWrapper wrapper4=new QueryWrapper();
        wrapper4.eq("ATTENDANDCE_ID",compensation.getAttendandceId());
        Attendandce attendandce= attendandceMapper.selectOne(wrapper4);

        //查询出差方案（出差一天金额）
        QueryWrapper wrapper5=new QueryWrapper();
        wrapper5.eq("BUSINESS_ID",compensation.getBusinessId());
        Business business= businessMapper.selectOne(wrapper5);

        return null;
    }
}
