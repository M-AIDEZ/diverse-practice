package maidez.practices.calculator;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import maidez.practices.utils.BigDecimalUtils;
import maidez.practices.utils.NumberUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by luwenyi on 2018/6/13.
 */
public class RpnCalculator {
    public static BigDecimal calculate(List<String> rpn, Map<String, Object> valueMap) {
        Stack<String> tempStack = new Stack<>();
        for (String token : rpn) {
            String str1;
            BigDecimal decimal1;
            Boolean boolean1;
            String str2;
            BigDecimal decimal2;
            Boolean boolean2;
            switch (token) {
                case "+":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push((decimal1 == null ? BigDecimal.ZERO : decimal1).add(decimal2 == null ? BigDecimal.ZERO : decimal2).toPlainString());
                    break;
                case "-":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push((decimal1 == null ? BigDecimal.ZERO : decimal1).subtract(decimal2 == null ? BigDecimal.ZERO : decimal2).toPlainString());
                    break;
                case "*":
                    str2 = tempStack.pop();
                    str1 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    if (decimal1 == null || decimal2 == null) {
                        return null;
                    } else {
                        tempStack.push(decimal1.multiply(decimal2).toPlainString());
                    }
                    break;
                case "/":
                    str2 = tempStack.pop();
                    str1 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    if (decimal1 == null || decimal2 == null || decimal2.compareTo(BigDecimal.ZERO) == 0) {
                        return null;
                    } else {
                        tempStack.push(decimal1.divide(decimal2, 4, BigDecimal.ROUND_HALF_UP).toPlainString());
                    }
                    break;
                case "==":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push(getBooleanStr(decimal1.compareTo(decimal2) == 0));
                    break;
                case ">":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push(getBooleanStr(decimal1.compareTo(decimal2) > 0));
                    break;
                case ">=":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push(getBooleanStr(decimal1.compareTo(decimal2) >= 0));
                    break;
                case "<":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push(getBooleanStr(decimal1.compareTo(decimal2) < 0));
                    break;
                case "<=":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push(getBooleanStr(decimal1.compareTo(decimal2) <= 0));
                    break;
                case "&&":
                    boolean2 = Boolean.valueOf(tempStack.pop());
                    boolean1 = Boolean.valueOf(tempStack.pop());
                    tempStack.push(getBooleanStr(boolean1 && boolean2));
                    break;
                case "||":
                    boolean2 = Boolean.valueOf(tempStack.pop());
                    boolean1 = Boolean.valueOf(tempStack.pop());
                    tempStack.push(getBooleanStr(boolean1 || boolean2));
                    break;
                case "?:":
                    str2 = tempStack.pop();
                    decimal2 = NumberUtils.isNumber(str2) ? new BigDecimal(str2) : BigDecimalUtils.valueOf(valueMap.get(str2));
                    str1 = tempStack.pop();
                    Boolean b = Boolean.valueOf(tempStack.pop());
                    decimal1 = NumberUtils.isNumber(str1) ? new BigDecimal(str1) : BigDecimalUtils.valueOf(valueMap.get(str1));
                    tempStack.push((b ? decimal1 : decimal2).toPlainString());
                    break;
                default:
                    tempStack.push(token);
            }
        }
        String result = tempStack.pop();
        return NumberUtils.isNumber(result) ? new BigDecimal(result) : BigDecimalUtils.valueOf(valueMap.get(result));
    }

    private static String getBooleanStr(boolean b) {
        return b ? "true" : "false";
    }

    public static void main(String[] args) {
        Map<String, Object> valueMap = Maps.newHashMap();
        double a = 20;
        valueMap.put("a", new BigDecimal("20"));
        double b = 2.44;
        valueMap.put("b", new BigDecimal("2.44"));
        double c = 1.8;
        valueMap.put("c", new BigDecimal("1.8"));
//        valueMap.put("b", new BigDecimal("0.64"));
        double d = 0.4;
        valueMap.put("d", new BigDecimal("0.4"));
        double e = 0.15;
        valueMap.put("e", new BigDecimal("0.15"));
        double f = 0.8;
        valueMap.put("f", new BigDecimal("0.8"));
        Set<String> fieldSet = Sets.newHashSet();
        System.out.println(calculate(Rpnizer.rpnize(Tokenizer.tokenize("a * ((b - c) / d + e)", fieldSet)), valueMap));
        System.out.println(a * ((b - c) / d + e));
        System.out.println(calculate(Rpnizer.rpnize(Tokenizer.tokenize("a < b ? b < c ? b : c : a", fieldSet)), valueMap));
        System.out.println(a < b ? b < c ? b : c : a);
        System.out.println(calculate(Rpnizer.rpnize(Tokenizer.tokenize("a < b ? a : b < c ? b : c", fieldSet)), valueMap));
        System.out.println(a < b ? a : b < c ? b : c);
        System.out.println(calculate(Rpnizer.rpnize(Tokenizer.tokenize("a < b ? c < d ? c : d : e < f ? e : f", fieldSet)), valueMap));
        System.out.println(a < b ? c < d ? c : d : e < f ? e : f);
        System.out.println(calculate(Rpnizer.rpnize(Tokenizer.tokenize("( a + 1 ) > b ? ( 1 + 2 ) / 2 : b ", fieldSet)), valueMap));
        System.out.println((a + 1D) > b ? (1D + 2D) / 2D : b);
        System.out.println(calculate(Rpnizer.rpnize(Tokenizer.tokenize("( ( a + 1 ) > b ? ( 1 + 2 ) / 2 : b ) + 1", fieldSet)), valueMap));
        System.out.println(((a + 1D) > b ? (1D + 2D) / 2D : b) + 1D);
        System.out.println(fieldSet);
    }
}
