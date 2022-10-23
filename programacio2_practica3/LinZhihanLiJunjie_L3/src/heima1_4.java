import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*

    Date类

*/
public class heima1_4 {

    public static void main(String[] args) throws ParseException {
        
        Date d1 = new Date();
        System.out.println(d1); // Thu Jan 28 22:27:57 CET 2021

        long date = 1000*60*60;
        Date d2 = new Date(date);
        System.out.println(d2);  // Thu Jan 01 02:00:00 CET 1970

        Date d = new Date();
        System.out.println(d.getTime()); //1611869424006
        System.out.println(d.getTime()*1.0/1000/60/60/24/365 + " años "); // 51.112044140220696 años

        long time = 1000*60*60;
        d.setTime(time);
        System.out.println(d); //Thu Jan 01 02:00:00 CET 1970

        long time2 = System.currentTimeMillis();
        d.setTime(time2);
        System.out.println(d); //Thu Jan 28 22:32:15 CET 2021

        /*

            SimpleDateFormtat

        */

        Date d3 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(); // 2021/1/28 下午10:36
        String s = sdf.format(d3);
        System.out.println(s);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH：mm：ss"); // 20210128223617
        String s1 = sdf1.format(d3);
        System.out.println(s1);

        String s2 = "2048-09-08 11:11:11";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Tue Sep 08 11:11:11 CEST 2048
        Date d4 = sdf2.parse(s2);                                              //throws ParseException
        System.out.println(d4);

        /*

            Calendar

        */

        Calendar c = Calendar.getInstance(); //多态的形态
        System.out.println(c);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + day + "日") ; // 2021年1月28日

        c.add(Calendar.YEAR, -3);
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH) + 1;
        int day1 = c.get(Calendar.DATE);
        System.out.println(year1 + "年" + month1 + "月" + day1 + "日") ; // 2018年1月28日

        c.set(2048, 11,11);
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH) + 1;
        int day2 = c.get(Calendar.DATE);
        System.out.println(year2 + "年" + month2 + "月" + day2 + "日") ; // 2048年12月11日

    }
    
}
