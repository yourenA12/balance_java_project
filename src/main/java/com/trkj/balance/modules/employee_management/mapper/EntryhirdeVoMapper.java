package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EntryhirdeVoMapper extends BaseMapper<EntryhirdeVo> {
        //查询待入职员工
         @Select("select * from EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID\n" +
                 "                LEFT JOIN RECRUITMENT_PLAN rp on r.RECRUITMENT_PLAN_ID=rp.RECRUITMENT_PLAN_ID\n" +
                 "                 LEFT JOIN DEPT d on rp.DEPT_ID=d.DEPT_ID\n" +
                 "                  LEFT JOIN POSITION p on rp.POSITION_ID=p.POSITION_ID\n" +
                 "                 LEFT JOIN WORK_EXPERIENCESS we on r.RESUME_ID=we.RESUME_ID\n" +
                 "                  LEFT JOIN EDUCATIONSS e on r.RESUME_ID=e.RESUME_ID ")
         IPage<EntryhirdeVo> selectEntryhirde(Page<EntryhirdeVo> page,@Param(Constants.WRAPPER) QueryWrapper<EntryhirdeVo> wrapper);

         //查询放弃入职员工
        @Select("select * from EMPLOYMENT_TABLE et LEFT JOIN RESUME r on et.RESUME_ID=r.RESUME_ID\n" +
                "                LEFT JOIN RECRUITMENT_PLAN rp on r.RECRUITMENT_PLAN_ID=rp.RECRUITMENT_PLAN_ID\n" +
                "                 LEFT JOIN DEPT d on rp.DEPT_ID=d.DEPT_ID\n" +
                "                  LEFT JOIN POSITION p on rp.POSITION_ID=p.POSITION_ID\n" +
                "                 LEFT JOIN WORK_EXPERIENCESS we on r.RESUME_ID=we.RESUME_ID\n" +
                "                  LEFT JOIN EDUCATIONSS e on r.RESUME_ID=e.RESUME_ID ${ew.customSqlSegment}")
        IPage<EntryhirdeVo> selectEntryhirdeFQ(Page<EntryhirdeVo> page,@Param(Constants.WRAPPER) QueryWrapper<EntryhirdeVo> wrapper);

}
