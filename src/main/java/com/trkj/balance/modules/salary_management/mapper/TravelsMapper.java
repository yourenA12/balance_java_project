package com.trkj.balance.modules.salary_management.mapper;

import com.trkj.balance.modules.salary_management.entity.Overtimeask;
import com.trkj.balance.modules.salary_management.entity.Travel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 出差表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Mapper
public interface TravelsMapper extends BaseMapper<Travel> {

    // 按员工id查询出差记录
    @Select("select * from TRAVEL where STAFF_ID=#{id} and TO_CHAR(CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM') ")
    List<Travel> selectByTravelStaffId(@Param("id") Long staffId);

}
