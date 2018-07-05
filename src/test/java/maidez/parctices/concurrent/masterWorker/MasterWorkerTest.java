package maidez.parctices.concurrent.masterWorker;

import maidez.practices.concurrent.masterWorker.Master;
import maidez.practices.concurrent.masterWorker.Worker;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by luwenyi on 2018/7/5.
 */
public class MasterWorkerTest {
    @Test
    public void test() throws InterruptedException {
        long loopResult = 0L;
        long loopStartTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(5L);
            loopResult += i * i * i;
        }
        System.out.println(String.format("Loop Use Time : %s", System.currentTimeMillis() - loopStartTime));


        //经过测试，masterWorker的构造过程开销很大
        long masterWorkerConstructStartTime = System.currentTimeMillis();
        long masterWorkerResult = 0L;
        Master<Integer, Integer> master = new Master<>(new Worker<Integer, Integer>() {
            @Override
            protected Integer execute(Integer integer) {
                return integer * integer * integer;
            }
        }, 10);
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(5L);
            master.submit(i);
        }
        System.out.println(String.format("MasterWorker Construct Use Time : %s", System.currentTimeMillis() - masterWorkerConstructStartTime));
        long masterWorkerExecuteStartTime = System.currentTimeMillis();
        master.execute();
        while (true) {
            if (master.isDone()) {
                break;
            }
        }
        for (Integer integer : master.get()) {
            masterWorkerResult += integer;
        }
        System.out.println(String.format("MasterWorker Use Time : %s", System.currentTimeMillis() - masterWorkerExecuteStartTime));

        Assert.assertEquals(loopResult, masterWorkerResult);
    }
}
