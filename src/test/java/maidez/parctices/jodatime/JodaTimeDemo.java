package maidez.parctices.jodatime;

import org.joda.time.DateTime;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by luwenyi on 2018/10/19.
 */
public class JodaTimeDemo {

    @Test
    public void testJavaUtilCalendar() {
        Calendar instance = Calendar.getInstance();
        //1582-10-15
        instance.set(1582, Calendar.OCTOBER, 15);
        //减一天
        instance.add(Calendar.DAY_OF_MONTH, -1);
        //输出什么？
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime()));
    }

    @Test
    public void testJodaTimeWithDefaultISO() {
        //1582-10-15
        DateTime dateTime = DateTime.now().withYear(1582).withMonthOfYear(10).withDayOfMonth(15);
        //减一天
        DateTime dateTime1 = dateTime.plusDays(-1);
        //输出什么？
        System.out.println(dateTime1);
    }

    @Test
    public void testJodaTimeWithGJC() {
        //1582-10-15
        DateTime dateTime = new DateTime(1582, 10, 15, 8, 0, GJChronology.getInstance());
        //减一天
        DateTime dateTime1 = dateTime.plusDays(-1);
        //输出什么？
        System.out.println(dateTime1);
    }

    @Test
    public void testJodaTimeWithBuddhist() {
        DateTime now = DateTime.now();
        System.out.println(now.withChronology(BuddhistChronology.getInstance()));
    }
}
