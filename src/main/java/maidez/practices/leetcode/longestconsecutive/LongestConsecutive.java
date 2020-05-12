package maidez.practices.leetcode.longestconsecutive;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int max = -1;
        int tmp = 1;
        for (int num : nums) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            while (numSet.contains(num + 1)) {
                tmp++;
                num++;
            }
            max = Math.max(max, tmp);
            tmp = 1;
        }
        return max;
    }
}
