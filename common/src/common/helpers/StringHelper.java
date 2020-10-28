package common.helpers;

public class StringHelper {
    //Checks string if it is null or empty
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
