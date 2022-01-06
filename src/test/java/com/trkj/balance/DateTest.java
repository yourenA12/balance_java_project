package com.trkj.balance;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DateTest {

/*
    @Test
    public void dateTest() {

        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("今天的日期：" + df.format(d));
        System.out.println("两天前的日期：" + df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000)));
        System.out.println("三天后的日期：" + df.format(new Date(d.getTime() + 30 * 24 * 60 * 60 * 1000)));


    }

*/

        public void dateDiff(String startTime, String endTime, String format) {

//按照传入的格式生成一个simpledateformate对象

            SimpleDateFormat sd = new SimpleDateFormat(format);

            long ye = 1000 * 24 * 60 * 60 * 365; // 年

            long mo = 1000 * 24 * 60 * 60 * 30; // 月

            long nd = 1000 * 24 * 60 * 60;//一天的毫秒数

            long nh = 1000 * 60 * 60;//一小时的毫秒数

            long nm = 1000 * 60;//一分钟的毫秒数

            long ns = 1000;//一秒钟的毫秒数

            long diff;

            try {

                //获得两个时间的毫秒时间差异

                diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();

                long year = diff / ye; // 年

                long month = diff / mo; // 月

                long day = diff / nd;//计算差多少天

                long hour = diff % nd / nh;//计算差多少小时

                long min = diff % nd % nh / nm;//计算差多少分钟

                long sec = diff % nd % nh % nm / ns;//计算差多少秒

                //输出结果

                System.out.println("时间相差：" + year + "年" + month + "月" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒。");

            } catch (ParseException e) {

                e.printStackTrace();

            }

        }

        @Test
        public void aaa() {

            this.dateDiff("2021-11-16",new SimpleDateFormat("yyyy-MM-dd").format(new Date()),"yyyy-MM-dd");

        }


        @Test
        public void dayComparePrecise(){

        Period period = Period.between(LocalDate.parse("2020-12-12"), LocalDate.parse("2022-01-21"));

        StringBuffer sb = new StringBuffer();
        sb.append(period.getYears()).append(",")
                .append(period.getMonths()).append(",")
                .append(period.getDays());
            System.out.println( sb.toString());
    }


}
