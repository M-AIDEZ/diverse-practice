package maidez.practices.familycountrydream.utils;

import maidez.practices.familycountrydream.components.Constants;

import static maidez.practices.familycountrydream.components.Constants.BILLION;
import static maidez.practices.familycountrydream.components.Constants.KILO;
import static maidez.practices.familycountrydream.components.Constants.MILLION;
import static maidez.practices.familycountrydream.components.Constants.TRILLION;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class NumberUtils {
    public static String format(double number) {
        if (number >= Constants.TRILLION) {
            return number / TRILLION + "T";
        } else if (number >= BILLION) {
            return number / BILLION + "B";
        } else if (number >= MILLION) {
            return number / MILLION + "M";
        } else if (number >= KILO) {
            return number / KILO + "K";
        }
        return "" + number;
    }
}
