package maidez.practices.familycountrydream.utils;

import java.math.BigDecimal;

import static maidez.practices.familycountrydream.components.Constants.*;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class NumberUtils {
    public static String format(double number, int scale) {
        if (number >= FF) {
            return round(number / FF, scale) + "ff";
        } else if (number >= EE) {
            return round(number / EE, scale) + "dd";
        } else if (number >= DD) {
            return round(number / DD, scale) + "dd";
        } else if (number >= CC) {
            return round(number / CC, scale) + "cc";
        } else if (number >= BB) {
            return round(number / BB, scale) + "bb";
        } else if (number >= AA) {
            return round(number / AA, scale) + "aa";
        } else if (number >= TRILLION) {
            return round(number / TRILLION, scale) + "T";
        } else if (number >= BILLION) {
            return round(number / BILLION, scale) + "B";
        } else if (number >= MILLION) {
            return round(number / MILLION, scale) + "M";
        } else if (number >= KILO) {
            return round(number / KILO, scale) + "K";
        }
        return "" + round(number, scale);
    }

    public static String round(double number, int scale) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(number));
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).toPlainString();
    }
}
