package maidez.practices.leetcode.mergeinterval;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>(Integer::compareTo);
        for (int[] interval : intervals) {
            if (intervalMap.containsKey(interval[0])) {
                if (intervalMap.get(interval[0]) < interval[1]) {
                    intervalMap.put(interval[0], interval[1]);
                }
            } else {
                intervalMap.put(interval[0], interval[1]);
            }
        }
        Map.Entry<Integer, Integer> prev = null;
        Iterator<Map.Entry<Integer, Integer>> iterator = intervalMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (prev == null) {
                prev = next;
                continue;
            }
            if (next.getKey() <= prev.getValue()) {
                if(next.getValue() > prev.getValue()) {
                    prev.setValue(next.getValue());
                }
                iterator.remove();
            } else {
                prev = next;
            }
        }
        int[][] result = new int[intervalMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervalMap.entrySet()) {
            result[i] = new int[]{entry.getKey(), entry.getValue()};
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        mergeInterval.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {16, 17}});
    }
}
