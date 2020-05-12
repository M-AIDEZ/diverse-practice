package maidez.practices.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Draft {
    public static void main(String[] args) {
        grayCode(3);
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> grayCodes = new ArrayList<>();
        grayCodes.add(0);
        if (n == 0) {
            return grayCodes;
        }
        grayCodes.add(1);
        if (n == 1) {
            return grayCodes;
        }
        int offset = 0x1;
        while (n > 1) {
            offset <<= 1;
            int size = grayCodes.size();
            for (int i = size - 1; i >= 0; i--) {
                grayCodes.add(grayCodes.get(i) + offset);
            }
            n--;
        }
        return grayCodes;
    }
}
