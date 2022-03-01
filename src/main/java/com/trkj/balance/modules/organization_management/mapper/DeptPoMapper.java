package com.trkj.balance.modules.organization_management.mapper;

import com.trkj.balance.modules.organization_management.entity.DeptPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 部门职位中间表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2022-03-01
 */
@Mapper
public interface DeptPoMapper extends BaseMapper<DeptPost> {

}
