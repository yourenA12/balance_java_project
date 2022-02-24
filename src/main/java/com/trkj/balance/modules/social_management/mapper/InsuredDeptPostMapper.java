package com.trkj.balance.modules.social_management.mapper;

import com.trkj.balance.modules.social_management.entity.DefScheme;
import com.trkj.balance.modules.social_management.entity.InsuredDeptPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 参保方案部门职位中间表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
@Mapper
public interface InsuredDeptPostMapper extends BaseMapper<InsuredDeptPost> {

    @Select("select DEPT_POST_ID from INSURED_DEPT_POST from DEF_SCHEME where DEF_INSURED_ID=#{id}")
    List<Integer> selectinsuredDeptPostBydefInsuredId(Long id);

}
