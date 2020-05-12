package maidez.practices.leetcode.numberofwaystostayinthesameplaceaftersomesteps;

import java.util.Arrays;

//https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static int numWays(int steps, int arrLen) {
        long[][] iStepjLocation = new long[steps + 1][arrLen];
        iStepjLocation[0][0] = 1;
//        iStepjLocation[0][1] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < arrLen; j++) {
                iStepjLocation[i][j] = (j == 0 ? 0 : iStepjLocation[i - 1][j - 1])
                        + iStepjLocation[i - 1][j]
                        + (j == arrLen - 1 ? 0 : iStepjLocation[i - 1][j + 1]);
                iStepjLocation[i][j] %= 1000000007;
            }
        }
        return (int) (iStepjLocation[steps][0] % 1000000007);
    }

    public static int numWays2(int steps, int arrLen) {
        int mod = 1_000_000_000 + 7;
        int[] dp = new int[steps + 1];
        dp[0] = 1;
        for (int i = 0; i < steps; i++) {
            int[] ndp = new int[steps + 1];
            for (int j = 0; j < arrLen; j++) {
                ndp[j] += dp[j];
                ndp[j] %= mod;
                if (j - 1 >= 0) {
                    ndp[j] += dp[j - 1];
                    ndp[j] %= mod;
                }
                if (j + 1 < arrLen) {
                    ndp[j] += dp[j + 1];
                    ndp[j] %= mod;
                }
            }
            dp = Arrays.copyOf(ndp, ndp.length);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numWays(47, 38));
        System.out.println(numWays2(47, 38));
    }
}
