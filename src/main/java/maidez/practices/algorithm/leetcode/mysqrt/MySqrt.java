package maidez.practices.algorithm.leetcode.mysqrt;

public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(8));
        System.out.println(mySqrt.mySqrt(9));
        System.out.println(mySqrt.mySqrt(10));
    }

    public int mySqrt(int x) {
        double noise = 0.5;
        double sqrtVal = (double) x / 2;
        while (Math.abs(sqrtVal * sqrtVal - x) > noise) {
            sqrtVal = (sqrtVal + x / sqrtVal) / 2;
        }
        return (int) sqrtVal;
    }
}
