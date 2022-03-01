package com.trkj.balance.modules.recruitment_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.recruitment_management.entity.EmploymentTable;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;
import com.trkj.balance.modules.recruitment_management.service.EmploymentTableService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 录用表 前端控制器
 * </p>
 *
 * @author 米西米西
 * @since 2022-03-01
 */
@Slf4j
@RestController
@RequestMapping("/employmentTable")
public class EmploymentTableController {
    @Autowired
    private EmploymentTableService employmentTableService;
    //录用
       @PostMapping("/insertEmploymentTable")
    public AjaxResponse insertEmployment(@RequestBody Map<Object, Object> map){

           Resume resume = JSON.parseObject(JSON.toJSONString(map.get("Resume")), Resume.class); // 取map中的 员工表数据 转换为实体类
           EmploymentTable employmentTable = JSON.parseObject(JSON.toJSONString(map.get("EmploymentTable")), EmploymentTable.class);
           log.debug(resume.toString());
           log.debug(employmentTable.toString());
           return AjaxResponse.success(employmentTableService.insertEmploymentTable(employmentTable,resume));
    }

}

