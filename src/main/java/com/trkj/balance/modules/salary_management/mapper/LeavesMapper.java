package com.trkj.balance.modules.salary_management.mapper;

import com.trkj.balance.modules.salary_management.entity.Leave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 请假表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Mapper
public interface LeavesMapper extends BaseMapper<Leave> {

    // 按员工id查询请假记录
    @Select("select * from LEAVE where STAFF_ID=#{id} and TO_CHAR(CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM') ")
    List<Leave> selectByLeaveStaffId(@Param("id") Long staffId);

}
