package maidez.practices.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

public class Draft {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static void main(String[] args) throws InterruptedException {
        List<Callable<Integer>> tasks = Lists.newArrayList();
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            tasks.add(() -> {
                System.err.println("PARENT " + finalI + " STARTED");
                CountDownLatch latch = new CountDownLatch(2);
                for (int j = 0; j < 10; j++) {
                    int finalJ = j;
                    executorService.submit(() -> {
                        try {
//                            System.out.println("CHILD " + finalI + "-" + finalJ + " STARTED");
                            Thread.sleep(10L);
//                            System.out.println("CHILD " + finalI + "-" + finalJ + " DONE");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            latch.countDown();
                        }
                    });
                }
                latch.await();
//                latch.await(5, TimeUnit.SECONDS);
                System.out.println("PARENT " + finalI + " DONE");
                return finalI;
            });
        }
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
    }


}
