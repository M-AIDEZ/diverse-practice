package maidez.practices.algorithm.leetcode.no0991;

public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int cnt = 0;
        while (X != Y) {
            if (X > Y) {
                Y += 1;
            } else {
                if (Y % 2 == 1) {
                    Y += 1;
                } else {
                    Y /= 2;
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        BrokenCalculator brokenCalculator = new BrokenCalculator();
//        2
//        brokenCalculator.brokenCalc(2, 3);
//        2
//        brokenCalculator.brokenCalc(5, 8);
//        3
//        brokenCalculator.brokenCalc(3, 10);
//        1023
//        brokenCalculator.brokenCalc(1024, 1);
//        39
        brokenCalculator.brokenCalc(1, 1000000000);
    }
}
