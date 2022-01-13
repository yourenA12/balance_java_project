package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.entity.DeptPost;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.*;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import com.trkj.balance.modules.employee_management.service.StaffVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.StaffVo;

import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StaffVoServicelmpl extends ServiceImpl<StaffVoMapper, StaffVo> implements StaffVoService {

   @Autowired
   private StaffMapper staffMapper;

   @Autowired
   private StaffVoMapper staffVoMapper;

   //部门名称
   @Autowired
   private DeptNameMapper deptNameMapper;

   @Autowired
   //部门职位名称
    private Dept_Post_NameMapper deptPostNameMapper;


    @Override
    public IPage<StaffVo> selectStaffVo(Page<StaffVo> page) {

        IPage<StaffVo> list=staffVoMapper.selectStaffVo(page);

        for (StaffVo staffVo : list.getRecords()) {

            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            // 放入 入职日期 与 当前日期
            Period period = Period.between( LocalDate.parse( df.format(staffVo.getStaffHiredate()) ),
                    LocalDate.parse( df.format(new Date()) ));
            // 将 计算好的工龄 放入 vo 视图中
            staffVo.setStaffWorkingYears( period.getYears()+"年"+period.getMonths()+"月"+period.getDays()+"日" );

            //往数据库做修改
            Staff staff=new Staff();
            //取当前循环的员工id
            staff.setStaffId(staffVo.getStaffId());
            //取当前循环员工的工龄
            staff.setStaffWorkingYears(staffVo.getStaffWorkingYears());
            staffMapper.updateById(staff);

        }
        return list;
    }

    @Override
    public List<StaffVo> selectStaffXX() {
        return staffVoMapper.selectStaffXX();
    }

    @Override
    public StaffVo selectStaffId(Long id) {
        return staffVoMapper.selectStaffId(id);
    }

    @Override
    public IPage<StaffVo> selectProbation(Page<StaffVo> page) {
        return staffVoMapper.selectProbation(page);
    }

    @Override
    public IPage<StaffVo> selectStaffHistorical(Page<StaffVo> page) {
        return staffVoMapper.selectStaffHistorical(page);
    }

    @Override
    public List<Map<String, Object>> selectDeptName() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("DEPT_ID","DEPT_NAME");
        queryWrapper.eq("IS_DELETED",0);

        return deptNameMapper.selectMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectDeptPostName() {
        QueryWrapper<DeptPost> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("DEPT_POST_ID","POST_NAME");
        queryWrapper.eq("IS_DELETED",0);

        return deptPostNameMapper.selectMaps(queryWrapper);
    }

}
