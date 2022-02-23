package com.trkj.balance;

import com.trkj.balance.modules.salary_management.mapper.CompensationDeptPostMapper;
import com.trkj.balance.modules.salary_management.mapper.DeptPostMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

//    //薪酬组部门职位表
//    @Autowired
//    private CompensationDeptPostMapper compensationDeptPostMapper;
//
//    //部门职位表
//    @Autowired
//    private DeptPostMapper deptPostMapper;

    // 计算三个月后的日期
    @Test
    public void a(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(date));   // 当前系统时间
//        Date newDate = stepMonth(date, 3);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 3);

        System.out.println("当前时间3个月后的日期：" + df.format(c.getTime()));
    }


    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate YYYY-MM-DD
     * @param toDate YYYY-MM-DD
     * @return 年,月,日 例如 1,1,1
     */

    public static String dayComparePrecise(String fromDate, String toDate){

        Period period = Period.between(LocalDate.parse(fromDate), LocalDate.parse(toDate));

        System.out.println(period.getYears()+"年"+period.getMonths()+"月"+period.getDays()+"日");



        StringBuffer sb = new StringBuffer();
        sb.append(period.getYears()).append(",")
                .append(period.getMonths()).append(",")
                .append(period.getDays());
        return sb.toString();
    }

    @Test
    public void b() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(dayComparePrecise("2021-12-12","2023-09-18"));
    }


//    @Test
//    public void xx(){
//
//        ArrayList<Integer> deptIds = new ArrayList<Integer>();
//        deptIds.add(1);
//        deptIds.add(2);
//        deptIds.add(5);
//
//        ArrayList<Integer> postIds = new ArrayList<Integer>();
//        postIds.add(5);
//        postIds.add(2);
//        postIds.add(3);
//
//
//        // 使用双层for循环 按部门id和职位偶读查询部门职位中间表的id
//        for (int i=0;i<deptIds.size();i++){ // 循环部门id
//            for (int j=0;j<postIds.size();j++){ // 循环职位id
//                // 拿到部门id和职位id 去查询部门职位中间表的id
//                Long deptPostId=deptPostMapper.selectDeptPost(deptIds.get(i),postIds.get(j));
//                // 如果id为空 则 换下一个id继续查询
//                if(deptPostId==null){
//                    continue; // 结束此次循环，j++ 再次循环
//                }
//
//                //添加薪酬组部门职位表
//                compensationDeptPostMapper.selectById(deptPostId);
//
//
//            }
//        }
//
//        return null;
//
//    }


}
