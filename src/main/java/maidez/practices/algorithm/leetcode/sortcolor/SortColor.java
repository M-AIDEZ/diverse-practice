package maidez.practices.algorithm.leetcode.sortcolor;

public class SortColor {
    public void sortColors(int[] nums) {
        if (nums == null) return;
        int firstOne = -1;
        int firstTwo = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                if (firstTwo == -1)
                    firstTwo = i;
            } else if (nums[i] == 1) {
                if (firstTwo != -1) {
                    nums[firstTwo] = nums[i];
                    nums[i] = 2;
                    if (firstOne == -1) firstOne = firstTwo;
                    firstTwo++;
                }
                if (firstOne == -1)
                    firstOne = i;
            } else if (nums[i] == 0) {
                if (firstOne != -1) {
                    nums[firstOne++] = nums[i];
                    nums[i] = 1;
                }
                if (firstTwo != -1) {
                    nums[firstTwo++] = nums[i];
                    nums[i] = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortColor sortColor = new SortColor();
        int[] ints = {0, 0, 1, 1, 2, 0, 2, 2, 1, 0, 1, 1, 2, 2};
        sortColor.sortColors(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


}
