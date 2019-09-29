package maidez.practices.familycountrydream.utils;

import maidez.practices.familycountrydream.components.Constants;

import java.math.BigDecimal;

import static maidez.practices.familycountrydream.components.Constants.BILLION;
import static maidez.practices.familycountrydream.components.Constants.KILO;
import static maidez.practices.familycountrydream.components.Constants.MILLION;
import static maidez.practices.familycountrydream.components.Constants.TRILLION;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class NumberUtils {
    public static String format(double number, int scale) {
        if (number >= Constants.TRILLION) {
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
