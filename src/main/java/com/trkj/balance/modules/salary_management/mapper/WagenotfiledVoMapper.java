package com.trkj.balance.modules.salary_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WagenotfiledVoMapper extends BaseMapper<WagenotfiledVo> {

    //查询工资未归档
    @Select("select * from COMPENSATION c LEFT JOIN WAGENOTFILED w on c.COMPENSATION_ID=w.COMPENSATION_ID " +
            "where w.WAGENOTFILED_STATE=0 and TO_CHAR(w.CREATED_TIME,'yyyy-MM') = TO_CHAR(sysdate,'yyyy-MM')")
    IPage<WagenotfiledVo> selectWagenotfiledVoPage(IPage<WagenotfiledVo> page);
}
