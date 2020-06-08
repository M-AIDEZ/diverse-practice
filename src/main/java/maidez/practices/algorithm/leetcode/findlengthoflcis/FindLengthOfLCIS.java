package maidez.practices.algorithm.leetcode.findlengthoflcis;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int tmp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                tmp++;
            } else {
                max = Math.max(max, tmp);
                tmp = 1;
            }
        }
        max = Math.max(max, tmp);
        return max;
    }
}
