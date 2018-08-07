package maidez.practices.utils;

import java.util.regex.Pattern;

/**
 * Created by luwenyi on 2018/6/13.
 */
public class NumberUtils {
    private static Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d+|\\d*)$");

    public static boolean isNumber(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return pattern.matcher(str).matches();
    }
}
