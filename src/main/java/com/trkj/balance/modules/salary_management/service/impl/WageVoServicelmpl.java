package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.Vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.*;
import com.trkj.balance.modules.salary_management.mapper.*;
import com.trkj.balance.modules.salary_management.service.WageVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WageVoServicelmpl extends ServiceImpl<WageVoMapper, WagVo> implements WageVoService {
    //工资表
    @Autowired
    private WageVoMapper wageVoMapper;

    //薪酬组
    @Autowired
    private CompensationMapper compensationMapper;

    //薪酬组员工中间表
    @Autowired
    private CompensationStaffMapper compensationStaffMapper;

    //加班方案
    @Autowired
    private WorkschemeMapper workschemeMapper;

    //考勤扣款方案
    @Autowired
    private AttendandceMapper attendandceMapper;

    //出差方案
    @Autowired
    private BusinessMapper businessMapper;

    // 加班
    @Autowired
    private OvertimeasksMapper overtimeasksMapper;

    // 出差
    @Autowired
    private TravelsMapper travelsMapper;

    // 请假
    @Autowired
    private LeavesMapper leavesMapper;

    // 考勤归档
    @Autowired
    private ArchiveaMapper archiveaMapper;

    //查询工资
    @Override
    public IPage<WagVo> selectWagVo(IPage<WagVo> page, int compensationId) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("COMPENSATION_ID", compensationId);
        //按薪酬组id查询薪酬组里面的员工
        List<CompensationStaff> compensationStaffs = compensationStaffMapper.selectList(wrapper);

        //声明一个员工id
        List<Integer> staffIds = new ArrayList<>();
        for (CompensationStaff compensationStaff : compensationStaffs) {
            // 将员工id循环添加到List中
            staffIds.add(Math.toIntExact(compensationStaff.getStaffId()));

        }

        //如果staffIds为0,直接返回null
        if (staffIds.size() == 0) return null;

        //根据员工id查询全部的员工
        QueryWrapper wrapper1 = new QueryWrapper<>();
        wrapper1.in("c.STAFF_ID", staffIds);
        IPage<WagVo> wagVos = wageVoMapper.selectWagVo(page, wrapper1);

        //根据薪酬组id查询 （加班方案id，扣款方案id，出差方案id）
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.eq("COMPENSATION_ID", compensationId);
        Compensation compensation = compensationMapper.selectOne(wrapper2);

        // 查询加班方案 （节假日加班比例，休息日加班比例，工作日加班比例）
        QueryWrapper wrapper3 = new QueryWrapper();
        wrapper3.eq("WORKSCHEME_ID", compensation.getWorkschemeId());
        Workscheme workscheme = workschemeMapper.selectOne(wrapper3);

        //-- 考勤扣款方案（迟到一次金额，早退一次金额，旷工一天金额）
        QueryWrapper wrapper4 = new QueryWrapper();
        wrapper4.eq("ATTENDANDCE_ID", compensation.getAttendandceId());
        Attendandce attendandce = attendandceMapper.selectOne(wrapper4);

        //查询出差方案（出差一天金额）
        QueryWrapper wrapper5 = new QueryWrapper();
        wrapper5.eq("BUSINESS_ID", compensation.getBusinessId());
        Business business = businessMapper.selectOne(wrapper5);

        // 循环员工
        for (WagVo record : wagVos.getRecords()) {

            // 按员工id查询加班表
            QueryWrapper wrapper6 = new QueryWrapper();
            wrapper6.eq("STAFF_ID", record.getStaffId());// 员工id
            wrapper6.eq("TO_CHAR(CREATED_TIME,'yyyy-MM')", "TO_CHAR(sysdate,'yyyy-MM')");
            List<Overtimeask> overtimeasks = overtimeasksMapper.selectList(wrapper6);


            // 工作日加班工资
            Double workdayMoney;
            // 休息日加班工资
            Double restMoney;
            // 节假日加班工资
            Double holidaysMoney;

            for (Overtimeask overtimeask : overtimeasks) {

                if( overtimeask.getOvertimeaskType() =="工作日加班" ){

                    // 计算当前员工，工作日加班工资 （工作时长 * 工作日加班比例）
//                    overtimeask.getOvertimeaskTotalDate() * workscheme.getWorkschemeWorkratio();

                }else if(overtimeask.getOvertimeaskType() =="休息日加班"){

                    // 计算当前员工，工作日加班工资 （工作时长 * 休息日加班比例）
//                    overtimeask.getOvertimeaskTotalDate() * workscheme.getWorkschemeDayoffratio();

                }else if(overtimeask.getOvertimeaskType() =="节假日加班"){

                    // 计算当前员工，工作日加班工资 （工作时长 * 节假日加班比例）
//                    overtimeask.getOvertimeaskTotalDate() * workscheme.getWorkschemeHolidayratio();

                }

            }

            // 按员工id查询出差
            QueryWrapper wrapper7 = new QueryWrapper();
            wrapper7.eq("STAFF_ID", record.getStaffId());// 员工id
            wrapper7.eq("TO_CHAR(CREATED_TIME,'yyyy-MM')", "TO_CHAR(sysdate,'yyyy-MM')");
            List<Travel> travels = travelsMapper.selectList(wrapper7);

            // 按员工id查询请假
            QueryWrapper wrapper8 = new QueryWrapper();
            wrapper8.eq("STAFF_ID", record.getStaffId());// 员工id
            wrapper8.eq("TO_CHAR(CREATED_TIME,'yyyy-MM')", "TO_CHAR(sysdate,'yyyy-MM')");
            List<Leave> leaves = leavesMapper.selectList(wrapper8);

            // 按员工id查询考勤归档
            QueryWrapper wrapper9 = new QueryWrapper();
            wrapper9.eq("STAFF_ID", record.getStaffId());// 员工id
            wrapper9.eq("TO_CHAR(CREATED_TIME,'yyyy-MM')", "TO_CHAR(sysdate,'yyyy-MM')");
            List<Archive> archives = archiveaMapper.selectList(wrapper9);

        }

        return null;
    }
}
