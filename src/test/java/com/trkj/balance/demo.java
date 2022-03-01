package com.trkj.balance;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.DeptNameMapper;
import com.trkj.balance.modules.employee_management.mapper.FixedwageMapper;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import com.trkj.balance.modules.social_management.entity.DefScheme;
import com.trkj.balance.modules.social_management.entity.InsuredDetail;
import com.trkj.balance.modules.social_management.mapper.InsuredDetailMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.*;

@SpringBootTest
public class demo {

    @Autowired
    private DeptNameMapper deptMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private FixedwageMapper fixedwageMapper;

    @Autowired
    private InsuredDetailMapper detailMapper;


    @Test
    public void test2() {

        QueryWrapper wrapper = new QueryWrapper();

        wrapper.select("STAFF_ID").eq("DEPT_ID", 4);
        wrapper.eq("POSITION_ID", 1);


        List<Integer> staffIds = staffMapper.selectList(wrapper);

        System.out.println(staffIds.toString());

    }


    @Test
    public void test1() {

        QueryWrapper wrapper = new QueryWrapper();

        wrapper.select("DEPT_NAME", "SUPERIOR_DEPT_ID").eq("DEPT_ID", 5);

        List<Map> depts = deptMapper.selectMaps(wrapper);

        System.out.println(depts.toString());

    }


    @Test
    public void test3() {

        String name;
        int pass = 0;
        Scanner sc = new Scanner(System.in);
        for (int j = 2; j >= 0; j--) {
            System.out.println("请输入用户名：");
            name = sc.next();


            // 使用死循环
            while (true) {
                System.out.println("请输入密码：");
                try {
                    // 接收int型数值，如果为小数或字母则会捕获异常
                    pass = sc.nextInt();
                    break;//为报异常，弹出死循环
                } catch (InputMismatchException e) { // {InputMismatchException} 输入类型不匹配异常
                    System.out.println("密码请输入数字！！");
                    System.out.println("重新输入");
                    sc.next();// next() 可以重置缓存中Scanner值
                }
            }

            if (name != "zhou" && pass != 1234) {
                System.out.println("输入有误！你还有" + j + "次机会！");
                if (j == 0) {
                    System.out.println("拜拜");
                    return;
                }
                continue;
            }
            System.out.println("欢迎登录！");
            break;
        }


    }


    public void demo(List<DefScheme> defScheme,int upper, int lower,int staffId) {


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
        if (money > upper) money = Double.valueOf(upper);
        // 如果工资小于基数下限 就取下限
        if (money < lower) money = Double.valueOf(lower);

        for (DefScheme scheme : defScheme) {

            // 如果工资大于基数上限 就取上限
            if (money > scheme.getDefSchemeUpper()) money = Double.valueOf(scheme.getDefSchemeUpper());
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

        }

        // 声明参保明细实体类
        InsuredDetail insuredDetail = new InsuredDetail();

        insuredDetail.setStaffId(1l);// 员工id
        insuredDetail.setInsDetailSocialPersonPay(s_person);// 社保个人缴费
        insuredDetail.setInsDetailSocialFirmPay(s_firm);// 社保公司缴费
        insuredDetail.setInsDetailFundPersonPay(f_person);// 积金个人缴费
        insuredDetail.setInsDetailFundFirmPay(f_firm);// 积金公司缴费

        // 新增参保明细表
        detailMapper.insert(insuredDetail);

    }


}
