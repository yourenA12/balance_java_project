package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.vo.StaffVo;

import com.trkj.balance.vo.AjaxResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface StaffVoService extends IService<StaffVo> {
    //分页查询员工信息
    IPage<StaffVo> selectStaffVo (Page<StaffVo> page, String staffNameSearch, ArrayList deptIds, String stateSearch, Date clockTimeStart, Date clockTimeEnd);
    //查询员工的姓名、职位、部门
    IPage<StaffVo> selectStaffXX(IPage<StaffVo> page,ArrayList deptIds);

    //根据id查询员工信息
    StaffVo selectStaffId(Long id);

    //转正管理 查询试用期人员
    IPage<StaffVo> selectProbation (Page<StaffVo> page,String staffNameSearch, ArrayList deptIds,String postSearch,Object day,Date clockTimeStart, Date clockTimeEnd);

    //历史花名册 查询状态为离职的员工
    IPage<StaffVo> selectStaffHistorical (Page<StaffVo> page,String staffNameSearch, ArrayList deptIds,String postSearch);

    //查询部门名称
    List<Map<String, Object>> selectDeptName();

    //查询部门职位名称
    List<Map<String, Object>> selectPositionName();

    //查询员工状态


}
