package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.social_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.salary_management.mapper.DeptPostMapper;
import com.trkj.balance.modules.social_management.entity.*;
import com.trkj.balance.modules.social_management.mapper.*;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.service.InsuredStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <p>
 * 默认参保方案表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
@Service
public class DefInsuredServiceImpl extends ServiceImpl<DefInsuredMapper, DefInsured> implements DefInsuredService {

    // 默认参保方案
    @Autowired
    private DefInsuredMapper defInsuredMapper;

    // 默认方案
    @Autowired
    private DefSchemeMapper defSchemeMapper;

    // 参保方案 部门职位
    @Autowired
    private InsuredDeptPostMapper insuredDeptPostMapper;

    // 参保方案 员工
    @Autowired
    private InsuredStaffMapper insuredStaffMapper;

    //部门职位表
    @Autowired
    private DeptPostMapper deptPostMapper;

    // 员工表
    @Autowired
    private StaffMapper staffMapper;

    // 参保方案员工中间表service
    @Autowired
    private InsuredStaffService insuredStaffService;

    // 固定工资表
    @Autowired
    private FixedwageSoMapper fixedwageMapper;

    // 参保明细表
    @Autowired
    private InsuredDetailMapper detailMapper;

    // 参保明细详情表
    @Autowired
    private InsuredDetailSonMapper detailSonMapper;

    // 查询所有参保方案
    @Override
    public IPage<DefInsured> selectAllPage(Page page, String name, Object state) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if (name != null && name != "") {
            queryWrapper.like("DEF_INSURED_NAME", name);
        }
        if (state != null && state != "") {
            queryWrapper.eq("DEF_INSURED_STATE", state);
        }

