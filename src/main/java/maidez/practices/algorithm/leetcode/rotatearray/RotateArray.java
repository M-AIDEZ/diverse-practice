package maidez.practices.algorithm.leetcode.rotatearray;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1) return;
        k %= nums.length;
        if (k == 0) return;

        int loops = nums.length / k * k == nums.length ? k : 1;
        while (loops > 0) {
            int i = nums.length - loops;
            int tmp = nums[i];
            int cp = i >= k ? i - k : i + nums.length - k;
            while (cp != nums.length - loops) {
                nums[i] = nums[cp];
                i = cp;
                cp = i >= k ? i - k : i + nums.length - k;
            }
            nums[i] = tmp;
            loops--;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
