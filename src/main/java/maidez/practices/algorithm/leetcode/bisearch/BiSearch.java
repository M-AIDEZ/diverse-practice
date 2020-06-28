package maidez.practices.algorithm.leetcode.bisearch;

public class BiSearch {
    public static void main(String[] args) {
        BiSearch biSearch = new BiSearch();
        biSearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
