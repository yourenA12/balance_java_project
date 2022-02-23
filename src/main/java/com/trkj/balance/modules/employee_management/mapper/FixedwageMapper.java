package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 固定工资表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-01-25
 */
@Mapper
public interface FixedwageMapper extends BaseMapper<Fixedwage> {

    @Select("select * from STAFF s LEFT JOIN FIXEDWAGE f on s.STAFF_ID=f.STAFF_ID LEFT JOIN dept d on s.DEPT_ID=d.DEPT_ID LEFT JOIN POSITION p on s.POSITION_ID=p.POSITION_ID where s.STAFF_STATE!=1")
    IPage<Fixedwage> selectFixedwagePage(IPage<Fixedwage> page);
}
