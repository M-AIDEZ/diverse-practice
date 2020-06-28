package maidez.practices.calculator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created by luwenyi on 2018/6/13.
 * Reverse Polish Notation
 */
public class Rpnizer {
    private static Map<String, Integer> operatorPriorityMap = new HashMap<String, Integer>() {{
        put("(", 7);
        put("?", 6);
        put(":", 5);
        put("?:", 4);
        put("&&", 3);
        put("||", 3);
        put("==", 2);
        put(">", 2);
        put(">=", 2);
        put("<", 2);
        put("<=", 2);
        put("+", 1);
        put("-", 1);
        put("*", 0);
        put("/", 0);
    }};

    private static boolean needPop(String peek, String cur) {
        return !("?:".equals(peek) && "?".equals(cur))
                && !(("?".equals(peek) && "?".equals(cur)) || ("?:".equals(peek) && "?:".equals(cur)))
                && operatorPriorityMap.get(peek) <= operatorPriorityMap.get(cur);
    }

    public static List<String> rpnize(List<String> tokens) {
        Stack<String> tempStack = new Stack<>();
        List<String> rpn = Lists.newArrayList();
        for (String token : tokens) {
            switch (token) {
                case "(":
                    tempStack.push(token);
                    break;
                case ")":
                    while (/*!tempStack.isEmpty() &&*/ !"(".equals(tempStack.peek())) {
                        rpn.add(tempStack.pop());
                    }
                    tempStack.pop();
                    break;
                case ":":
                    while (!tempStack.isEmpty() && needPop(tempStack.peek(), token)) {
                        rpn.add(tempStack.pop());
                    }
                    Stack<String> switchStack = new Stack<>();
                    while (/*!tempStack.isEmpty() &&*/!"?".equals(tempStack.peek())) {
                        switchStack.push(tempStack.pop());
                    }
                    tempStack.pop();
                    tempStack.push("?:");
                    while (!switchStack.isEmpty()) {
                        tempStack.push(switchStack.pop());
                    }
                    break;
                case "?":
                case "&&":
                case "||":
                case "==":
                case ">":
                case ">=":
                case "<":
                case "<=":
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!tempStack.isEmpty() && needPop(tempStack.peek(), token)) {
                        rpn.add(tempStack.pop());
                    }
                    tempStack.push(token);
                    break;
                case "#":
                    while (!tempStack.isEmpty()) {
                        rpn.add(tempStack.pop());
                    }
                    break;
                default:
                    rpn.add(token);
            }
        }
        return rpn;
    }

    public static void main(String[] args) {

        Set<String> fieldSet = Sets.newHashSet();

//        System.out.println(rpnize(Tokenizer.tokenize("20*((2.44-1.8)/0.4+0.15)", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("20 * (2.44 + 1.8 / (0.4 - 0.15))", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("20 * 19 / 18", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("a > b ? a : b ", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("(a + 1) > b ? ( 1 + 2 )/ 2 : b ", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("((a + 1) > b ? ( 1 + 2 )/ 2 : b)+1", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("a < b ? b < c ? b : c : a", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("a < b ? a : b < c ? b : c", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();
//        System.out.println(rpnize(Tokenizer.tokenize("a < b ? c < d ? c : d : e < f ? e : f", fieldSet)));
//        System.out.println(fieldSet);
//        fieldSet.clear();

        System.out.println(rpnize(Tokenizer.tokenize("now.plusDay(1).plusMonth(1).year / now.monthEnd.month", fieldSet)));
        System.out.println(fieldSet);
        fieldSet.clear();

        System.out.println(rpnize(Tokenizer.tokenize("now.plusDay(1).plusMonth(1).toString(\"yyyy-MM-dd\")", fieldSet)));
        System.out.println(fieldSet);
        fieldSet.clear();
    }
}
