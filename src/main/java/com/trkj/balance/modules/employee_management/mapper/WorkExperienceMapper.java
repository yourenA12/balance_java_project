package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 工作经历表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2021-12-31
 */
@Mapper
public interface WorkExperienceMapper extends BaseMapper<WorkExperience> {

    @Select("select * from WORK_EXPERIENCE w left join staff s on w.staff_id=s.staff_id")
    IPage<WorkExperience> selectWorkExperience (IPage<WorkExperience> page);
}
