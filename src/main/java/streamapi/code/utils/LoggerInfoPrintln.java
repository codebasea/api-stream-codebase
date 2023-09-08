package streamapi.code.utils;

public class LoggerInfoPrintln {

    public static  final void prettyLogInfo(String message, Object object){
        System.out.println(message+" : "+object);
    }

    public static  final void prettyLogInfo(Object object){
        System.out.println(object);
    }
}
