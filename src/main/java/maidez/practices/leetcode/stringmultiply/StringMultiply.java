package maidez.practices.leetcode.stringmultiply;

public class StringMultiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];
        for (int i2 = num2.length() - 1; i2 >= 0; i2--) {
            int offset2 = num2.length() - i2 - 1;
            int n2 = num2.charAt(i2) - '0';
            for (int i1 = num1.length() - 1; i1 >= 0; i1--) {
                int offset1 = num1.length() - i1 - 1;
                int n1 = num1.charAt(i1) - '0';
                result[offset1 + offset2] += n1 * n2;
            }
        }

        for (int i1 = 0; i1 < result.length; i1++) {
            if(result[i1] > 9) {
                result[i1 + 1] = result[i1] / 10;
                result[i1] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int length = result.length - 1; length >= 0; length--) {
            if (sb.length() == 0 && result[length] == 0) {
                continue;
            }
            sb.append(result[length]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringMultiply stringMultiply = new StringMultiply();
        System.out.println(stringMultiply.multiply("999", "999"));
        System.out.println(stringMultiply.multiply("2262293577402756", "4496246430"));
    }
}
