package string.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static common.code.constant.CodebaseConstant.SIMPLE_DATE_FORMAT;
import static common.code.constant.CodebaseConstant.STRING_DATE;

public class ConvertStringDateToTimestamp {
    public static void main(String[] args) {
        convertStringToDate();

    }

    private static void convertStringToDate() {
        try {
            //creating date format
            SimpleDateFormat dateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
            //parsing string to date using parse() method
            Date parsedDate = dateFormat.parse(STRING_DATE);
            //finally creating a timestamp
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            System.out.println(timestamp);
            //converting string date to timestamp using valueOf() method
             timestamp = Timestamp.valueOf( STRING_DATE );

            System.out.println("valueOf"+timestamp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
