package maidez.practices.leetcode.getpermutation;

import java.util.HashSet;
import java.util.Set;

public class GetPermutation {
    private static final int[] P = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320};

    public String getPermutation(int n, int k) {
        Set<Integer> used = new HashSet<>();
        int[] number = new int[n];
        for (int number_i = 0; number_i < number.length; number_i++) {
            int nNumberLeft = number.length - number_i;
            for (int i = 0; i < nNumberLeft; i++) {
                if (i * P[nNumberLeft - 1] < k && k <= (i + 1) * P[nNumberLeft - 1]) {
                    number[number_i] = findKth(n, used, i + 1);
                    k -= i * P[nNumberLeft - 1];
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : number) {
            sb.append(i);
        }
        return sb.toString();
    }

    private int findKth(int n, Set<Integer> used, int k) {
        int tmp = 1;
        for (int i = 1; i <= n; i++) {
            if (used.contains(i)) {
                continue;
            }
            if (tmp == k) {
                used.add(i);
                return i;
            }
            tmp++;
        }
        return -1;
    }

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
//        System.out.println(getPermutation.getPermutation(4, 9));
        System.out.println(getPermutation.getPermutation(8, 31492));
    }
}
