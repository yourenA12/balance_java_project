package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GloryPunishVoMapper extends BaseMapper<GloryPunishVo> {
    @Select("select * from  GLORY g LEFT JOIN  STAFF s  on g.STAFF_ID=s.STAFF_ID\n" +
            "LEFT JOIN PUNISH p on s.STAFF_ID=p.STAFF_ID")
    IPage<GloryPunishVo> selectGloryPunish (IPage<GloryPunishVo> page);
}
