package maidez.practices.algorithm.leetcode.traprain;

public class TrapRain {
    public static void main(String[] args) {
        TrapRain trapRain = new TrapRain();
        trapRain.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        int prevLeftMax = 0;
        int[] leftMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i > 0) {
                prevLeftMax = Math.max(prevLeftMax, height[i - 1]);
            }
            leftMax[i] = prevLeftMax;
        }
        int water = 0;
        int prevRightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i < height.length - 1) {
                prevRightMax = Math.max(prevRightMax, height[i + 1]);
            }
            water += Math.max(Math.min(leftMax[i], prevRightMax) - height[i], 0);
        }
        return water;
    }
}
