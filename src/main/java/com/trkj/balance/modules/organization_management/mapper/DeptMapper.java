package com.trkj.balance.modules.organization_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.organization_management.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2022-01-10
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    @Select("select a.DEPT_ID,a.SUPERIOR_DEPT_ID,a.DEPT_STATE,a.DEPT_NAME,b.STAFF_NAME\n" +
            "from\n" +
            "DEPT a\n" +
            "left join\n" +
            "STAFF b\n" +
            "on a.STAFF_ID=b.STAFF_ID")
    List<Dept> queryList();


}
