package com.trkj.balance.modules.salary_management.mapper;

import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 工资未归档表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Mapper
public interface WagenotfiledMapper extends BaseMapper<Wagenotfiled> {

    // 按薪酬组id查询未归档表
    @Select("select * from WAGENOTFILED where COMPENSATION_ID=#{id} and TO_CHAR(CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM')")
    Wagenotfiled selectBydate(int id);

}
