package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.entity.Quit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptNameMapper extends BaseMapper<Dept> {


}
