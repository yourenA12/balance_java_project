package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.mapper.CardNMapper;
import com.trkj.balance.modules.attendance_management.mapper.ClockRecordMapper;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.examine_management.entity.*;
import com.trkj.balance.modules.attendance_management.entity.ClockRecord;
import com.trkj.balance.modules.examine_management.mapper.*;
import com.trkj.balance.modules.examine_management.service.AuditflowdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 审批流明细表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@Service
public class AuditflowdetailServiceImpl extends ServiceImpl<AuditflowdetailMapper, Auditflowdetail> implements AuditflowdetailService {
    //修改审批明细表的状态
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    //注入主表Mapper
    @Autowired
    private AuditflowMapper auditflowMapper;
    //注入员工表mapper
    @Autowired
    private StaffMapper staffMapper;
    //注入部门表Mapper
    @Autowired
    private DeptMapper deptMapper;
    //注入 工资表mapper
    @Autowired
    private FixedwageNMapper fixedwageNMapper;
    // 调薪表
    @Autowired
    private SalaryEMapper salaryEMapper;
    //异动后部门
    @Autowired
    private TransferMapper1 transferMapper1;
    //注入打卡记录表
    @Autowired
    private ClockRecordMapper clockRecordMapper;
    //注入一个补打卡表
    @Autowired
    private CardNMapper cardNMapper;

    //转正与离职的修改状态方法
    @Override
    @Transactional
    public int updateAuditflowdetail(Auditflowdetail auditflowdetail) {

        // 按照明细表id更改状态
        auditflowdetailMapper.updateById(auditflowdetail);

        if (auditflowdetail.getAuditflowdetaiState()==2){
            // 按照主表id查询明细表数据，分页查询 第一页第一条
            Page<Auditflowdetail> page = new Page<>(1,1);
            //声明一个条件构造器
            QueryWrapper wrapper = new QueryWrapper();
            //查询 明细表id 和 主表id
            wrapper.select("AUDITFLOWDETAIL_ID").eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
            //查询 明细表状态为0
            wrapper.eq("AUDITFLOWDETAI_STATE",0);
            //根据创建时间排序
            wrapper.orderByAsc("AUDITFLOWDETAIL_ID");
            IPage a = auditflowdetailMapper.selectPage(page,wrapper);

            // 获取第一条数据改状态为1
            if (a.getTotal()>0){
                //获取查出来的明细表第一条数据 下表为0 的数据
                Auditflowdetail auditflowdetail1=(Auditflowdetail)a.getRecords().get(0);
                //new 一个明细表实体类对象
                Auditflowdetail auditflowdetail2= new Auditflowdetail();
                //写入 获取的明细表id
                auditflowdetail2.setAuditflowdetailId(auditflowdetail1.getAuditflowdetailId());
                //将第一条明细表数据 的状态改为1
                auditflowdetail2.setAuditflowdetaiState(1L);
                //调用修改
                auditflowdetailMapper.updateById(auditflowdetail2);
            }else{// 如果没有就改主表状态为2
                //new 一个 主表实体对象
                Auditflow auditflow = new Auditflow();
                //
                auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
                //修改主表状态为 明细表的状态
                auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
                //调用修改
                auditflowMapper.updateById(auditflow);
                //获取主表id
                Auditflow auditflowx = auditflowMapper.selectById(auditflowdetail.getAuditflowId());
                //new 一个 员工实体对象
                Staff staff = new Staff();
                //将 主表里的员工id 放到员工表里
                staff.setStaffId(auditflowx.getStaffId());
                //将员工表状态改为3 正式员工的状态
                staff.setStaffState(auditflowdetail.getIsStaffState());
                //调用 修改
                staffMapper.updateById(staff);
            }
            //驳回的修改
        }else{
            // 按照主表id更改主表状态为3
            Auditflow auditflow = new Auditflow();
            auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
            auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
            auditflowMapper.updateById(auditflow);
        }

        return 1;
    }

