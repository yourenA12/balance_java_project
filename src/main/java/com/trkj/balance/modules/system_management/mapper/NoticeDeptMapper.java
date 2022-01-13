package com.trkj.balance.modules.system_management.mapper;

import com.trkj.balance.modules.system_management.entity.NoticeDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 公告部门表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-01-07
 */
@Mapper
public interface NoticeDeptMapper extends BaseMapper<NoticeDept> {
    
    // 按公告id 删除公告部门表的数据
    @Delete("DELETE FROM NOTICE_DEPT WHERE NOTICE_ID = #{NOTICE_ID}")
    int deleteNoticeDept(@Param("NOTICE_ID") Long noticeId);

}