        return defInsuredMapper.selectPage(page, queryWrapper);
    }

    // 修改参保方案状态
    @Override
    @Transactional
    public int updateDefInsuredState(DefInsured defInsured) {
        return defInsuredMapper.updateById(defInsured);
    }

    // 新增参保方案
    @Override
    @Transactional
    public int insertDefInsured(DefInsured defInsured, List<DefScheme> defScheme,
                                int upper, int lower, List<Integer> deptIds,
                                List<Integer> postIds, List<Integer> staffIds) {

        // 新增参保方案
        if (defInsuredMapper.insert(defInsured) > 0) {

            // 循环添加方案表
            for (DefScheme defScheme1 : defScheme) {

                //将新加的参保方案id 作为方案表的外键
                defScheme1.setDefInsuredId(defInsured.getDefInsuredId());
                defScheme1.setDefSchemeMin((long) lower);// 下限
                defScheme1.setDefSchemeMax((long) upper);// 上限

                // 添加方案表
                if (defSchemeMapper.insert(defScheme1) < 1) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }

            }

            // 声明一个 方案 实体类
            InsuredDeptPost insuredDeptPost = new InsuredDeptPost();
            //将新加的参保方案id 作为参保方案部门职位表的外键
            insuredDeptPost.setDefInsuredId(defInsured.getDefInsuredId());

            // 申明一个员工id数据
            List<Integer> dp_staffIds = new ArrayList<>();

            // 使用双层for循环 按部门id和职位偶读查询部门职位中间表的id
            for (int i = 0; i < deptIds.size(); i++) { // 循环部门id
                for (int j = 0; j < postIds.size(); j++) { // 循环职位id
                    // 拿到部门id和职位id 去查询部门职位中间表的id
                    Long deptPostId = deptPostMapper.selectDeptPost(deptIds.get(i), postIds.get(j));
                    // 如果id为空 则 换下一个id继续查询
                    if (deptPostId == null) {
                        continue; // 结束此次循环，j++ 再次循环
                    }

                    // 按部门id和职位id查询员工表 id
                    QueryWrapper wrapper = new QueryWrapper<>();
                    wrapper.select("STAFF_ID").eq("DEPT_ID",deptIds.get(i));
                    wrapper.eq("POSITION_ID",postIds.get(j));
                    List<Map> empIds = staffMapper.selectMaps(wrapper);
                    for (Map map : empIds) {// 遍历map
                        dp_staffIds.add(Integer.valueOf(map.get("staffId").toString()));
                    }

                    // 将查询出来的部门职位中间表id，加入参保方案部门职位中间表中
                    insuredDeptPost.setDeptPostId(deptPostId);
                    //添加参保方案部门职位中间表
                    if (insuredDeptPostMapper.insert(insuredDeptPost) < 1) {
                        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                        // 手动回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return 0;
                    }

                }
            }

            // 循环查询id是否重复
            for(int i=0;i<dp_staffIds.size();i++){
                for(int j=0;j<staffIds.size();j++){
                    // 如果重复
                    if(dp_staffIds.get(i).equals( staffIds.get(j) )){
                        // 按当前下标删除员工id
                        staffIds.remove(j);
                    }
                }
            }

            // 计算参保人数
            defInsured.setDefInsuredNumber((long) (dp_staffIds.size()+staffIds.size()));
            // 修改参保方案人数
            defInsuredMapper.updateById(defInsured);

            // 声明一个 方案 实体类
            InsuredStaff insuredStaff = new InsuredStaff();
            //将新加的参保方案id 作为参保方案员工表的外键
            insuredStaff.setDefInsuredId(defInsured.getDefInsuredId());

            // 单独员工
            for (Integer staffId : staffIds) {

                QueryWrapper wrapper = new QueryWrapper<>();
                wrapper.eq("STAFF_ID",staffId);
                wrapper.eq("INSUREDIS_ONE",1);
                insuredStaffMapper.delete(wrapper);// 删除之前有的员工


                insuredStaff.setStaffId(Long.valueOf(staffId));//将id放入
                insuredStaff.setInsuredisOne(0L);// 单独员工放入
                // 添加参保方案员工中间表
                if (insuredStaffMapper.insert(insuredStaff) < 1 || this.insertInsuredDetail(defScheme,upper,lower,staffId) <1) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }

            // 声明一个id
            List<Integer> id = new ArrayList();
            // 部门职位员工
            for (Integer staffId : dp_staffIds) {
                insuredStaff.setStaffId(Long.valueOf(staffId));//将id放入
                insuredStaff.setInsuredisOne(1L);// 部门职位 员工放入

                id.clear();// 清空id数组
                id.add(staffId);// push当前id
                // 报错部门职位需要查询一遍，员工id如果有，就跳过添加
                if( insuredStaffService.selectInsuredStaffName(id)!=null ) continue;

                // 添加参保方案员工中间表
                if (insuredStaffMapper.insert(insuredStaff) < 1 || this.insertInsuredDetail(defScheme,upper,lower,staffId) <1) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }

            return 1;

        }

        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }

    // 新增参保明细 与参保明细详情
    @Override
    @Transactional
    public int insertInsuredDetail(List<DefScheme> defScheme,int upper, int lower,int staffId) {

        // 按员工id查询员工数据
        Staff staff = staffMapper.selectById(staffId);
        // 按员工id查询固定工资
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("STAFF_ID", staffId);
        Fixedwage fixedwage = fixedwageMapper.selectOne(wrapper);
        // 声明工资
        Double money;

        if (staff.getStaffState() == 2) { // 试用员工
            // 使用期工资
            money = fixedwage.getFixedwagePeriodmoney();
        } else { // 正式员工
            // 正式期工资
            money = fixedwage.getFixedwageOfficialmoney();
        }

        // 社保个人缴费
        double s_person = 0;
        // 社保公司缴费
        double s_firm = 0;
        // 基金个人缴费
        double f_person = 0;
        // 基金公司缴费
        double f_firm = 0;

        // 如果工资大于基数上限 就取上限
        if (money > upper && upper!=0) money = Double.valueOf(upper);
        // 如果工资小于基数下限 就取下限
        if (money < lower) money = Double.valueOf(lower);

        for (DefScheme scheme : defScheme) {

            // 如果工资大于基数上限 就取上限
            if (money > scheme.getDefSchemeUpper() && scheme.getDefSchemeUpper()!=0) money = Double.valueOf(scheme.getDefSchemeUpper());
            // 如果工资小于基数下限 就取下限
            if (money < scheme.getDefSchemeFloor()) money = Double.valueOf(scheme.getDefSchemeFloor());

            if(scheme.getDefSchemeType()=="公积金"){
                // 基数乘以个人缴纳百分比 加上 个人固定缴纳
                f_person += money * (scheme.getDefSchemePersonProp() / 100) + scheme.getDefSchemePersonSum();
                // 基数乘以公司缴纳百分比 加上 公司固定缴纳
                f_firm += money * (scheme.getDefSchemeFirmProp() / 100) + scheme.getDefSchemeFirmSum();
                continue;
            }

            // 基数乘以个人缴纳百分比 加上 个人固定缴纳
            s_person += money * (scheme.getDefSchemePersonProp() / 100) + scheme.getDefSchemePersonSum();
            // 基数乘以公司缴纳百分比 加上 公司固定缴纳
            s_firm += money * (scheme.getDefSchemeFirmProp() / 100) + scheme.getDefSchemeFirmSum();

            //声明一个参保明细详情表实体类
            InsuredDetailSon detailSon = new InsuredDetailSon();
            detailSon.setStaffId((long) staffId);//员工id
            detailSon.setInsuredPaymentType(scheme.getDefSchemeType());//缴纳类型
            detailSon.setInsuredPaymentNumber(money);// 缴纳基数
            detailSon.setInsArchivePersonProp(scheme.getDefSchemePersonProp());// 个人缴纳比例
            detailSon.setInsArchivePersonMoney(money * (scheme.getDefSchemePersonProp() / 100));// 个人缴纳金额
            detailSon.setInsArchivePersonSum(scheme.getDefSchemePersonSum());// 个人固定缴纳金额
            detailSon.setInsArchiveFirmProp(scheme.getDefSchemeFirmProp());// 公司缴纳比例
            detailSon.setInsArchiveFirmMoney(money * (scheme.getDefSchemeFirmProp() / 100));// 公司缴纳金额
            detailSon.setInsArchiveFirmSum(scheme.getDefSchemeFirmSum());// 公司固定缴纳金额

            // 添加参保明细详情表
            if(detailSonMapper.insert(detailSon)<1) return 0;

        }

        // 声明参保明细实体类
        InsuredDetail insuredDetail = new InsuredDetail();

        insuredDetail.setStaffId((long) staffId);// 员工id
        insuredDetail.setInsDetailSocialPersonPay(s_person);// 社保个人缴费
        insuredDetail.setInsDetailSocialFirmPay(s_firm);// 社保公司缴费
        insuredDetail.setInsDetailFundPersonPay(f_person);// 积金个人缴费
        insuredDetail.setInsDetailFundFirmPay(f_firm);// 积金公司缴费

        // 新增参保明细表
        return detailMapper.insert(insuredDetail);

    }

    // 按参保方案id查询参保方案
    @Override
    public DefInsured selectDefInsuredById(int id) {
        return defInsuredMapper.selectById(id);
    }

    // 按参保方案id查询方案
    @Override
    public List<DefScheme> selectDefSchemeById(int id) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("DEF_INSURED_ID", id);
        return defSchemeMapper.selectList(wrapper);
    }

    // 按参保方案id查询部门id
    @Override
    public List<Integer> selectDeptId(int id) {
        List<Integer> insuredDeptPosts = insuredDeptPostMapper.selectinsuredDeptPostBydefInsuredId(id);

        if (insuredDeptPosts.size() == 0) {
            return null;
        }

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("DEPT_POST_ID", insuredDeptPosts);

        return deptPostMapper.selectDeptId(wrapper);
    }

    // 按参保方案id查询职位id
    @Override
    public List<Integer> selectPostId(int id) {
        List<Integer> insuredDeptPosts = insuredDeptPostMapper.selectinsuredDeptPostBydefInsuredId(id);

        if (insuredDeptPosts.size() == 0) {
            return null;
        }

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("DEPT_POST_ID", insuredDeptPosts);

        return deptPostMapper.selectPostId(wrapper);
    }

    // 按参保方案id查询员工
    @Override
    public List<Integer> selectStaffId(int id) {

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STAFF_ID").eq("DEF_INSURED_ID", id);
        wrapper.eq("INSUREDIS_ONE",0);// 状态为员工不是部门职位
        return insuredStaffMapper.selectList(wrapper);
    }

    // 按参保方案id删除
    @Override
    @Transactional
    public int deleteDefInsured(int id) {

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("DEF_INSURED_ID", id);

        insuredDeptPostMapper.delete(wrapper); // 按参保方案id删除 部门职位
        insuredStaffMapper.delete(wrapper); // 删除员工
        defSchemeMapper.delete(wrapper); // 删除方案
        defInsuredMapper.delete(wrapper); // 删除参保方案

        // 按参保方案id 查询参保方案员工中间表，返回员工ids
        List<InsuredStaff> insuredStaffs = insuredStaffMapper.selectList(wrapper);

        if(insuredStaffs.size()==0) return 1;

        // 拿到ids 去参保明细表按员工id删除数据 使用in（ids）
        List<Integer> staffIds = new ArrayList<>();
        for (InsuredStaff insuredStaff : insuredStaffs) {
            staffIds.add(Math.toIntExact(insuredStaff.getStaffId()));
        }
        QueryWrapper wrapper1 = new QueryWrapper<>();
        wrapper1.in("STAFF_ID",staffIds);
        detailMapper.deleteByDate(wrapper1);// 按员工id删除参保明细表

        detailSonMapper.deleteByDate(wrapper1);// 按员工id删除参保明细详情表


        return 1;
    }


    //根据参保方案名称查询
    @Override
    public String selectDefInsuredNames(String name) {
        // 声明一个条件构造器
        QueryWrapper<DefInsured> wrapper = new QueryWrapper<>();
        wrapper.eq("DEF_INSURED_NAME", name);
        List<DefInsured> defInsureds = defInsuredMapper.selectList(wrapper);
        // 有数据 返回薪酬组名称
        if (defInsureds.size() > 0) {
            return name;
        }

        return null;
    }


}
