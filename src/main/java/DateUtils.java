package string.util.util;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class DateUtils {

    public void calculateDaysRangeWithCurrentDate(){
        System.out.println("Calculate difference between two dates");
        System.out.println("=================================================================");

        DateTime startDate = new DateTime(2023, 1, 19, 0, 0, 0, 0);
        DateTime endDate = new DateTime();
        Days d = Days.daysBetween(startDate, endDate);
        int days = d.getDays();
//        System.out.println("  Difference between ##" + endDate+"##  <<and>> " + startDate );
//        System.out.println( " is:\n " + days + " days.");
    }

    public void calculateNumberOfDays(){
        DateTime startDate = new DateTime(2023, 1, 19, 0, 0, 0, 0);
        DateTime endDate = new DateTime(); //current date
        Days diff = Days.daysBetween(startDate, endDate);
//        System.out.println("calculateNumberOfDays# " +diff.getDays());
    }

    public void numberOfDays(){
        LocalDate independenceDay = LocalDate.of(2023, Month.MARCH, 4);
        LocalDate christmas = LocalDate.now();
        long days = independenceDay.until(christmas, ChronoUnit.DAYS);
//        System.out.println("Until christmas (with crono): "+days);
    }

    public void countDaysInDate(){
        LocalDate independenceDay = LocalDate.of(2022, Month.MARCH, 5);
        LocalDate christmas = LocalDate.now();
        long days2 = ChronoUnit.DAYS.between(independenceDay, christmas);

        if(days2 > 240){
            System.out.println("Until christmas \n(with days2): "+days2);
            long diffDays = Math.subtractExact(days2, 240);
            System.out.println("diffDays  "+diffDays);
            independenceDay = independenceDay.plusDays(diffDays);
            System.out.println(independenceDay+"--");
        }

    }
}
