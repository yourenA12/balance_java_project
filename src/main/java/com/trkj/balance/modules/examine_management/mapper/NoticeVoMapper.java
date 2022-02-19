package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import com.trkj.balance.modules.system_management.entity.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface NoticeVoMapper extends BaseMapper<NoticeVo> {
    @Select("select N.*,\n" +
            "S.NOTICE_STAFF_ID,S.NOTICE_STATE as noticeState1,\n" +
            "S.STAFF_ID as staffId1 \n" +
            "from NOTICE N \n" +
            "LEFT JOIN NOTICE_STAFF S \n" +
            "on N.NOTICE_ID = S.NOTICE_ID ${ew.customSqlSegment}")
    IPage<NoticeVo> findNoticeVo(Page<NoticeVo> page, @Param(Constants.WRAPPER) QueryWrapper<NoticeVo> wrapper);
}
