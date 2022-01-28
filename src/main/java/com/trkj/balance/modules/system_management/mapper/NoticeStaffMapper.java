package com.trkj.balance.modules.system_management.mapper;

import com.trkj.balance.modules.system_management.entity.NoticeStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公告员工表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-01-07
 */
@Mapper
public interface NoticeStaffMapper extends BaseMapper<NoticeStaff> {

    // 按公告id 删除公告员工表的数据
    @Delete("DELETE FROM NOTICE_STAFF WHERE NOTICE_ID = #{NOTICE_ID}")
    int deleteNoticeStaff(@Param("NOTICE_ID") Long noticeId);

    @Select("select a.NOTICE_STATE,b.STAFF_NAME from NOTICE_STAFF a \n" +
            "LEFT JOIN STAFF b on a.STAFF_ID=b.STAFF_ID\n" +
            "where a.NOTICE_ID=#{NOTICE_ID} " +
            "and a.STAFF_ID<>#{STAFF_ID}")
    List<Map<Object, Object>> selectNoticeStaffByNoticeId(@Param("NOTICE_ID") Long noticeId,@Param("STAFF_ID") Long staffId);

}
