package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.entity.DeptPost;
import com.trkj.balance.modules.employee_management.entity.Position;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.*;
import com.trkj.balance.modules.employee_management.service.StaffVoService;
import com.trkj.balance.modules.employee_management.vo.StaffVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
   //职位名称
    private PositionMapper positionMapper;


    @Override
    public IPage<StaffVo> selectStaffVo(Page<StaffVo> page, String staffNameSearch, ArrayList deptIds, String stateSearch, Date clockTimeStart, Date clockTimeEnd) {

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

        if(stateSearch!="" && stateSearch!=null){
            // 按员工状态
            wrapper.eq("s.STAFF_STATE",stateSearch);
        }

        if(clockTimeStart+"" !="" &&  clockTimeEnd+"" !="" && clockTimeStart !=null &&  clockTimeEnd !=null){
            // 按入职时间段进行查询
            wrapper.between("s.STAFF_HIREDATE",clockTimeStart,clockTimeEnd);
        }

        // 员工当前状态不为离职
        wrapper.ne("s.STAFF_STATE",1);

        IPage<StaffVo> list=staffVoMapper.selectStaffVo(page,wrapper);

        for (StaffVo staffVo : list.getRecords()) {

            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            // 放入 入职日期 与 当前日期
            Period period = Period.between( LocalDate.parse( df.format(staffVo.getStaffHiredate()) ),
                    LocalDate.parse( df.format(new Date()) ));
            // 将 计算好的工龄 放入 vo 视图中
            staffVo.setStaffWorkingYears( period.getYears()+"年"+period.getMonths()+"月"+period.getDays()+"日" );

            log.debug("1111111111111111");
            log.debug(staffVo.getStaffWorkingYears());

//            //往数据库做修改
//            Staff staff=new Staff();
//            //取当前循环的员工id
//            staff.setStaffId(staffVo.getStaffId());
//            //取当前循环员工的工龄
//            staff.setStaffWorkingYears(staffVo.getStaffWorkingYears());
//            staffMapper.updateById(staff);

        }
        return list;
    }

    @Override
    public IPage<StaffVo> selectStaffXX(IPage<StaffVo> page,ArrayList deptIds) {
        // 声明一个条件构造器
        QueryWrapper<StaffVo> wrapper = new QueryWrapper<>();


        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }

        // 员工当前状态为试用期
        wrapper.ne("s.STAFF_STATE", 1);

        return staffVoMapper.selectStaffXX(page,wrapper);
    }

    @Override
    public StaffVo selectStaffId(Long id) {
        return staffVoMapper.selectStaffId(id);
    }

    //转正管理 查询未转正的员工
    @Override
    public IPage<StaffVo> selectProbation(Page<StaffVo> page,String staffNameSearch, ArrayList deptIds,String postSearch,Object day,Date clockTimeStart, Date clockTimeEnd) {
        // 声明一个条件构造器
        QueryWrapper<StaffVo> wrapper = new QueryWrapper<>();

        if (staffNameSearch != "" && staffNameSearch != null) {
            // 按员工名称进行模糊查询
            wrapper.like("s.STAFF_NAME", staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }
        if (postSearch != "" && postSearch != null) {
            // 按职位id查询
            wrapper.eq("p.POSITION_ID", postSearch);
        }
        if(clockTimeStart+"" !="" &&  clockTimeEnd+"" !="" && clockTimeStart !=null &&  clockTimeEnd !=null){
            // 按入职时间段进行查询
            wrapper.between("s.STAFF_HIREDATE",clockTimeStart,clockTimeEnd);
        }

        // 员工当前状态为试用期
        wrapper.eq("s.STAFF_STATE", 2);

        if(day=="" || day==null){
            return staffVoMapper.selectProbation(page,wrapper);
        }

        return staffVoMapper.selectProbation1(page,wrapper,day);

    }
    //历史花名册  分页查询状态为离职的员工
    @Override
    public IPage<StaffVo> selectStaffHistorical(Page<StaffVo> page,String staffNameSearch,ArrayList deptIds,String postSearch) {
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
        wrapper.eq("s.STAFF_STATE",1);


        wrapper.eq("q.IS_DELETED",0);
        return staffVoMapper.selectStaffHistorical(page,wrapper);
    }

    @Override
    public List<Map<String, Object>> selectDeptName() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("DEPT_ID","DEPT_NAME");
        queryWrapper.eq("IS_DELETED",0);

        return deptNameMapper.selectMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>>selectPositionName() {
        QueryWrapper<Position> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("POSITION_ID","POSITION_NAME");
        queryWrapper.eq("IS_DELETED",0);

        return positionMapper.selectMaps(queryWrapper);
    }

}
