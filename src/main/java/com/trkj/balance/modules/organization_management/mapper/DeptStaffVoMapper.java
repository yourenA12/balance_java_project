package com.trkj.balance.modules.organization_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.vo.DeptStaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptStaffVoMapper extends BaseMapper<DeptStaffVo> {

    //查询部门负责人的信息
    @Select("select a.STAFF_ID,a.STAFF_NAME,a.STAFF_EDUCATION,b.POST_NAME\n" +
            "from\n" +
            "staff a\n" +
            "left join\n" +
            "DEPT_POST b\n" +
            "on a.DEPT_POST_ID= b.DEPT_POST_ID")
    IPage<DeptStaffVo> selectDeptygVo(Page<DeptStaffVo> page);


}
