package com.trkj.balance;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

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

    @Test
    public void c() throws ParseException {
        // 补上午
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

        //使用默认时区和语言环境获得一个日历。
        Calendar    rightNow    =    Calendar.getInstance();
        /*用Calendar的get(int field)方法返回给定日历字段的值。
        HOUR 用于 12 小时制时钟 (0 - 11)，HOUR_OF_DAY 用于 24 小时制时钟。*/
        Integer year = rightNow.get(Calendar.YEAR);
        Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
        Integer day = rightNow.get(rightNow.DAY_OF_MONTH);
        Integer hour24 = rightNow.get(rightNow.HOUR_OF_DAY);
        Integer minute = rightNow.get(rightNow.MINUTE);
        Integer second = rightNow.get(rightNow.SECOND);
        Integer millisecond = rightNow.get(rightNow.MILLISECOND);
        String TimeNow24 = year+"-"+month+"-"+day+" "+"08:00:00:000";

        Date date=sdf.parse(TimeNow24);


        System.out.println(date);

        System.out.println(TimeNow24);


    }

    @Test
    public void getTimeNowThroughCalendar(){
        //使用默认时区和语言环境获得一个日历。
        Calendar    rightNow    =    Calendar.getInstance();
        /*用Calendar的get(int field)方法返回给定日历字段的值。
        HOUR 用于 12 小时制时钟 (0 - 11)，HOUR_OF_DAY 用于 24 小时制时钟。*/
        Integer year = rightNow.get(Calendar.YEAR);
        Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
        Integer day = rightNow.get(rightNow.DAY_OF_MONTH);
        Integer hour12 = rightNow.get(rightNow.HOUR);
        Integer hour24 = rightNow.get(rightNow.HOUR_OF_DAY);
        Integer minute = rightNow.get(rightNow.MINUTE);
        Integer second = rightNow.get(rightNow.SECOND);
        Integer millisecond = rightNow.get(rightNow.MILLISECOND);
        String TimeNow12 = year+"-"+month+"-"+day+" "+hour12+":"+minute+":"+second+":"+millisecond;
        String TimeNow24 = year+"-"+month+"-"+day+" "+hour24+":"+minute+":"+second+":"+millisecond;
        System.out.println("日历："+rightNow+"\n12小时制时钟："+TimeNow12+"\n24小时制时钟："+TimeNow24);
    }

}
