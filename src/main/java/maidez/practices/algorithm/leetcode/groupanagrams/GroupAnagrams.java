package maidez.practices.algorithm.leetcode.groupanagrams;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] charCnt = new int[26];
        for(int i = 0; i < strs.length; i++ ) {
            Arrays.fill(charCnt, 0);
            for (char c : strs[i].toCharArray()) {
                charCnt[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < 26; i++) {
                sb.append('#');
                sb.append(charCnt[j]);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
