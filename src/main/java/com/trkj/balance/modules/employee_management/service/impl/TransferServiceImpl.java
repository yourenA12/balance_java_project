package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.Transfer;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.employee_management.mapper.TransferMapper;
import com.trkj.balance.modules.employee_management.service.TransferService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 调动记录表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
@Service
public class TransferServiceImpl extends ServiceImpl<TransferMapper, Transfer> implements TransferService {

    @Autowired
    private TransferMapper transferMapper;

    @Autowired
    private StaffMapper staffMapper;

    //添加调动记录表和修改员工的部门跟职位
    @Override
    @Transactional
    public int insertTransfer(Transfer transfer, Staff staff) {
        if(transferMapper.insert(transfer)>0){
            return staffMapper.updateById(staff);
        }
        return 0;
    }

    //查询调动记录
    @Override
    public IPage<Transfer> selectTransfer(Page<Transfer> page) {
        return transferMapper.selectTransfer(page);
    }

}
