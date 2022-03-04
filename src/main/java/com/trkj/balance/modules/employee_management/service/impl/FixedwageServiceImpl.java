package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.mapper.FixedwageMapper;
import com.trkj.balance.modules.employee_management.service.FixedwageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.modules.salary_management.entity.CompensationStaff;
import com.trkj.balance.modules.salary_management.mapper.CompensationStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 固定工资表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-25
 */
@Service
public class FixedwageServiceImpl extends ServiceImpl<FixedwageMapper, Fixedwage> implements FixedwageService {

    // 固定工资
    @Autowired
    private FixedwageMapper fixedwageMapper;

    // 薪酬组员工
    @Autowired
    private CompensationStaffMapper compensationStaffMapper;

    //分页查询固定工资表数据
    @Override
    public IPage<Fixedwage> selectFixedwagePage(IPage<Fixedwage> page, int compId, String staffNameSearch, ArrayList deptIds, String postSearch) {

        // 按薪酬组id查询薪酬组员工中间表
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("COMPENSATION_ID",compId);
        List<CompensationStaff> lists = compensationStaffMapper.selectList(wrapper1);

        if(lists.size()==0) return null;

        List ids = new ArrayList<>();
        for (CompensationStaff list : lists) {
            // 循环添加员工id
            ids.add(list.getStaffId());
        }

        // 声明一个条件构造器
        QueryWrapper<StaffVo> wrapper = new QueryWrapper<>();

        if(staffNameSearch!="" && staffNameSearch!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("s.STAFF_NAME",staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }
        if(postSearch!="" && postSearch!=null){
            // 按职位id查询
            wrapper.eq("p.POSITION_ID",postSearch);
        }

        // 员工为该薪酬组
        wrapper.in("s.STAFF_ID",ids);

        // 员工当前状态不为离职
        wrapper.ne("s.STAFF_STATE",1);

        return fixedwageMapper.selectFixedwagePage(page,wrapper);
    }


}
