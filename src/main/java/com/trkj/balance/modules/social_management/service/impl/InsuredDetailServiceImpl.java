package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.social_management.entity.InsuredDetail;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.*;
import com.trkj.balance.modules.social_management.service.InsuredDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 参保明细表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-02-28
 */
@Service
public class InsuredDetailServiceImpl extends ServiceImpl<InsuredDetailMapper, InsuredDetail> implements InsuredDetailService {

    // 参保明细
    @Autowired
    private InsuredDetailMapper detailMapper;

    // 参保明细详情
    @Autowired
    private InsuredDetailSonMapper detailSonMapper;

    // 参保方案员工中间表
    @Autowired
    private InsuredStaffMapper insuredStaffMapper;

    // 参保方案部门职位中间表
    @Autowired
    private InsuredDeptPostMapper insuredDeptPostMapper;

    // 方案表
    @Autowired
    private DefSchemeMapper defSchemeMapper;

    // 参保方案表
    @Autowired
    private DefInsuredMapper defInsuredMapper;

    // 按员工id删除参保all
    @Override
    @Transactional
    public int deleteInsuredAll(ArrayList<Integer> staffIds) {

        if(staffIds.size()==0) return 0;

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("STAFF_ID",staffIds);
        // 按员工id删除参保明细表
        detailMapper.deleteByDate(wrapper);
        // 按员工id删除参保明细详情表
        detailSonMapper.deleteByDate(wrapper);
        // 按员工id删除参保方案员工中间表
        insuredStaffMapper.delete(wrapper);

//        // 按员工id查询参保方案员工中间表的参保方案id
//        QueryWrapper wrapper1 = new QueryWrapper<>();
//        wrapper1.in("STAFF_ID",staffIds);
//        List<InsuredStaff> insuredStaffs = insuredStaffMapper.selectList(wrapper1);
//
//        if ( insuredStaffs.size()<1 ){
//            // 如果小于1，就是添加失败，则回滚，前台会提示失败
//            // 手动回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return 0;
//        }
//
//        // 声明一个参保方案ids
//        List<Integer> insuredIds = new ArrayList<>();
//        // 循环查询出来的数据，将id拿出来
//        for (InsuredStaff insuredStaff : insuredStaffs) {
//            // 加入参保方案ids中
//            insuredIds.add(Math.toIntExact(insuredStaff.getDefInsuredId()));
//        }
//
//        //
//        QueryWrapper wrapper3 = new QueryWrapper<>();
//        wrapper3.in("DEF_INSURED_ID", insuredIds);

//        // 按参保方案id删除 参保方案部门职位中间表
//        insuredDeptPostMapper.delete(wrapper3);

//        // 按参保方案id删除 参保方案员工中间表
//        insuredStaffMapper.delete(wrapper3);

//        // 按参保方案id删除 方案表
//        defSchemeMapper.delete(wrapper3);
//
//        // 按参保方案id删除 参保方案表
//        defInsuredMapper.delete(wrapper3);

        return 1;
    }

    //根据id查询参保明细
    @Override
    public IPage<InsuredDetail> selectInsuredDetailPage(IPage<InsuredDetail> page,Long id) {
        return detailMapper.selectInsuredDetailPage(page,id);
    }


}
