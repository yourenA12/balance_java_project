package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.mapper.EntryhirdeVoMapper;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class EntryhirdeVoServicelmpl extends ServiceImpl<EntryhirdeVoMapper, EntryhirdeVo> implements EntryhirdeVoService {

    @Autowired
    private EntryhirdeVoMapper entryhirdeMapper;

    @Override
    public IPage<EntryhirdeVo> selectEntryhirde1(Page<EntryhirdeVo> page, String staffNameSearch, ArrayList deptIds, String postSearch, Date clockTimeStart, Date clockTimeEnd) {
        //声明一个条件构造器
        QueryWrapper<EntryhirdeVo> wrapper=new QueryWrapper<>();
        if(staffNameSearch!="" && staffNameSearch!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("r.RESUME_NAME",staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }

        if(postSearch!="" && postSearch!=null){
            // 按部门id查询
            wrapper.eq("p.POSITION_ID",postSearch);
        }


        if(clockTimeStart+"" !="" &&  clockTimeEnd+"" !="" && clockTimeStart !=null &&  clockTimeEnd !=null){
            // 按入职时间段进行查询
            wrapper.between("s.STAFF_HIREDATE",clockTimeStart,clockTimeEnd);
        }

        // 员工当前状态为待入职
        wrapper.eq("r.RESUME_ZT",8);

        IPage<EntryhirdeVo> list=entryhirdeMapper.selectEntryhirde(page,wrapper);


        return list;
    }

    //放弃入职 查询放弃入职员工
    @Override
    public IPage<EntryhirdeVo> selectEntryhirdeFQ(Page<EntryhirdeVo> page,String staffNameSearch, ArrayList deptIds,String postSearch) {
        //声明一个条件构造器
        QueryWrapper<EntryhirdeVo> wrapper=new QueryWrapper<>();
        if(staffNameSearch!="" && staffNameSearch!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("r.RESUME_NAME",staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }

        if(postSearch!="" && postSearch!=null){
            // 按部门id查询
            wrapper.eq("p.POSITION_ID",postSearch);
        }

        // 员工当前状态为放弃入职
        wrapper.eq("r.RESUME_ZT",11);

        return entryhirdeMapper.selectEntryhirdeFQ(page,wrapper);
    }

    @Override
    public int selectFqhirdate(String date) {
        return entryhirdeMapper.selectFqhirdate(date);
    }
}
