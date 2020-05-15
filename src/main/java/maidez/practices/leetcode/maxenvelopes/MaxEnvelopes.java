package maidez.practices.leetcode.maxenvelopes;

import java.util.Arrays;

public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        if (envelopes.length == 1) return 1;

        Arrays.sort(envelopes, (o1, o2) -> {
            int compare = Integer.compare(o1[0], o2[0]);
            if (compare != 0) {
                return compare;
            }
            return Integer.compare(o2[1], o1[1]);
        });

        int length = 1;
        int[] minOfLengthN = new int[envelopes.length];
        minOfLengthN[0] = envelopes[0][1];
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > minOfLengthN[length - 1]) {
                minOfLengthN[length++] = envelopes[i][1];
            } else {
                replaceFirstLE(envelopes[i][1], length - 1, minOfLengthN);
            }
        }
        return length;
    }

    private void replaceFirstLE(int i, int length, int[] minOfLengthN) {
        int l = 0;
        int r = length;
        int res = length + 1; //也可以定义为 R，区别在于整个数组均比k小的返回值
        while (l <= r) {
            int mid = (l + r) / 2; //避免溢出
            if (minOfLengthN[mid] >= i) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        if (res <= length) {
            minOfLengthN[res] = i;
        }
    }


    public static void main(String[] args) {
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        maxEnvelopes.maxEnvelopes(new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}});
    }
}
