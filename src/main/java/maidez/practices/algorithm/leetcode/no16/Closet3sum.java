package maidez.practices.algorithm.leetcode.no16;

import java.util.Arrays;

public class Closet3sum {
    public static void main(String[] args) {
        Closet3sum closet3Sum = new Closet3sum();
        closet3Sum.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = 0;
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tmpSum = nums[i] + nums[l] + nums[r];
                int tmpDelta = Math.abs(tmpSum - target);
                if (tmpDelta < delta) {
                    if (tmpDelta == 0) return tmpSum;
                    closet = tmpSum;
                    delta = tmpDelta;
                }
                if (tmpSum < target)
                    l++;
                else
                    r--;
            }
        }
        return closet;
    }
}
