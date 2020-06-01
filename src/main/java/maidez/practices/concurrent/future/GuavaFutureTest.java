package maidez.practices.concurrent.future;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by luwenyi on 2018/11/12.
 */
public class GuavaFutureTest {
    private static final ExecutorService BASIC_POOL = Executors.newFixedThreadPool(10);

    private static final ListeningExecutorService LISTENING_POOL = MoreExecutors.listeningDecorator(BASIC_POOL);


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Stopwatch started = Stopwatch.createStarted();

        List<ListenableFuture<Integer>> step1Futures = Lists.newArrayList();
//        List<ListenableFuture<Integer>> step2Futures = Lists.newArrayList();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;

            ListenableFuture<Integer> step1Future = LISTENING_POOL.submit(() -> step1(finalI));
            Futures.addCallback(step1Future, new FutureCallback<Integer>() {
                @Override
                public void onSuccess(Integer result) {
                    step2(result);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
            //不能够确保监听器执行的顺序，但可以在计算完成时确保马上被调用
            step1Futures.add(step1Future);

//            ListenableFuture<Integer> step2Future = Futures.transform(step1Future, input -> step2(input), BASIC_POOL);
//            step2Futures.add(step2Future);
        }

        Futures.allAsList(step1Futures).get();
        System.out.println("TASK 1 COST " + started.elapsed(TimeUnit.MILLISECONDS));

//        Futures.allAsList(step2Futures).get();
//        System.out.println("TOTAL COST " + started.elapsed(TimeUnit.MILLISECONDS));
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
