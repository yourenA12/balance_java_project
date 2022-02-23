package com.trkj.balance.modules.salary_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.salary_management.entity.Salary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 调薪表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-02-21
 */
@Mapper
public interface SalaryFixedMapper extends BaseMapper<Salary> {

    //查询调薪记录
    @Select("select * from SALARY s LEFT JOIN  STAFF st on s.STAFF_ID=st.STAFF_ID\n" +
            "LEFT JOIN dept d on st.DEPT_ID=d.DEPT_ID ORDER BY s.UPDATED_TIME desc")
    IPage<Salary> selectSalaryPage(IPage<Salary> page);

}
