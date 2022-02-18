package com.trkj.balance.modules.employee_management.service.impl;

import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.Worker;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.employee_management.mapper.Worker_StaffMapper;
import com.trkj.balance.modules.employee_management.service.Worker_StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 转正 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
@Service
public class Worker_StaffServiceImpl extends ServiceImpl<Worker_StaffMapper, Worker> implements Worker_StaffService {

    @Autowired
    private Worker_StaffMapper worker_staffMapper;

    @Autowired
    private StaffMapper staffMapper;

    //添加转正表和修改员工表的转正日期、员工状态
    @Override
    @Transactional
    public int insertWorker(Worker worker, Staff staff) {
        if(worker_staffMapper.insert(worker)>0){
           return staffMapper.updateById(staff);
        }
        return 0;
    }
}
