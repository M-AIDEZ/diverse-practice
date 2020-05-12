package maidez.practices.leetcode.longestcommonprefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{"a", "ab"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"aaa", "aa", ""}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"baac", "acb", "bacc", "cb"}));
    }
}
