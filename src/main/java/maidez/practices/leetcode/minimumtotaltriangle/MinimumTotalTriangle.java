package maidez.practices.leetcode.minimumtotaltriangle;

import com.google.common.collect.Lists;

import java.util.List;

public class MinimumTotalTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int[] minPath = new int[triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == triangle.size() - 1) {
                    minPath[j] = triangle.get(i).get(j);
                } else {
                    minPath[j] = Math.min(minPath[j], minPath[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return minPath[0];
    }

    public static void main(String[] args) {
        MinimumTotalTriangle minimumTotalTriangle = new MinimumTotalTriangle();
        minimumTotalTriangle.minimumTotal(Lists.newArrayList(
                Lists.newArrayList(2),
                Lists.newArrayList(3, 4),
                Lists.newArrayList(6, 5, 7),
                Lists.newArrayList(4, 1, 8, 3)
        ));
    }
}
