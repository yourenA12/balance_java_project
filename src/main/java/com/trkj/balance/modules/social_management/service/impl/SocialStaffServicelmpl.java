package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.entity.DefScheme;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.DefSchemeMapper;
import com.trkj.balance.modules.social_management.mapper.InsuredStaffMapper;
import com.trkj.balance.modules.social_management.mapper.SocialStaffMapper;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.trkj.balance.modules.social_management.service.SocialStaffService;
import com.trkj.balance.modules.social_management.vo.SocialStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    // 方案表
    @Autowired
    private DefSchemeMapper schemeMapper;

    // 参保方案service
    @Autowired
    private DefInsuredService insuredService;

    //查询未参保员工
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

    // 添加参保方案员工表
    @Override
    @Transactional
    public int insertInsuredStaff(int insuredId, ArrayList<Integer> staffIds) {

        // 声明参保方案员工中间表
        InsuredStaff insuredStaff = new InsuredStaff();
        insuredStaff.setDefInsuredId((long) insuredId);// 参保方案id

        // 按参保方案id 查询方案表
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("DEF_INSURED_ID",insuredId);
        List<DefScheme> defSchemes = schemeMapper.selectList(wrapper);

        int upper=0;
        int lower=0;

        if(defSchemes.size()!=0){
            upper = Math.toIntExact(defSchemes.get(0).getDefSchemeMax());// 上限
            lower = Math.toIntExact(defSchemes.get(0).getDefSchemeMin());// 下限
        }

        for (Integer staffId : staffIds) {
            insuredStaff.setStaffId(Long.valueOf(staffId));// 员工id

            // 新增参保方案员工中间表
            int a = insuredStaffMapper.insert(insuredStaff);

            // 新增参保明细 与参保明细详情
            int b = insuredService.insertInsuredDetail(defSchemes,upper,lower,staffId);

            if(a<1 || b<1){
                // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                // 手动回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }

        }

        return 1;
    }


}
