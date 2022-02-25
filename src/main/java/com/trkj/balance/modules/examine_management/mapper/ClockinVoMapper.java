package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.examine_management.vo.ClockinVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//打卡
@Mapper
public interface ClockinVoMapper extends BaseMapper<ClockinVo> {
    @Select("select * from CLOCK_RECORD a left join STAFF b  on a.STAFF_ID=b.STAFF_ID\n" +
            "where b.STAFF_ID = #{id} \n" +
            "and TO_CHAR(a.CREATED_TIME,'yyyy-MM-dd')=TO_CHAR(sysdate,'yyyy-MM-dd')")

    ClockinVo daka(Long id);
}
