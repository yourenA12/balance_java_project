package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.Transfer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 调动记录表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
public interface TransferService extends IService<Transfer> {

    //添加调动记录表和修改员工的部门职位
    int insertTransfer(Transfer transfer, Staff staff);

    //查询调动记录
    IPage<Transfer> selectTransfer (Page<Transfer> page,String staffNameSearch,String moveTypeSearch);

    //员工花名册点击编辑里的调动记录查询
    List<Transfer> selectTransferId (Long id);


}
