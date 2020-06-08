package maidez.practices.algorithm.leetcode.validpalindrome;

public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        return validPalindromeHelper(s, 1);
    }

    public static boolean validPalindromeHelper(String s, int maxSkipTime) {
        int i = 0;
        int j = s.length() - 1;
        int skipTime = 0;
        while (i != j && i != j - 1) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i + 1) != s.charAt(j) && s.charAt(i) != s.charAt(j - 1)) {
                    return false;
                }
                if (s.charAt(i + 1) == s.charAt(j) && s.charAt(i) == s.charAt(j - 1)) {
                    if (validPalindromeHelper(s.substring(i, j), maxSkipTime - 1)) {
                        if (skipTime > maxSkipTime - 1) {
                            return false;
                        }
                        j--;
                        skipTime++;
                        continue;
                    }
                    if (validPalindromeHelper(s.substring(i + 1, j + 1), maxSkipTime - 1)) {
                        if (skipTime > maxSkipTime - 1) {
                            return false;
                        }
                        i++;
                        skipTime++;
                        continue;
                    }
                }
                if (s.charAt(i + 1) == s.charAt(j) && s.charAt(i) != s.charAt(j - 1)) {
                    if (skipTime > maxSkipTime - 1) {
                        return false;
                    }
                    i++;
                    skipTime++;
                    continue;
                }
                if (s.charAt(i + 1) != s.charAt(j) && s.charAt(i) == s.charAt(j - 1)) {
                    if (skipTime > maxSkipTime - 1) {
                        return false;
                    }
                    j--;
                    skipTime++;
                    continue;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("ngzodrdohhqilovouwqrbpgqvlplsnfzueemmjtqnizodigfzeuuezfgidozinqtjmmeeuzfnslpvqgpbrqwuovoliqhhodirdozgn");
        System.out.println(new StringBuilder("ngzodrdohhqilovouwqrbpgqvlplsnfzueemmjtqnizodigfzeuuezfgidozinqtjmmeeuzfnslpvqgpbrqwuovoliqhhodirdozgn").reverse().toString());
    }

}
