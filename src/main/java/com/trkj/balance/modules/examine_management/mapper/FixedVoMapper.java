package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.FixedVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FixedVoMapper extends BaseMapper<FixedVo> {
        //根据员工id查询员工 的薪资 与 部门
        @Select("SELECT * FROM STAFF A\n" +
                "LEFT JOIN DEPT B ON A.DEPT_ID = B.DEPT_ID\n" +
                "LEFT JOIN FIXEDWAGE C ON A.STAFF_id = C.STAFF_ID\n" +
                "WHERE A.STAFF_ID = #{id}")
        List<FixedVo> findSelectByidFix(@Param("id") Long id);
}
