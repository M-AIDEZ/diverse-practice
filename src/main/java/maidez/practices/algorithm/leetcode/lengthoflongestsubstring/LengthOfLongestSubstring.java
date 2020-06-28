package maidez.practices.algorithm.leetcode.lengthoflongestsubstring;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lolss = new LengthOfLongestSubstring();
        System.out.println(lolss.lengthOfLongestSubstring("aaaaa"));
        System.out.println(lolss.lengthOfLongestSubstring("abaab"));
        System.out.println(lolss.lengthOfLongestSubstring("abcab"));
        System.out.println(lolss.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lolss.lengthOfLongestSubstring("abcabcbb"));

    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        Map<Character, Integer> characterLastPosition = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!characterLastPosition.containsKey(c) || i - characterLastPosition.get(c) > currentLength) {
                currentLength++;
            } else {
                currentLength = i - characterLastPosition.get(c);
            }
            characterLastPosition.put(c, i);
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
