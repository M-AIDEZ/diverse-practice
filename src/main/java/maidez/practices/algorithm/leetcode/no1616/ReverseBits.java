package maidez.practices.algorithm.leetcode.no1616;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(1775));
        System.out.println(reverseBits.reverseBits(4));
    }

    public int reverseBits(int num) {
        int maxLength = 1;
        int lastLength = 0;
        int currentLength = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((num & mask) == mask)
                currentLength++;
            else {
                maxLength = Math.max(maxLength, lastLength + currentLength + 1);
                lastLength = currentLength;
                currentLength = 0;
            }
            mask <<= 1;
        }
        if (currentLength > 0) {
            maxLength = Math.max(maxLength, lastLength + currentLength + 1);
        }
        return Math.min(32, maxLength);
    }
}
