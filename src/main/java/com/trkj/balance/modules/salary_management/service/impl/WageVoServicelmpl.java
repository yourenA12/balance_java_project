package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.entity.*;
import com.trkj.balance.modules.salary_management.mapper.*;
import com.trkj.balance.modules.salary_management.service.WageVoService;
import com.trkj.balance.modules.salary_management.vo.WagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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

    // 薪酬组 _ 未归档表
    @Autowired
    private WagenotfiledMapper wagenotfiledMapper;

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

        // 应发工资
        Double w_wagesShould = 0.0;
        // 实发工资
        Double w_payroll = 0.0;
        // 公司缴纳
        Double w_companyPay = 0.0;

        // 保留两位小数
//        DecimalFormat df = new DecimalFormat("#.00");
//        System.out.println(df.format(f));

        // 循环员工
        for (WagVo record : wagVos.getRecords()) {

            // 本月工资,
            Double monthMoney = 0.0;

            // 加班工资
            if (record != null) {

                // 按员工id查询加班表
                List<Overtimeask> overtimeasks = overtimeasksMapper.selectByStaffId(record.getStaffId());


                if (record.getStaffState() == 2) { // 试用
                    monthMoney = record.getFixedwagePeriodmoney();
                } else {// 正式
                    monthMoney = record.getFixedwageOfficialmoney();
                }

                // 工作日加班工资
                Double workdayMoney = 0.0;
                // 休息日加班工资
                Double restMoney = 0.0;
                // 节假日加班工资
                Double holidaysMoney = 0.0;

                // 循环加班表数据 // 计算加班工资
                for (Overtimeask overtimeask : overtimeasks) {

                    if (overtimeask.getOvertimeaskType().equals("工作日加班")) {

                        // 计算当前员工，工作日加班工资 （每小时工资 * 工作时长 * 工作日加班比例）
                        workdayMoney += (monthMoney / 240) * overtimeask.getOvertimeaskTotalDate() * workscheme.getWorkschemeWorkratio() / 100;

                    } else if (overtimeask.getOvertimeaskType().equals("休息日加班")) {

                        // 计算当前员工，工作日加班工资 （每小时工资 * 工作时长 * 休息日加班比例）
                        restMoney += (monthMoney / 240) * overtimeask.getOvertimeaskTotalDate() * workscheme.getWorkschemeDayoffratio() / 100;

                    } else if (overtimeask.getOvertimeaskType().equals("节假日加班")) {

                        // 计算当前员工，工作日加班工资 （每小时工资 * 工作时长 * 节假日加班比例）
                        holidaysMoney += (monthMoney / 240) * overtimeask.getOvertimeaskTotalDate() * workscheme.getWorkschemeHolidayratio() / 100;

                    }

                }

                // 工作日加班工资 存入实体类
                record.setWorkdayMoney(workdayMoney);
                // 休息日加班工资 存入实体类
                record.setRestMoney(restMoney);
                // 节假日加班工资 存入实体类
                record.setHolidaysMoney(holidaysMoney);

            }

            // 出差工资
            if (record != null) {

                // 按员工id查询出差
                List<Travel> travels = travelsMapper.selectByTravelStaffId(record.getStaffId());

                // 出差工资
                Double travelMoney = 0.0;

                // 循环出差表
                for (Travel travel : travels) {
                    // 计算出差工资 （ 出差时长 * 出差每小时工资 ）
                    travelMoney += travel.getTravelTotalDate() * business.getBusinessOnemoney();
                }

                // 出差工资 存入实体类
                record.setEvection(travelMoney);

            }

            // 工资合计
            Double totalMoney = 0.0;
            // ( 基本工资 + 加班工资 + 出差工资 )
            totalMoney = monthMoney + record.getWorkdayMoney() + record.getRestMoney() + record.getHolidaysMoney() + record.getEvection();
            record.setTotalWages(totalMoney); // 合计工资

            // 请假扣款
            if (record != null) {

                // 按员工id查询请假
                List<Leave> leaves = leavesMapper.selectByLeaveStaffId(record.getStaffId());

                // 事假扣款
                Double matterLeave = 0.0;
                // 病假扣款
                Double fallLeave = 0.0;

                // 循环员工请假数据
                for (Leave leaf : leaves) {

                    if (leaf.getLeaveType().equals("事假")) {
                        // ( 每小时工资 * 请假时长 )
                        matterLeave += monthMoney / 240 * leaf.getLeaveTotalDate();

                    } else if (leaf.getLeaveType().equals("病假")) {
                        fallLeave += monthMoney / 240 * leaf.getLeaveTotalDate();

                    }
                }

                record.setMatterLeave(matterLeave); // 事假
                record.setFallLeave(fallLeave); // 病假

            }

            // 考勤扣款

            // 迟到扣款
            Double tardy = 0.0;
            // 早退扣款
            Double leave = 0.0;
            // 旷工扣款
            Double absenteeism = 0.0;

            // 按员工id查询考勤归档
            Archive archive = archiveaMapper.selectByArchiveStaffId(record.getStaffId());

            if (archive != null) {

                // 迟到 （迟到次数 * 扣款金额/次）
                tardy = archive.getLateFrequency() * attendandce.getAttendandceLitemoney();

                // 早退 （早退次数 * 扣款金额/次）
                leave = archive.getLeaveEarlyFrequency() * attendandce.getAttendandceLeavemoney();

                // 旷工扣款（ 每小时工资 * 旷工时长 * 每小时扣款比例 ）
                absenteeism = (monthMoney / 240) * archive.getAbsenteeismFrequency() * attendandce.getAttendandceAbscntmoney() / 100;

            }
            // 将迟到扣款加入到实体类中
            record.setTardy(tardy);
            // 将早退扣款加入到实体类中
            record.setLeave(leave);
            // 将旷工扣款加入到实体类中
            record.setAbsenteeism(absenteeism);

            // 计算应发工资
            Double wagesShould = 0.0;
            // 计算实发工资
            Double payroll = 0.0;

            // ( 工资合计 - 考勤扣款 - 请假扣款 )
            wagesShould = record.getTotalWages() - record.getTardy() - record.getLeave()
                    - record.getAbsenteeism() - record.getMatterLeave() - record.getFallLeave();
            // 应发工资
            record.setWagesShould(wagesShould);

            // ( 工资合计 - 考勤扣款 - 请假扣款 - 社保/公积金缴纳 )
            payroll = record.getTotalWages() - record.getTardy() - record.getLeave()
                    - record.getAbsenteeism() - record.getMatterLeave() - record.getFallLeave()
                    - record.getInsDetailSocialPersonPay() - record.getInsDetailFundPersonPay();
            // 实发工资
            record.setPayroll(payroll);

            // 应发工资
            w_wagesShould += record.getWagesShould();
            // 实发工资
            w_payroll += record.getPayroll();
            // 公司缴纳 ( 社保 + 基金 )
            w_companyPay += record.getInsDetailSocialFirmPay() + record.getInsDetailFundFirmPay();

        }

        // 按薪酬组id查询未归档表
        Wagenotfiled wagenotfiled = wagenotfiledMapper.selectBydate(compensationId);
        if (wagenotfiled == null) {
            return wagVos;
        }
        wagenotfiled.setWagenotfiledSalary(w_wagesShould);// 应发工资
        wagenotfiled.setWagenotfiledPayrollsalary(w_payroll);// 实发工资
        wagenotfiled.setWagenotfiledFirmpayment(w_companyPay);// 公司缴纳
        wagenotfiled.setWagenotfiledAskperson(wagVos.getTotal());// 计薪人数
        wagenotfiledMapper.updateById(wagenotfiled);//修改

        return wagVos;
    }
}
