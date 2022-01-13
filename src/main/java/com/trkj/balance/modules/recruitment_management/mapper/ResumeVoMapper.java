package com.trkj.balance.modules.recruitment_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ResumeVoMapper extends BaseMapper<ResumeVo> {
    //全部简历
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "        LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID")
   IPage<ResumeVo> ResumePage(Page<ResumeVo> page);

    //新简历
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
            "where R.RESUME_ZT=0")
    IPage<ResumeVo> ResumePage_a(Page<ResumeVo> page);

    //候选人
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
            "where R.RESUME_ZT=1")
    IPage<ResumeVo> ResumePage_H(Page<ResumeVo> page);

    //已淘汰
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
            "where R.RESUME_ZT=3")
    IPage<ResumeVo> ResumePage_D(Page<ResumeVo> page);

    //已邀约
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
            "where R.RESUME_ZT=2")
    IPage<ResumeVo> ResumePage_Y(Page<ResumeVo> page);

    //面试中
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
            "where R.RESUME_ZT=4")
    IPage<ResumeVo> ResumePage_Z(Page<ResumeVo> page);

 //复试中
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
         "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
         "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
         "where R.RESUME_ZT=6")
    IPage<ResumeVo> ResumePage_F(Page<ResumeVo> page);

    //面试通过
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID " +
            "where R.RESUME_ZT=5")
    IPage<ResumeVo> ResumePage_T(Page<ResumeVo> page);

    //简历详情
    @Select("select  R.*,P.POST_NAME  from RESUME R " +
            "LEFT JOIN RECRUITMENT_PLAN Z ON R.RECRUITMENT_PLAN_ID = Z.RECRUITMENT_PLAN_ID " +
            "LEFT JOIN DEPT_POST P ON Z.DEPT_POST_ID = P.DEPT_POST_ID  where R.RESUME_ID=#{id}")
    ResumeVo SelectRexumeId(@Param("id") Long id);


}
