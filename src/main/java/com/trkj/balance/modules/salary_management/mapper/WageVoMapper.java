package com.trkj.balance.modules.salary_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.salary_management.Vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.Salary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WageVoMapper extends BaseMapper<WagVo> {
}
