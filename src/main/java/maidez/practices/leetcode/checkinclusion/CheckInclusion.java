package maidez.practices.leetcode.checkinclusion;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a']++;
        }
        int start = 0, end = 0, cnt = s1.length();
        while (end < s2.length()) {
            cnt--;
            if (--s1Chars[s2.charAt(end) - 'a'] < 0) {
                while (s1Chars[s2.charAt(end) - 'a'] < 0) {
                    s1Chars[s2.charAt(start++) - 'a']++;
                    cnt++;
                }
            } else if (cnt == 0) {
                return true;
            }
            end++;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("adc", "dadc"));
    }
}
