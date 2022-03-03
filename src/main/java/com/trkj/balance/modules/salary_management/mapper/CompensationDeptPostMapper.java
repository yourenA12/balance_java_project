package com.trkj.balance.modules.salary_management.mapper;

import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 薪酬组部门职位中间表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Mapper
public interface CompensationDeptPostMapper extends BaseMapper<CompensationDeptPost> {

    // 按薪酬组id查询薪酬组部门职位中间表的部门职位id
    @Select("select DEPT_POST_ID from COMPENSATION_DEPT_POST where COMPENSATION_ID=#{id}")
    List<Integer> selectinsuredDeptPostBydefInsuredId(int id);

}
