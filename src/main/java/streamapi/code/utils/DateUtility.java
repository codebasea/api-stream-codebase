package streamapi.code.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import streamapi.code.constant.StreamConstant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

import static streamapi.code.utils.LoggerInfoPrintln.prettyLogInfo;

public class DateUtility {

    public static void main(String[] args) {
//        getZonedDateTimeDate();
//        getDaysBetweenDates();
//        castBetweenStringAndDate();
        convertToOnlyDateV2();
//        convertToDateJodaTime("2011-01-18 00:00:00.0");

    }

    private static void convertToDateJodaTime(String date_s) {
         date_s = "2011-01-18 00:00:00.0";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd' 'HH:mm:ss.SSS");
        DateTime dateTimeInUTC = formatter.withZoneUTC().parseDateTime( date_s );

        System.out.println( "dateTimeInUTC: " + dateTimeInUTC );
        System.out.println( "dateTimeInUTC (date only): " + org.joda.time.format.ISODateTimeFormat.date().print( dateTimeInUTC ) );
        System.out.println( "" ); // blank line.

//        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        DateTimeZone kolkataTimeZone = DateTimeZone.forID( "Asia/Kolkata" );
        DateTime dateTimeInKolkata = formatter.withZone( kolkataTimeZone ).parseDateTime( date_s );
        System.out.println( "dateTimeInKolkata: " + dateTimeInKolkata );
        System.out.println( "dateTimeInKolkata (date only): " + org.joda.time.format.ISODateTimeFormat.date().print( dateTimeInKolkata ) );
// This date-time in Kolkata is a different point in the time line of the Universe than the dateTimeInUTC instance created above. The date is even different.
        System.out.println( "dateTimeInKolkata adjusted to UTC: " + dateTimeInKolkata.toDateTime( org.joda.time.DateTimeZone.UTC ) );
}
    private static Date convertToDateV2(String receivedDate)  {
        receivedDate = "2011-01-18 00:00:00.0";
        SimpleDateFormat format = new SimpleDateFormat(StreamConstant.PATTERN);
        Date date = null;
        try {
            date = format.parse(receivedDate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


        private static Date convertToDate(String receivedDate)  {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(receivedDate);
            String requiredDate = formatter.format(new Date()).toString();

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String requiredDate2 = df.format(new Date());
            System.out.println("requiredDate "+requiredDate);
            System.out.println("requiredDate2 "+requiredDate2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(date);
        return date;

    }

          private static void castBetweenStringAndDate(){

        String date_s = "2011-01-18 00:00:00.0";

        // *** note that it's "yyyy-MM-dd hh:mm:ss" not "yyyy-mm-dd hh:mm:ss"
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = dt.parse(date_s);
            LoggerInfoPrintln.prettyLogInfo("String to Date Format",date);
            // *** same for the format String below
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String strDateFormat = dt1.format(date);
            LoggerInfoPrintln.prettyLogInfo("Date to String Format",strDateFormat);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

    private static void getFormattedDate(){
        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String formattedDate = sdf.format(date);
        LoggerInfoPrintln.prettyLogInfo("SimpleDateFormat",formattedDate);
    }
    private static void getDateToInstant(){
// java.sql.date to java.time.Instant
        java.sql.Date sqlDate = new java.sql.Date(1446853831381L);
        Instant instant = Instant.ofEpochMilli(sqlDate.getTime());
        LoggerInfoPrintln.prettyLogInfo("java.sql.date to java.time.Instant",instant);

        //Can also convert to LocalDate directly
        sqlDate.toLocalDate();
        LoggerInfoPrintln.prettyLogInfo("Can also convert to LocalDate directly",sqlDate);

    }
    private static void getDaysBetweenDates(){
        LocalDate today = LocalDate.now();
        LocalDate threeDaysAgo = today.minusDays(3);
        long days = ChronoUnit.DAYS.between(threeDaysAgo, today);
        LoggerInfoPrintln.prettyLogInfo("Days between dates",days);

    }

    private static void getDateToZonedDateTime(){
        Date now = new Date();
        ZonedDateTime utc = ZonedDateTime.ofInstant(now.toInstant(), ZoneOffset.UTC);
        ZonedDateTime auckland = ZonedDateTime.ofInstant(now.toInstant(), ZoneId.of("Pacific/Auckland"));
        ZonedDateTime plusOne = ZonedDateTime.ofInstant(now.toInstant(), ZoneOffset.of("+1"));
        LoggerInfoPrintln.prettyLogInfo(now);
        LoggerInfoPrintln.prettyLogInfo(utc);
        LoggerInfoPrintln.prettyLogInfo(auckland);
        LoggerInfoPrintln.prettyLogInfo(plusOne);
    }

    private static void getZonedDateTimeDate(){
        // Convert java.time.ZonedDateTime to java.util.Date
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);

        // Start of today
        ZonedDateTime startOfToday = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

        Date now = Date.from(utc.toInstant());
        LoggerInfoPrintln.prettyLogInfo(utc);
        LoggerInfoPrintln.prettyLogInfo(now);
        LoggerInfoPrintln.prettyLogInfo("startOfToday",startOfToday);

        // Start of this week (Monday)
        ZonedDateTime startOfWeek = LocalDate.now().atStartOfDay(ZoneId.of("Europe/London")).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LoggerInfoPrintln.prettyLogInfo("startOfWeek",startOfWeek);

// Start of this month
        ZonedDateTime startOfMonth = LocalDate.now().atStartOfDay(ZoneOffset.UTC).with(TemporalAdjusters.firstDayOfMonth());
        LoggerInfoPrintln.prettyLogInfo("startOfMonth",startOfMonth);

    }

    public static void convertToOnlyDateV2() {
        String strDate = "2011-01-18 00:00:00.0";
        java.time.format.DateTimeFormatter dtfInput = java.time.format.DateTimeFormatter.ofPattern("u-M-d H:m:s.S", Locale.ENGLISH);
        java.time.LocalDateTime ldt = LocalDateTime.parse(strDate, dtfInput);
        // Alternatively,
        // LocalDateTime ldt = dtfInput.parse(strDate, LocalDateTime::from);

        java.time.LocalDate date = ldt.toLocalDate();
        System.out.println(date);
    }
    public String convertToOnlyDate(String currentDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a ");
        Date date;
        String dateString = "";
        try {
            date = dateFormat.parse(currentDate);
            System.out.println(date.toString());

            dateString = dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateString;
    }
}
