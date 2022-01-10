package com.trkj.balance.modules.attendance_management.mapper;

import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 班次方案表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2021-12-30
 */
@Mapper
public interface ClassesMapper extends BaseMapper<Classes> {

    @Select("update CLASSES set CLASSES_STATE=1")
    Object updateAllState();

}