    //调动部门修改（人事异动）
    @Override
    @Transactional
    public int updateTransfer(Auditflowdetail auditflowdetail) {
        // 按照明细表id更改状态
        auditflowdetailMapper.updateById(auditflowdetail);

        if (auditflowdetail.getAuditflowdetaiState()==2){
            // 按照主表id查询明细表数据，分页查询 第一页第一条
            Page<Auditflowdetail> page = new Page<>(1,1);
            //声明一个条件构造器
            QueryWrapper wrapper = new QueryWrapper();
            //查询 明细表id 和 主表id
            wrapper.select("AUDITFLOWDETAIL_ID").eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
            //查询 明细表状态为0
            wrapper.eq("AUDITFLOWDETAI_STATE",0);
            //根据创建时间排序
            wrapper.orderByAsc("AUDITFLOWDETAIL_ID");
            IPage a = auditflowdetailMapper.selectPage(page,wrapper);

            // 获取第一条数据改状态为1
            if (a.getTotal()>0){
                //获取查出来的明细表第一条数据 下表为0 的数据
                Auditflowdetail auditflowdetail1=(Auditflowdetail)a.getRecords().get(0);
                //new 一个明细表实体类对象
                Auditflowdetail auditflowdetail2= new Auditflowdetail();
                //写入 获取的明细表id
                auditflowdetail2.setAuditflowdetailId(auditflowdetail1.getAuditflowdetailId());
                //将第一条明细表数据 的状态改为1
                auditflowdetail2.setAuditflowdetaiState(1L);
                //调用修改
                auditflowdetailMapper.updateById(auditflowdetail2);
            }else{// 如果没有就改主表状态为2
                //new 一个 主表实体对象
                Auditflow auditflow = new Auditflow();
                //
                auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
                //修改主表状态为 明细表的状态
                auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
                //调用修改
                auditflowMapper.updateById(auditflow);
                //获取主表id
                Auditflow auditflowx = auditflowMapper.selectById(auditflowdetail.getAuditflowId());
                // 按照审批编号查询调薪表中调薪后工资
                QueryWrapper wrapper1 = new QueryWrapper();
                // 获取主表id
                wrapper1.eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
                //查询 调动表的一条数据
                Transfer transfer=transferMapper1.selectOne(wrapper1);
                //条件构造器
                QueryWrapper wrapper2 = new QueryWrapper();
                //拿到员工id
                wrapper2.eq("STAFF_ID",auditflowx.getStaffId());
                //new 一个 部门实体对象
                Staff staff = new Staff();
                //将 主表里的员工id 放到员工表里
                staff.setStaffId(auditflowx.getStaffId());
                //通过员工id 将调动表的调动后部门 改到员工表
                staff.setDeptId(transfer.getUpdatedDeptId());

                //调用 修改
                staffMapper.updateById(staff);
            }
            //驳回的修改
        }else{
            // 按照主表id更改主表状态为3
            Auditflow auditflow = new Auditflow();
            auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
            auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
            auditflowMapper.updateById(auditflow);
        }

        return 1;
    }

    //修改调薪 通过调薪修改固定工资表
    @Override
    @Transactional
    public int updateFixedwage(Auditflowdetail auditflowdetail) {
        // 按照明细表id更改状态
        auditflowdetailMapper.updateById(auditflowdetail);

        if (auditflowdetail.getAuditflowdetaiState()==2){
            // 按照主表id查询明细表数据，分页查询 第一页第一条
            Page<Auditflowdetail> page = new Page<>(1,1);
            //声明一个条件构造器
            QueryWrapper wrapper = new QueryWrapper();
            //查询 明细表id 和 主表id
            wrapper.select("AUDITFLOWDETAIL_ID").eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
            //查询 明细表状态为0
            wrapper.eq("AUDITFLOWDETAI_STATE",0);
            //根据创建时间排序
            wrapper.orderByAsc("AUDITFLOWDETAIL_ID");
            IPage a = auditflowdetailMapper.selectPage(page,wrapper);

            // 获取第一条数据改状态为1
            if (a.getTotal()>0){
                //获取查出来的明细表第一条数据 下表为0 的数据
                Auditflowdetail auditflowdetail1=(Auditflowdetail)a.getRecords().get(0);
                //new 一个明细表实体类对象
                Auditflowdetail auditflowdetail2= new Auditflowdetail();
                //写入 获取的明细表id
                auditflowdetail2.setAuditflowdetailId(auditflowdetail1.getAuditflowdetailId());
                //将第一条明细表数据 的状态改为1
                auditflowdetail2.setAuditflowdetaiState(1L);
                //调用修改
                auditflowdetailMapper.updateById(auditflowdetail2);
            }else{// 如果没有就改主表状态为2
                //new 一个 主表实体对象
                Auditflow auditflow = new Auditflow();
                //
                auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
                //修改主表状态为 明细表的状态
                auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
                //调用修改
                auditflowMapper.updateById(auditflow);
                //获取主表id
                Auditflow auditflowx = auditflowMapper.selectById(auditflowdetail.getAuditflowId());

                // 按照审批编号查询调薪表中调薪后工资
                QueryWrapper wrapper1 = new QueryWrapper();
                // 获取主表id
                wrapper1.eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
                //查询 调薪表的一条数据
                Salary salary=salaryEMapper.selectOne(wrapper1);
                //
                QueryWrapper wrapper2 = new QueryWrapper();
                //拿到员工id
                wrapper2.eq("STAFF_ID",auditflowx.getStaffId());

                //new 一个 固定工资实体对象、
                Fixedwage fixedwage = new Fixedwage();
                //将 主表里的员工id 放到员工表里  hu
//                fixedwage.setStaffId(auditflowx.getStaffId());
                //将 调表的调薪后工资 set到工资表的 薪资里面
                fixedwage.setFixedwageOfficialmoney(salary.getAfterSalary());
                //调用 修改
                fixedwageNMapper.update(fixedwage,wrapper2);
            }
            //驳回的修改
        }else{
            // 按照主表id更改主表状态为3
            Auditflow auditflow = new Auditflow();
            auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
            auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
            auditflowMapper.updateById(auditflow);
        }

        return 1;
    }

