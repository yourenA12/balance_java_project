package com.trkj.balance.modules.system_management.mapper;

import com.trkj.balance.modules.system_management.entity.Dept;
import com.trkj.balance.modules.system_management.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 公告表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-01-05
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

}
