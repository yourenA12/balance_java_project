package com.trkj.balance.modules.salary_management.mapper;

import com.trkj.balance.modules.salary_management.entity.Overtimeask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 加班表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Mapper
public interface OvertimeasksMapper extends BaseMapper<Overtimeask> {

    // 按员工id查询加班记录
    @Select("select * from OVERTIMEASK where STAFF_ID=#{id} and TO_CHAR(CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM') ")
    List<Overtimeask> selectByStaffId(@Param("id") Long staffId);

}
