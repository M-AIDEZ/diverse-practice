package maidez.practices.calculator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import maidez.practices.utils.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by luwenyi on 2018/6/13.
 */
public class Tokenizer {
    private static final List<Character> OPERATORS = Lists.newArrayList('(', ')', '+', '-', '*', '/', '?', ':');

    private static final List<String> LOGICAL_OPERATORS = Lists.newArrayList("==", ">", ">=", "<", "<=", "&&", "||");

    /**
     * 默认表达式合法，后续修改
     *
     * @param expr
     * @param dependOnFields
     * @return
     */
    public static List<String> tokenize(String expr, Set<String> dependOnFields) {
        List<String> tokens = Lists.newArrayList();
        //替换所有空格
        expr = expr.replaceAll(" ", "");

        StringBuilder tokenBuilder = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            /*匹配操作数*/
            if (isOperand(expr, i)) {
                tokenBuilder.append(expr.charAt(i));
                continue;
            }
            addToken(dependOnFields, tokens, tokenBuilder);
            tokenBuilder = new StringBuilder();
            /*匹配方法*/
            if (expr.charAt(i) == '.') {
                tokenBuilder.append(expr.charAt(i));
                continue;
            }
            /*匹配操作符*/
            if (OPERATORS.contains(expr.charAt(i))) {
                tokens.add(String.valueOf(expr.charAt(i)));
                continue;
            }
            /*匹配2个字符长逻辑运算符*/
            char[] chars = {expr.charAt(i), expr.charAt(i + 1)};
            String twoCharOperator = String.valueOf(chars);
            if (LOGICAL_OPERATORS.contains(twoCharOperator)) {
                tokens.add(twoCharOperator);
                i++;
                continue;
            }
            /*匹配单个字符长逻辑运算符*/
            if (LOGICAL_OPERATORS.contains(String.valueOf(expr.charAt(i)))) {
                tokens.add(String.valueOf(expr.charAt(i)));
                continue;
            }
            /*匹配字符串*/
            if (expr.charAt(i) == '"') {
                try {
                    tokenBuilder.append(expr.charAt(i));
                    while (expr.charAt(++i) != '"') {
                        tokenBuilder.append(expr.charAt(i));
                    }
                    tokenBuilder.append(expr.charAt(i));
                    continue;
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException("Unterminated String In Expr " + expr);
                }
            }
            throw new RuntimeException("Unexpected character At Position " + i);
        }
        addToken(dependOnFields, tokens, tokenBuilder);
        tokens.add("#");
        return tokens;
    }

    /**
     * 是否是操作数
     *
     * @param expr
     * @param i
     * @return
     */
    private static boolean isOperand(String expr, int i) {
        return expr.charAt(i) == '_'
                || (expr.charAt(i) >= 'a' && expr.charAt(i) <= 'z')
                || (expr.charAt(i) >= 'A' && expr.charAt(i) <= 'Z')
                || (expr.charAt(i) >= '0' && expr.charAt(i) <= '9');
    }


    private static void addToken(Set<String> fieldSet, List<String> tokens, StringBuilder tokenBuilder) {
        if (tokenBuilder.length() != 0) {
            String token = tokenBuilder.toString();
            tokens.add(token);
            if (isField(token)) {
                fieldSet.add(token);
            }
        }
    }

    private static boolean isField(String token){
        return !NumberUtils.isNumber(token)
                && !"now".equals(token)
                && !StringUtils.startsWithIgnoreCase(token, ".")
                && !StringUtils.startsWithIgnoreCase(token, "\"");
    }


    public static void main(String[] args) {
        Set<String> fieldSet = Sets.newHashSet();

        System.out.println(tokenize("a > b ? ( 1 + 2 )/ 2 : b ", fieldSet));
        System.out.println(fieldSet);
        fieldSet.clear();
        System.out.println(tokenize("a < b ? a : b < c ? b : c", fieldSet));
        System.out.println(fieldSet);
        fieldSet.clear();

        System.out.println(tokenize("now.plusDay(1).plusMonth(1).year / now.monthEnd.month", fieldSet));
        System.out.println(fieldSet);
        fieldSet.clear();

        System.out.println(tokenize("now.plusDay(1).plusMonth(1).toString(\"yyyy-MM-dd\")", fieldSet));
        System.out.println(fieldSet);
        fieldSet.clear();
    }
}
