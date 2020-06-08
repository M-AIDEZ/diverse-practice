package maidez.practices.algorithm.leetcode.searchinrotatedsortedarray;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int twistedPoint = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                twistedPoint = i + 1;
                break;
            }
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int twistedMid = (mid + twistedPoint) % nums.length;
            if (nums[twistedMid] == target) {
                return twistedMid;
            }
            if (nums[twistedMid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        searchInRotatedSortedArray.search(new int[]{7, 8, 9, 0, 1, 2, 3, 4, 5, 6}, 6);
    }


}
