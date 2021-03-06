package com.trkj.balance.modules.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.salary_management.entity.DeptPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门职位中间表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Mapper
public interface DeptPostMapper extends BaseMapper<DeptPost> {

    @Select("SELECT DEPT_POST_ID FROM DEPT_POST WHERE DEPT_ID=#{deptId} and POSITION_ID=#{positionId}")
    Long selectDeptPost(@Param("deptId") int deptId,@Param("positionId") int positionId);


    @Select("SELECT DISTINCT DEPT_ID FROM DEPT_POST ${ew.customSqlSegment}")
    List<Integer> selectDeptId(@Param(Constants.WRAPPER) QueryWrapper<DeptPost> wrapper);

    @Select("SELECT DISTINCT POSITION_ID FROM DEPT_POST ${ew.customSqlSegment}")
    List<Integer> selectPostId(@Param(Constants.WRAPPER) QueryWrapper<DeptPost> wrapper);

}
