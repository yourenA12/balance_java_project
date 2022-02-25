package com.trkj.balance.modules.employee_management.mapper;

import com.trkj.balance.modules.employee_management.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

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


    // 查询本月离职
    @Select("select COUNT(*) from staff where staff_state=1 and IS_DELETED=0 and TO_CHAR(UPDATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM')\n")
    int selectMonthQuit();

    // 查询本月新入职
    @Select("select COUNT(*) from staff where staff_state<>1 and IS_DELETED=0 and TO_CHAR(UPDATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM')\n")
    int selectMonthEntry();

}
