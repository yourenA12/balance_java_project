package com.trkj.balance.modules.login.mapper;

import com.trkj.balance.modules.login.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-03-02
 */
@Mapper
public interface UserMapper extends BaseMapper<Staff> {

}
