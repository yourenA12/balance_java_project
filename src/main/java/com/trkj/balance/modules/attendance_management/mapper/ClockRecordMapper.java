package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.attendance_management.entity.ClockRecord;
import com.trkj.balance.modules.attendance_management.vo.ClockVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 打卡记录表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2022-01-06
 */
@Mapper
public interface ClockRecordMapper extends BaseMapper<ClockRecord> {

    @Select("SELECT * FROM CLOCK_RECORD  WHERE IS_DELETED=0  AND STAFF_ID = #{id} AND TO_CHAR(CREATED_TIME,'yyyy-MM-dd') = TO_CHAR(sysdate,'yyyy-MM-dd')")
    ClockRecord selectBydate(Long id);

}
