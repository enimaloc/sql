package fr.enimaloc.sql.core.utils.function;

public class Fun {

    public static String md5(String s) {
        return "MD5(" + s + ")";
    }

    public static String cast(String expression, String as) {
        return "CAST(" + expression + " AS "+as+")";
    }

}
