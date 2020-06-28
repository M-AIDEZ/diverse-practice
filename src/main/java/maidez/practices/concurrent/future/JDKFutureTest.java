package maidez.practices.concurrent.future;


import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by luwenyi on 2018/11/12.
 */
public class JDKFutureTest {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Stopwatch started = Stopwatch.createStarted();

        //提交step1
        List<Future<Integer>> step1Futures = Lists.newArrayList();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            Future<Integer> step1Future = THREAD_POOL.submit(() -> step1(finalI));
            step1Futures.add(step1Future);
        }

        //获取step1结果，提交step2
        List<Future<Integer>> step2Futures = Lists.newArrayList();
        for (Future<Integer> step1Future : step1Futures) {
            Integer step1Result = step1Future.get();
            Future<Integer> step2Future = THREAD_POOL.submit(() -> step2(step1Result));
            step2Futures.add(step2Future);
        }

        System.out.println("TASK 1 COST " + started.elapsed(TimeUnit.MILLISECONDS));

        //获取step2结果
        for (Future<Integer> step2Future : step2Futures) {
            step2Future.get();
        }

        System.out.println("TOTAL COST " + started.elapsed(TimeUnit.MILLISECONDS));
    }

    private static int step1(int n) {
        try {
            Thread.sleep((6 - n) * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format(System.currentTimeMillis() + "\t TASK 1 DONE \t INDEX : %s", n));
        return n;
    }

    private static int step2(int n) {
        try {
            Thread.sleep(n * 500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format(System.currentTimeMillis() + "\t TASK 2 DONE \t INDEX : %s", n));
        return n;
    }
}
