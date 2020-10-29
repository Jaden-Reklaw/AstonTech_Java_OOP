package common.helpers;

public class StringHelper {
    //Checks string if it is null or empty
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String removeLeadingAndTrailingSpaces(String s) {
        return s.trim();
    }

    public static String removeAllSpace(String s) {
        s = s.replaceAll("\\s", "");
        return s;
    }

    public static String yelling(String s) {
        return s.toUpperCase() + "!";
    }
}
