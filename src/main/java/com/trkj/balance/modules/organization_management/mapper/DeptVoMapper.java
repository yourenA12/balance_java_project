package com.trkj.balance.modules.organization_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.vo.DeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptVoMapper extends BaseMapper<DeptVo> {

    // 分页查询所有部门
    @Select("select b.CREATED_TIME,b.dept_id,b.DEPT_STATE,b.DEPT_NAME,b.staff_id,a.staff_name\n" +
            "from\n" +
            "staff a\n" +
            "right join\n" +
            "dept b\n" +
            "on a.staff_id= b.staff_id" +
            " where b.is_deleted=0")
    IPage<DeptVo> selectDeptVo(Page<DeptVo> page);

    // 统计每个部门的人数
    @Select("select dept_id,count(dept_id) numbers from staff where is_deleted=0 GROUP BY dept_id")
    List<Map<Long, Long>> selectDeptNum();




}