    //修改加班表状态
    @Override
    @Transactional
    public int updateOvertimeask(Auditflowdetail auditflowdetail) {
        // 按照明细表id更改状态
        auditflowdetailMapper.updateById(auditflowdetail);

        if (auditflowdetail.getAuditflowdetaiState()==2){
            // 按照主表id查询明细表数据，分页查询 第一页第一条
            Page<Auditflowdetail> page = new Page<>(1,1);
            //声明一个条件构造器
            QueryWrapper wrapper = new QueryWrapper();
            //查询 明细表id 和 主表id
            wrapper.select("AUDITFLOWDETAIL_ID").eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
            //查询 明细表状态为0
            wrapper.eq("AUDITFLOWDETAI_STATE",0);
            //根据创建时间排序
            wrapper.orderByAsc("AUDITFLOWDETAIL_ID");
            IPage a = auditflowdetailMapper.selectPage(page,wrapper);

            // 获取第一条数据改状态为1
            if (a.getTotal()>0){
                //获取查出来的明细表第一条数据 下表为0 的数据
                Auditflowdetail auditflowdetail1=(Auditflowdetail)a.getRecords().get(0);
                //new 一个明细表实体类对象
                Auditflowdetail auditflowdetail2= new Auditflowdetail();
                //写入 获取的明细表id
                auditflowdetail2.setAuditflowdetailId(auditflowdetail1.getAuditflowdetailId());
                //将第一条明细表数据 的状态改为1
                auditflowdetail2.setAuditflowdetaiState(1L);
                //调用修改
                auditflowdetailMapper.updateById(auditflowdetail2);
            }else{// 如果没有就改主表状态为2
                //new 一个 主表实体对象
                Auditflow auditflow = new Auditflow();
                //获取主表id
                auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
                //修改主表状态为 明细表的状态
                auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
                //调用修改
                auditflowMapper.updateById(auditflow);
            }
            //驳回的修改
        }else{
            // 按照主表id更改主表状态为3
            Auditflow auditflow = new Auditflow();
            auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
            auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
            auditflowMapper.updateById(auditflow);
        }

        return 1;
    }


    //修改补打卡
    @Override
    @Transactional
    public int updateCard(Auditflowdetail auditflowdetail) {
        // 按照明细表id更改状态
        auditflowdetailMapper.updateById(auditflowdetail);

        if (auditflowdetail.getAuditflowdetaiState()==2){
            // 按照主表id查询明细表数据，分页查询 第一页第一条
            Page<Auditflowdetail> page = new Page<>(1,1);
            //声明一个条件构造器
            QueryWrapper wrapper = new QueryWrapper();
            //查询 明细表id 和 主表id
            wrapper.select("AUDITFLOWDETAIL_ID").eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
            //查询 明细表状态为0
            wrapper.eq("AUDITFLOWDETAI_STATE",0);
            //根据创建时间排序
            wrapper.orderByAsc("AUDITFLOWDETAIL_ID");
            IPage a = auditflowdetailMapper.selectPage(page,wrapper);

            // 获取第一条数据改状态为1
            if (a.getTotal()>0){
                //获取查出来的明细表第一条数据 下表为0 的数据
                Auditflowdetail auditflowdetail1=(Auditflowdetail)a.getRecords().get(0);
                //new 一个明细表实体类对象
                Auditflowdetail auditflowdetail2= new Auditflowdetail();
                //写入 获取的明细表id
                auditflowdetail2.setAuditflowdetailId(auditflowdetail1.getAuditflowdetailId());
                //将第一条明细表数据 的状态改为1
                auditflowdetail2.setAuditflowdetaiState(1L);
                //调用修改
                auditflowdetailMapper.updateById(auditflowdetail2);

            }else{// 如果没有就改主表状态为2
                //new 一个 主表实体对象
                Auditflow auditflow = new Auditflow();
                //获取主表id
                auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
                //修改主表状态为 明细表的状态
                auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
                //调用修改
                auditflowMapper.updateById(auditflow);


                Auditflow auditflowx = auditflowMapper.selectById(auditflowdetail.getAuditflowId());

                QueryWrapper wrapper1 = new QueryWrapper();
                // 获取主表id
                wrapper1.eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
                //查询 补打卡表的一条数据
                Card card=cardNMapper.selectOne(wrapper1);

                if(card.getCardType()=="未签到"){
                    // 补上午

                }else{
                    // 补下午

                }

                //条件构造器
                QueryWrapper wrapper2 = new QueryWrapper();
                //拿到员工id
                wrapper2.eq("STAFF_ID",card.getStaffId());
                // 当前时间
                wrapper2.eq("TO_CHAR(CREATED_TIME,'yyyy-MM-dd')","TO_CHAR(sysdate,'yyyy-MM-dd')");
                //new 一个 打卡记录表
                ClockRecord clockRecord = clockRecordMapper.selectOne(wrapper2);
                // 修改打卡记录


            }
            //驳回的修改
        }else{
            // 按照主表id更改主表状态为3
            Auditflow auditflow = new Auditflow();
            auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
            auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
            auditflowMapper.updateById(auditflow);
        }

        return 1;
    }




}




