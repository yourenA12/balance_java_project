package com.trkj.balance.modules.salary_management.mapper;

import com.trkj.balance.modules.salary_management.entity.Archive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 月报表归档表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Mapper
public interface ArchiveaMapper extends BaseMapper<Archive> {

    // 按员工id查询考勤归档记录
    @Select("select * from ARCHIVE where STAFF_ID=#{id} and TO_CHAR(CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM') ")
    Archive selectByArchiveStaffId(@Param("id") Long staffId);

}
