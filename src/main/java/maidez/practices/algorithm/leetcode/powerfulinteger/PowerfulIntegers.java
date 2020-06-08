package maidez.practices.algorithm.leetcode.powerfulinteger;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> resultSet = new HashSet<>();
        for (int a = 1; ; a *= x) {
            for (int b = 1; ; b *= y) {
                int result = a + b;
                if (result <= bound) {
                    resultSet.add(result);
                } else {
                    if (b == 1) {
                        return new ArrayList<>(resultSet);
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(powerfulIntegers(2, 3, 10)));
    }
}
