package maidez.practices.leetcode.generateparenthesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n > 0) generateParenthesis(result, "", n, n);
        return result;

    }

    private void generateParenthesis(List<String> result, String s, int open, int close) {
        if (open == 0 && close == 1) {
            result.add(s + ")");
        } else if (open == close) {
            generateParenthesis(result, s + "(", open - 1, close);
        } else {
            if (open > 0)
                generateParenthesis(result, s + "(", open - 1, close);
            generateParenthesis(result, s + ")", open, close - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(1);
    }
}
