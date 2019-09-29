package maidez.practices.familycountrydream.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/30.
 */
public class MathUtils {
    public static <T> List<List<T>> combination(List<T> list, int size) {
        List<List<T>> combinations = Lists.newArrayList();
        combinations.addAll(combinationHelper(0, list, Lists.newArrayList(), size));
        return combinations;
    }

    private static <T> List<List<T>> combinationHelper(int startIndex, List<T> list, List<T> parent, int size) {
        List<List<T>> combinations = Lists.newArrayList();
        if (size + startIndex - 1 > list.size()) {
            return combinations;
        }
        if (size == 1) {
            for (int i = startIndex; i < list.size(); i++) {
                List<T> temp = Lists.newArrayList(parent);
                temp.add(list.get(i));
                combinations.add(temp);
            }
        } else {
            for (int i = startIndex; i < list.size(); i++) {
                List<T> temp = Lists.newArrayList(parent);
                temp.add(list.get(i));
                combinations.addAll(combinationHelper(i + 1, list, temp, size - 1));
            }
        }
        return combinations;
    }
}
