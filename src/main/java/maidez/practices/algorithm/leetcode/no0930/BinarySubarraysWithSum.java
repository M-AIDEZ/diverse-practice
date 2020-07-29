package maidez.practices.algorithm.leetcode.no0930;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] before = new int[A.length];
        int[] after = new int[A.length];
        int lastOne = -1;
        int zeroCnt = 1;
        int start = -1;
        int end = -1;
        int tmpSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                if (tmpSum == 0) start = i;
                if (++tmpSum == S) end = i;
                before[i] = zeroCnt;
                if (lastOne != -1) after[lastOne] = zeroCnt;
                if (i == A.length - 1) after[i] = 1;
                lastOne = i;
                zeroCnt = 1;
            } else {
                zeroCnt++;
                if (i == A.length - 1) {
                    before[i] = zeroCnt;
                    if (lastOne != -1)
                        after[lastOne] = zeroCnt;
                }
            }
        }
        int cnt = 0;
        if (S == 0) {
            for (int beforeCnt : before) {
                if (beforeCnt - 1 > 0) cnt += (beforeCnt - 1) * beforeCnt / 2;
            }
        } else {
            while (start != -1 && end != -1 && end < A.length) {
                cnt += before[start] * after[end];
                do {
                    start++;
                } while (start < A.length && A[start] != 1);
                do {
                    end++;
                } while (end < A.length && A[end] != 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum binarySubarraysWithSum = new BinarySubarraysWithSum();
//        binarySubarraysWithSum.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2);
        binarySubarraysWithSum.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);
        binarySubarraysWithSum.numSubarraysWithSum(new int[]{0, 0, 0, 1, 0, 0}, 0);
    }

}
