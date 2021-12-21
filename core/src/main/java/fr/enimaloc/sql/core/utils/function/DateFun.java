package fr.enimaloc.sql.core.utils.function;

public class DateFun {

    public static String dateFormat(String parse, String format) {
        return "DATE_FORMAT(" + parse + ", " + format + ")";
    }

    public static String dayOfWeek() {
        return "DAYOFWEEK()";
    }

    public static String month(String date) {
        return "MONTH("+date+")";
    }

    public static String now() {
        return "NOW()";
    }

    public static String timeDiff(String time1, String time2) {
        return "TIMEDIFF("+time1+","+time2+")";
    }

    public static String timestamp(String date) {
        return "TIMESTAMP("+date+")";
    }

    public static String timestamp(String date, String time) {
        return "TIMESTAMP("+date+","+time+")";
    }

    public static String year(String date) {
        return "YEAR("+date+")";
    }
}
