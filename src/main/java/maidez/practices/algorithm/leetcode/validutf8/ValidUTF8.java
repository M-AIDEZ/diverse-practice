package maidez.practices.algorithm.leetcode.validutf8;

public class ValidUTF8 {
    public static void main(String[] args) {
        ValidUTF8 validUTF8 = new ValidUTF8();
        validUTF8.validUtf8(new int[]{197, 130, 1});
    }

    public boolean isUtf8(int start, int length, int[] data) {
        if (length == 0 || length > 4) return false;
        if (length == 1) {
            return data[start] < 0b10000000;
        } else if (length == 2) {
            return data[start] >= 0b11000000 && data[start] <= 0b11011111
                    && data[start + 1] >= 0b10000000 && data[start + 1] <= 0b10111111;
        } else if (length == 3) {
            return data[start] >= 0b11100000 && data[start] <= 0b11101111
                    && data[start + 1] >= 0b10000000 && data[start + 1] <= 0b10111111
                    && data[start + 2] >= 0b10000000 && data[start + 2] <= 0b10111111;
        } else {
            return data[start] >= 0b11110000 && data[start] <= 0b11110111
                    && data[start + 1] >= 0b10000000 && data[start + 1] <= 0b10111111
                    && data[start + 2] >= 0b10000000 && data[start + 2] <= 0b10111111
                    && data[start + 3] >= 0b10000000 && data[start + 3] <= 0b10111111;
        }
    }

    private boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int nextByteLength;
            if (data[i] < 0b10000000) {
                nextByteLength = 1;
            } else if (data[i] <= 0b11011111 && data[i] >= 0b11000000) {
                nextByteLength = 2;
            } else if (data[i] <= 0b11101111 && data[i] >= 0b11100000) {
                nextByteLength = 3;
            } else if (data[i] <= 0b11110111 && data[i] >= 0b11110000) {
                nextByteLength = 4;
            } else {
                return false;
            }
            if (i + nextByteLength - 1 > data.length - 1) {
                return false;
            }
            if (isUtf8(i, nextByteLength, data)) {
                i += nextByteLength - 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
