package maidez.practices.utils;

import java.math.BigDecimal;

/**
 * Created by luwenyi on 2018/6/14.
 */
public class BigDecimalUtils {

    public static BigDecimal valueOf(Object o) {
        if (o instanceof Number) {
            return new BigDecimal(String.valueOf(o));
        } else if (o instanceof String && NumberUtils.isNumber((String) o)) {
            return new BigDecimal((String) o);
        } else {
            return null;
        }
    }
}
