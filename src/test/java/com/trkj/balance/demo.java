package com.trkj.balance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.employee_management.mapper.DeptNameMapper;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

public class demo {

    @Autowired
    private DeptNameMapper deptMapper;


    @Test
    public void test1(){

        QueryWrapper wrapper = new QueryWrapper();

        wrapper.select("DEPT_NAME","SUPERIOR_DEPT_ID").eq("DEPT_ID",5);

        List<Map> depts = deptMapper.selectMaps(wrapper);

        System.out.println(depts.toString());

    }


}
