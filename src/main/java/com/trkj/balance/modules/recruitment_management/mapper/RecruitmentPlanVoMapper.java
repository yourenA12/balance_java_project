package com.trkj.balance.modules.recruitment_management.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RecruitmentPlanVoMapper extends BaseMapper<RecruitmentPlanVo> {

    @Select("SELECT * from RECRUITMENT_PLAN rp\n" +
            "\tleft join DEPT d on rp.DEPT_ID=d.DEPT_ID \n" +
            "  left join DEPT_POST p on rp.DEPT_POST_ID=p.DEPT_POST_ID \n" +
            "  LEFT JOIN STAFF s on rp.STAFF_ID=s.STAFF_ID\n")
    IPage<RecruitmentPlanVo> queryPage(Page<RecruitmentPlanVo> page);


}
