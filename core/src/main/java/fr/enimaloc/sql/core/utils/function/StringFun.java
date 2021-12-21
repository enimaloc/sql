package fr.enimaloc.sql.core.utils.function;

public class StringFun {

    public static String concat(String a, String b) {
        return "CONCAT("+a+", "+b+")";
    }

    public static String length(String value) {
        return "LENGTH("+value+")";
    }

    public static String replace(String s, String target, String replacement) {
        return "REPLACE("+s+","+target+","+replacement+")";
    }

    public static String soundex(String value) {
        return "SOUNDEX("+value+")";
    }

    public static String substring(String value, int start) {
        return "SUBSTRING("+value+","+start+")";
    }

    public static String substring(String value, int start, int length) {
        return "SUBSTRING("+value+","+start+","+length+")";
    }

    public static String left(String value, int length) {
        return "LEFT("+value+","+length+")";
    }

    public static String right(String value, int length) {
        return "RIGHT("+value+","+length+")";
    }

    public static String reverse(String value) {
        return "REVERSE("+value+")";
    }

    public static String trim(String value) {
        return "TRIM("+value+")";
    }

    public static String ltrim(String value) {
        return "LTRIM("+value+")";
    }

    public static String rtrim(String value) {
        return "RTRIM("+value+")";
    }

    public static String lpad(String value, int length) {
        return "LPAD("+value+","+length+")";
    }

    public static String upper(String value, int length) {
        return "UPPER("+value+","+length+")";
    }

    public static String lower(String value) {
        return "LOWER("+value+")";
    }

    public static String ucase(String value) {
        return "UCASE("+value+")";
    }

    public static String lcase(String value) {
        return "LCASE("+value+")";
    }

    public static String locate(String research, String s) {
        return "LOCATE("+research+","+s+")";
    }

    public static String instr(String s, String research) {
        return "INSTR("+s+","+research+")";
    }
}
