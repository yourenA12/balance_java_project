package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Transfer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 调动记录表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
@Mapper
public interface TransferMapper extends BaseMapper<Transfer> {

    @Select("select s.STAFF_NAME,t.*,d.DEPT_ID,d.DEPT_NAME,p.POSITION_ID,p.POSITION_NAME, d2.DEPT_ID as DEPT_ID2,d2.DEPT_NAME as DEPT_NAME2,p2.POSITION_ID as POSITION_ID2,p2.POSITION_NAME as POSITION_NAME2 from TRANSFER t RIGHT JOIN staff s on s.STAFF_ID=t.STAFF_ID LEFT JOIN dept d on t.CREATED_DEPT_ID=d.DEPT_ID LEFT JOIN POSITION p on t.transfer_rawpost_ID=p.POSITION_ID LEFT JOIN dept d2 on t.UPDATED_DEPT_ID=d2.DEPT_ID LEFT JOIN POSITION p2 on t.TRANSFER_AFTERPOST_ID=p2.POSITION_ID ${ew.customSqlSegment}")
     IPage<Transfer> selectTransfer (Page<Transfer> page,@Param(Constants.WRAPPER) QueryWrapper<Transfer> wrapper);

    //员工花名册点击编辑里的调动记录查询
    @Select("select s.STAFF_NAME,t.*,d.DEPT_ID,d.DEPT_NAME,p.POSITION_ID,p.POSITION_NAME, d2.DEPT_ID as DEPT_ID2,d2.DEPT_NAME as DEPT_NAME2,p2.POSITION_ID as POSITION_ID2,p2.POSITION_NAME as POSITION_NAME2 from TRANSFER t RIGHT JOIN staff s on s.STAFF_ID=t.STAFF_ID LEFT JOIN dept d on t.CREATED_DEPT_ID=d.DEPT_ID LEFT JOIN POSITION p on t.transfer_rawpost_ID=p.POSITION_ID LEFT JOIN dept d2 on t.UPDATED_DEPT_ID=d2.DEPT_ID LEFT JOIN POSITION p2 on t.TRANSFER_AFTERPOST_ID=p2.POSITION_ID where t.IS_DELETED=0 and s.STAFF_ID=#{id}")
    List<Transfer> selectTransferId (Long id);


}
