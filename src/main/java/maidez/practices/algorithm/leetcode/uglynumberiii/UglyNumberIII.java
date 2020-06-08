package maidez.practices.algorithm.leetcode.uglynumberiii;

//https://leetcode-cn.com/problems/ugly-number-iii/
public class UglyNumberIII {
    public static int nthUglyNumber(int n, int a, int b, int c) {
        int index = 1;
        int prev = 0;
        int[] abci = {1, 1, 1};
        while (index <= n) {
            int cmp = cmp(a, abci[0], b, abci[1], c, abci[2]);
            int cur = cmp == 0 ? a * abci[0] : cmp == 1 ? b * abci[1] : c * abci[2];
            if (prev != cur) {
                prev = cur;
                index++;
            }
            abci[cmp]++;
        }
        return prev;
    }

    private static int cmp(int a, int ai, int b, int bi, int c, int ci) {
        if (a * ai < b * bi) {
            return a * ai < c * ci ? 0 : 2;
        } else {
            return b * bi < c * ci ? 1 : 2;
        }
    }

    public static void main(String[] args) {
//        System.out.println(nthUglyNumber(5, 2, 11, 13));
        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }


}
