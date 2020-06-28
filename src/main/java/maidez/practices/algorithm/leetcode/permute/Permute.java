package maidez.practices.algorithm.leetcode.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        permute.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 0) permute(result, new int[nums.length], 0, nums, new boolean[nums.length]);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] p, int i, int[] nums, boolean[] taken) {
        for (int numI = 0; numI < nums.length; numI++) {
            if (taken[numI]) continue;
            if (i == p.length - 1) {
                p[i] = nums[numI];
                List<Integer> res = new ArrayList<>();
                for (int pInt : p) {
                    res.add(pInt);
                }
                result.add(res);
            } else {
                boolean[] newTaken = Arrays.copyOf(taken, taken.length);
                newTaken[numI] = true;
                int[] newP = Arrays.copyOf(p, taken.length);
                newP[i] = nums[numI];
                permute(result, newP, i + 1, nums, newTaken);
            }
        }
    }
}
