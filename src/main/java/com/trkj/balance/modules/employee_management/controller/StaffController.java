package com.trkj.balance.modules.employee_management.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.*;

import com.trkj.balance.modules.employee_management.service.StaffService;
import com.trkj.balance.modules.employee_management.service.StaffVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON; // Map 转实体类

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@Slf4j
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffVoService staffVoService;

    //添加员工表
    @PostMapping("/insertStaff")
    private AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {

        Staff staff = JSON.parseObject(JSON.toJSONString(map.get("Staff")), Staff.class); // 取map中的 员工表数据 转换为实体类
        WorkExperience workExperience = JSON.parseObject(JSON.toJSONString(map.get("Work")), WorkExperience.class);
        Education education = JSON.parseObject(JSON.toJSONString(map.get("Education")), Education.class);
        Resume resume = JSON.parseObject(JSON.toJSONString(map.get("Resume")), Resume.class);
        Fixedwage fixedwage = JSON.parseObject(JSON.toJSONString(map.get("Fixedwage")), Fixedwage.class);

        //调用入职方法，
        return AjaxResponse.success(staffService.insertStaff(staff,workExperience,education,resume,fixedwage));
    }


    //修改简历状态和录用原因
    @PutMapping("/updateResume")
    public AjaxResponse updateResume(@RequestBody Map<Object, Object> map) {
        Resume resume = JSON.parseObject(JSON.toJSONString(map.get("Resume")), Resume.class);
        EmploymentTable employmentTable = JSON.parseObject(JSON.toJSONString(map.get("EmploymentTable")), EmploymentTable.class);
        log.debug("resume:123456"+resume.toString());
        log.debug("employmentTable:fdfftgg"+employmentTable.toString());
        return AjaxResponse.success(staffService.updateResumen(resume,employmentTable));
    }

    //查询员工信息
    @GetMapping("/selectStaffVo")
    public AjaxResponse selectStaffVo(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                      @RequestParam("staffNameSearch") String staffNameSearch,
                                      @RequestParam("deptIds") ArrayList deptIds,
                                      @RequestParam("stateSearch") String stateSearch,
                                      @RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                      @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd){



        Page<StaffVo> page = new Page<>(currenPage,pagesize);
        IPage<StaffVo> list=staffVoService.selectStaffVo(page,staffNameSearch,deptIds,stateSearch,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(list);
    }

    //查询员工的名称、部门、职位
    @GetMapping("/selectStaffXX")
    public AjaxResponse selectStaffXX(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                      @RequestParam("deptIds") ArrayList deptIds  ){

        Page<StaffVo> page = new Page<>(currenPage,pagesize);
        IPage<StaffVo> list=staffVoService.selectStaffXX(page,deptIds);
        return AjaxResponse.success(list);
    }

    //根据id查询
    @GetMapping("/selectStaffId/{id}")
    public AjaxResponse selectStaffId(@PathVariable("id") Long id){
        StaffVo staff=staffVoService.selectStaffId(id);
        return AjaxResponse.success(staff);
    }

    //转正管理 查询试用期信息
    @GetMapping("/selectProbation")
    public AjaxResponse selectProbation(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                        @RequestParam("staffNameSearch") String staffNameSearch,
                                        @RequestParam("deptIds") ArrayList deptIds,
                                        @RequestParam("postSearch") String postSearch,
                                        @RequestParam("stateSearch") Object day,
                                        @RequestParam("clockTimeStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeStart,
                                        @RequestParam("clockTimeEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date clockTimeEnd){

        Page<StaffVo> page = new Page<>(currenPage,pagesize);
        IPage<StaffVo> list=staffVoService.selectProbation(page,staffNameSearch,deptIds,postSearch,day,clockTimeStart,clockTimeEnd);
        return AjaxResponse.success(list);
    }

    //历史花名册 查询状态为离职的员工
    @GetMapping("/selectHistorical")
    public AjaxResponse selectHistorical(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                         @RequestParam("staffNameSearch") String staffNameSearch,
                                         @RequestParam("deptIds") ArrayList deptIds,
                                         @RequestParam("postSearch") String postSearch){

        Page<StaffVo> page = new Page<>(currenPage,pagesize);
        IPage<StaffVo> list=staffVoService.selectStaffHistorical(page,staffNameSearch,deptIds,postSearch);
        return AjaxResponse.success(list);
    }

    //查询部门名称
    @GetMapping("/selectDeptName")
    public AjaxResponse selectDeptName(){
        List<Map<String, Object>> list=staffVoService.selectDeptName();
        return AjaxResponse.success(list);
    }

    //查询职位名称
    @GetMapping("/selectPositionName")
    public AjaxResponse selectPositionName(){
        List<Map<String, Object>> list=staffVoService.selectPositionName();
        return AjaxResponse.success(list);
    }

    //修改员工
    @PutMapping("/updateStaff")
    public AjaxResponse updateStaff(@RequestBody Staff staff){
        return AjaxResponse.success(staffService.updateStaff(staff));
    }

    //统计离职、在职、试用的员工人数
    @GetMapping("/selectCountStaff/{state}")
    public AjaxResponse selectCountStaff(@PathVariable("state") String state){

        return AjaxResponse.success(staffService.selectCountStaff(state));
    }

    //查询员工密码
    @PostMapping("/selectStaffId/{id}/{pass}")
    public AjaxResponse selectStaffId(@PathVariable("id") Long id,@PathVariable("pass") String pass){
        Staff staff=staffService.selectStaffAccountPass(id,pass);
        return AjaxResponse.success(staff);
    }

}



