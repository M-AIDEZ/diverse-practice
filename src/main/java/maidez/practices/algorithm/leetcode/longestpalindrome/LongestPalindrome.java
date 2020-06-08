package maidez.practices.algorithm.leetcode.longestpalindrome;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        int[][] matrix = new int[s.length()][s.length()];
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                boolean match = false;
                if (l == 1) {
                    match = true;
                } else if (l == 2) {
                    match = s.charAt(i) == s.charAt(j);
                } else {
                    match = s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1] > 0;
                }
                if (match) {
                    matrix[i][j] = l;
                    if (l > max) {
                        maxI = i;
                        maxJ = j;
                        max = l;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        longestPalindrome.longestPalindrome("cbbdbabdac");
    }
}
