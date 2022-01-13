package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Transfer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("select s.STAFF_NAME,t.*,d.DEPT_ID,d.DEPT_NAME,dp.DEPT_POST_ID,dp.POST_NAME,\n" +
            "d2.DEPT_ID as DEPT_ID2,d2.DEPT_NAME as DEPT_NAME2,dp2.DEPT_POST_ID as DEPT_POST_ID2,dp2.POST_NAME as POST_NAME2\n" +
            "from TRANSFER t\n" +
            "RIGHT JOIN staff s on s.STAFF_ID=t.STAFF_ID \n" +
            "LEFT JOIN dept d on t.CREATED_DEPT_ID=d.DEPT_ID\n" +
            "LEFT JOIN DEPT_POST dp on t.transfer_rawpost_ID=dp.DEPT_POST_ID\n" +
            "LEFT JOIN dept d2 on t.UPDATED_DEPT_ID=d2.DEPT_ID\n" +
            "LEFT JOIN DEPT_POST dp2 on t.TRANSFER_AFTERPOST_ID=dp2.DEPT_POST_ID where t.IS_DELETED=0")
     IPage<Transfer> selectTransfer (Page<Transfer> page);
}
