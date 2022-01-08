package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EntryhirdeVoMapper extends BaseMapper<EntryhirdeVo> {
        //查询待入职员工
         @Select("select * from EMPLOYMENT_TABLE et right JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp on r.RECRUITMENT_PLAN_ID=rp.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on rp.DEPT_ID=d.DEPT_ID LEFT JOIN DEPT_POST dp on rp.DEPT_POST_ID=dp.DEPT_POST_ID LEFT JOIN WORK_EXPERIENCESS we on r.RESUME_ID=we.RESUME_ID LEFT JOIN EDUCATIONSS e on r.RESUME_ID=e.RESUME_ID where r.RESUME_ZT=8")
         IPage<EntryhirdeVo> selectEntryhirde(Page<EntryhirdeVo> page);

         //查询放弃入职员工
        @Select("select * from EMPLOYMENT_TABLE et right JOIN RESUME r on et.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN rp on r.RECRUITMENT_PLAN_ID=rp.RECRUITMENT_PLAN_ID LEFT JOIN DEPT d on rp.DEPT_ID=d.DEPT_ID LEFT JOIN DEPT_POST dp on rp.DEPT_POST_ID=dp.DEPT_POST_ID LEFT JOIN WORK_EXPERIENCESS we on r.RESUME_ID=we.RESUME_ID LEFT JOIN EDUCATIONSS e on r.RESUME_ID=e.RESUME_ID where r.RESUME_ZT=10")
        IPage<EntryhirdeVo> selectEntryhirdeFQ(Page<EntryhirdeVo> page);

}
