package com.trkj.balance.modules.employee_management.mapper;

import com.trkj.balance.modules.employee_management.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

}
