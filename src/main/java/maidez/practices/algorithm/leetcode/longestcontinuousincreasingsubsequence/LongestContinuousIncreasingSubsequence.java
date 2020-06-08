package maidez.practices.algorithm.leetcode.longestcontinuousincreasingsubsequence;

public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                if(currentLength > maxLength){
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }
        return Math.max(currentLength, maxLength);
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }
}
