package maidez.practices.leetcode.minimumtotaltriangle;

import com.google.common.collect.Lists;

import java.util.List;

public class MinimumTotalTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int[] prevMinPath = new int[triangle.size()];
        int[] minPath = new int[triangle.size()];
        Integer min = null;
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int curMin;
                if (i == 0) {
                    curMin = triangle.get(i).get(j);
                } else if (j == 0) {
                    curMin = prevMinPath[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    curMin = prevMinPath[j - 1] + triangle.get(i).get(j);
                } else {
                    curMin = Math.min(prevMinPath[j - 1], prevMinPath[j]) + triangle.get(i).get(j);
                }
                minPath[j] = curMin;
                if (i == triangle.size() - 1) {
                    min = min == null ? curMin : Math.min(min, curMin);
                }
            }
            System.arraycopy(minPath, 0, prevMinPath, 0, minPath.length);
        }
        return min;
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
