package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.InsuredDetailVoMapper;
import com.trkj.balance.modules.social_management.service.InsuredDetailVoService;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredDetailVoServiceImpl extends ServiceImpl<InsuredDetailVoMapper, InsuredDetailVo> implements InsuredDetailVoService {

    // 参保明细
    @Autowired
    private InsuredDetailVoMapper detailVoMapper;

    // 查询社保缴费明细
    @Override
    public IPage<InsuredDetailVo> selectInsuredDetail(IPage<InsuredDetailVo> page, String staffNameSearch, ArrayList deptIds, String stateSearch,String scheme_name, String date) {
        QueryWrapper<InsuredDetailVo> wrapper=new QueryWrapper();

        if(staffNameSearch!="" && staffNameSearch!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("b.STAFF_NAME",staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("b.DEPT_ID",deptIds);
        }

        if(stateSearch!="" && stateSearch!=null){
            // 按员工状态
            wrapper.eq("b.STAFF_STATE",stateSearch);
        }

        if(scheme_name!="" && scheme_name!=null){
            // 按参保方案
            wrapper.eq("d.DEF_INSURED_ID",scheme_name);
        }

        // id 不为空
        wrapper.isNotNull("b.STAFF_ID");

        return detailVoMapper.selectInsuredDetail(page,wrapper,date);


    }

    // 查询员工缴费信息
    @Override
    public InsuredDetailVo selectInsuredDetailVo(Long id,String date) {
        return detailVoMapper.selectInsuredDetailVo(id,date);
    }

}
