package maidez.practices.leetcode.simplepatternmatch;

import com.google.common.collect.Lists;

import java.util.List;

// 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
// 说明:
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/regular-expression-matching
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SimplePatternMatch {
    public static boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null;
        }
        if (s == null) {
            s = "";
        }
        int pIndex = 0;
        List<String> pChars = splitPattern(p);
        int prevMatchMoreIndex = -1;
        int prevMatchMoreConsumeEnd = -1;
        for (int i = 0; i < s.length(); ) {
            if (pIndex == pChars.size()) {
                if (prevMatchMoreIndex == -1) {
                    return false;
                }
                pIndex = prevMatchMoreIndex;
                i = prevMatchMoreConsumeEnd;
                continue;
            }
            String pChar = pChars.get(pIndex);
            if (isMatchMore(pChar)) {
                if (pIndex != prevMatchMoreIndex) {
                    prevMatchMoreIndex = pIndex;
                    prevMatchMoreConsumeEnd = i;
                    pIndex++;
                } else {
                    if (isCharMatch(s.charAt(i), pChar)) {
                        prevMatchMoreConsumeEnd = i + 1;
                        i++;
                        pIndex++;
                    } else {
                        return false;
                    }
                }
            } else {
                if (isCharMatch(s.charAt(i), pChar)) {
                    prevMatchMoreConsumeEnd = i + 1;
                    i++;
                    pIndex++;
                } else {
                    if (prevMatchMoreIndex == -1) {
                        return false;
                    }
                    pIndex = prevMatchMoreIndex;
                    i = prevMatchMoreConsumeEnd;
                }
            }
        }
        return pIndex == pChars.size();
    }

    private static boolean isCharMatch(char s, String p) {
        char c = p.charAt(0);
        return s == c || c == '.';
    }

    private static boolean isMatchMore(String p) {
        return p.length() > 1;
    }

    private static int findLastMatchModeIndexBefore(List<String> pChars, int index) {
        for (int i = index - 1; i > 0; i--) {
            if (isMatchMore(pChars.get(i))) {
                return i;
            }
        }
        return index;
    }

    private static List<String> splitPattern(String p) {
        List<String> ps = Lists.newArrayList();
        for (int i = 0; i < p.length(); i++) {
            if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                ps.add(p.substring(i, i + 2));
                i++;
            } else {
                ps.add(p.substring(i, i + 1));
            }
        }
        return ps;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }

}
