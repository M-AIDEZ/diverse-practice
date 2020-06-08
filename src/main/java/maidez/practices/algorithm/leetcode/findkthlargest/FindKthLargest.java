package maidez.practices.algorithm.leetcode.findkthlargest;

import java.util.Random;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int sorted = sort(left, right, nums);
        while (sorted != k) {
            if (sorted > k) {
                right = sorted - 2;
            } else {
                left = sorted;
            }
            sorted = sort(left, right, nums);
        }
        return nums[k - 1];

    }

    private int sort(int left, int right, int[] nums) {
        if(left != right) {
            Random random_num = new Random();
            swap(nums, left + random_num.nextInt(right - left), left);
        }
        int position = left;
        int lastPosition = position;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[lastPosition]) {
                swap(nums, position, i);
                if (position == lastPosition) {
                    lastPosition = i;
                }
                position++;
            }
        }
        swap(nums, position, lastPosition);
        return position + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
//        findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9);
//        findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
//        findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
//        findKthLargest.findKthLargest(new int[]{2, 1}, 2);
        findKthLargest.findKthLargest(new int[]{1}, 1);
    }
}
