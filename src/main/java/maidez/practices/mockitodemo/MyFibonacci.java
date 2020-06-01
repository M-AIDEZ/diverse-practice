package maidez.practices.mockitodemo;

import java.util.HashMap;
import java.util.Map;

public class MyFibonacci {
    private Map<Integer, Long> cache;

    private Integer callTimes;

    public MyFibonacci() {
        this.cache = new HashMap<>();
        this.callTimes = 0;
    }

    public int cacheSize() {
        return cache.size();
    }

    public long fibonacci(int i) {
        return fibonacci(i, false);
    }

    public long fibonacci(int i, boolean withCache) {
        callTimes++;
        if (i == 0) {
            throw new IllegalArgumentException("i start from 1");
        }
        Long num = withCache ? cache.get(i) : null;
        if (num == null) {
            if (i == 1 || i == 2) {
                num = 1L;
            } else {
                num = fibonacci(i - 1, withCache) + fibonacci(i - 2, withCache);
            }
            cache.put(i, num);
        }
        System.out.println("fibonacci " + i + " : " + num);
        return num;
    }
}
