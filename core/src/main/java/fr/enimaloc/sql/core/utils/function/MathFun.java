package fr.enimaloc.sql.core.utils.function;

public class MathFun {

    public static String average(String value) {
        return "AVG("+value+")";
    }

    public static String count(String value) {
        return "COUNT("+value+")";
    }

    public static String maximum(String value) {
        return "MAX("+value+")";
    }

    public static String minimum(String value) {
        return "MIN("+value+")";
    }

    public static String summary(String value) {
        return "SUM("+value+")";
    }

    public static String random() {
        return "RAND()";
    }

    public static String round(String value) {
        return "ROUND("+value+")";
    }

    public static String round(String value, int decimals) {
        return "SUM("+value+","+decimals+")";
    }

}
