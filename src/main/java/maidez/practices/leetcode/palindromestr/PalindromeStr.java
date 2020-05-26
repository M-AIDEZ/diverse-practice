package maidez.practices.leetcode.palindromestr;

public class PalindromeStr {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            char lc = s.charAt(l);
            while((lc < 'a' || lc > 'z') && l < r) {
                l++;
                lc = s.charAt(l);
            }
            char rc = s.charAt(r);
            while((rc < 'a' || rc > 'z') && l < r) {
                r--;
                rc = s.charAt(r);
            }
            if(l > r || lc != rc) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeStr palindromeStr = new PalindromeStr();
//        palindromeStr.isPalindrome("A man, a plan, a canal: Panama");
//        palindromeStr.isPalindrome("race a car");
        palindromeStr.isPalindrome("0P");
    }
}
