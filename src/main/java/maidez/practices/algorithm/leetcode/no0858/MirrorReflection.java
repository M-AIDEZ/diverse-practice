package maidez.practices.algorithm.leetcode.no0858;

public class MirrorReflection {
    public static void main(String[] args) {
        MirrorReflection mirrorReflection = new MirrorReflection();
        System.out.println(mirrorReflection.mirrorReflection(4, 4));
        System.out.println(mirrorReflection.mirrorReflection(4, 3));
    }

    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        return (q / gcd) % 2 == 0 ? 0 : (p / gcd) % 2 == 0 ? 2 : 1;
    }

    private int gcd(int a, int b) {
        int temp;
        if (a < b) {
            a += b;
            b -= a;
            a -= b;
        }
        while ((temp = a % b) != 0) {
            a = b;
            b = temp;
        }
        return b;
    }

}
