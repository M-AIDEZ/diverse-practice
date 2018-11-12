package maidez.practices.concurrent.future;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by luwenyi on 2018/11/12.
 */
public class JDKFutureTest {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        List<Callable<Pair<Integer, Long>>> tasks;
        tasks = Lists.newArrayList();
        for (int i = 1; i <= 50; i++) {
            int finalI = i;
            tasks.add(() -> new Pair<>(finalI, fibonacci(finalI)));
        }
        try {
            List<Future<Pair<Integer, Long>>> futures = THREAD_POOL.invokeAll(tasks);
            for (Future<Pair<Integer, Long>> future : futures) {
                System.out.println(String.format("INDEX:%s, VALUE:%s", future.get().getKey(), future.get().getValue()));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static final Map<Integer, Long> CACHE = Maps.newConcurrentMap();

    private static long fibonacci(int n) {
        if (CACHE.containsKey(n))
            return CACHE.get(n);
        long value = n == 1L ? 0L : n == 2L ? 1L : fibonacci(n - 1) + fibonacci(n - 2);
        CACHE.put(n, value);
        return value;
    }

}
