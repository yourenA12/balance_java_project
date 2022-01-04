package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EntryhirdeVoMapper extends BaseMapper<EntryhirdeVo> {
//         @Select(" select e.EMPLOYMENT_ID,e.EMPLOYMENT_STATE,e.RESUME_ID,e.REMARKS,e.hiredate,r.RESUME_ID,r.RESUME_NAME,r.RESUME_SEX,r.RESUME_PHONE,r.RESUME_EDUCATION,r.RESUME_MAILBOX,r.RESUME_PHOTO,r.RESUME_INTRODUCE,r.RESUME_BIRTHDAY,r.RESUME_RESIDENCE,r.RESUME_POLITICAL_OUTLOOK,re.RECRUITMENT_PLAN_ID,re.DEPT_ID,re.DEPT_POST_ID,DEPT_NAME,POST_NAME from EMPLOYMENT_TABLE e  left JOIN RESUME r on e.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN re on r.RECRUITMENT_PLAN_ID=re.RECRUITMENT_PLAN_ID LEFT JOIN dept d on re.DEPT_ID=d.DEPT_ID LEFT JOIN DEPT_POST dp on re.DEPT_POST_ID=dp.DEPT_POST_ID")
         @Select("select * from EMPLOYMENT_TABLE e  left JOIN RESUME r on e.RESUME_ID=r.RESUME_ID LEFT JOIN RECRUITMENT_PLAN re on r.RECRUITMENT_PLAN_ID=re.RECRUITMENT_PLAN_ID LEFT JOIN dept d on re.DEPT_ID=d.DEPT_ID LEFT JOIN DEPT_POST dp on re.DEPT_POST_ID=dp.DEPT_POST_ID LEFT JOIN WORK_EXPERIENCESS w on r.RESUME_ID=w.RESUME_ID LEFT JOIN EDUCATIONSS ed on r.RESUME_ID=ed.RESUME_ID\n" +
                 "where e.EMPLOYMENT_STATE=0")
         IPage<EntryhirdeVo> selectEntryhirde(Page<EntryhirdeVo> page);


}
