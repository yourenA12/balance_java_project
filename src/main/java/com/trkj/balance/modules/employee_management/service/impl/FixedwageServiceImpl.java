package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.mapper.FixedwageMapper;
import com.trkj.balance.modules.employee_management.service.FixedwageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    @Autowired
    private FixedwageMapper fixedwageMapper;

    //分页查询固定工资表数据
    @Override
    public IPage<Fixedwage> selectFixedwagePage(IPage<Fixedwage> page, String staffNameSearch, ArrayList deptIds, String postSearch) {
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

        // 员工当前状态为离职
        wrapper.ne("s.STAFF_STATE",1);



        return fixedwageMapper.selectFixedwagePage(page,wrapper);
    }


}
