package maidez.practices.concurrent.masterWorker;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by luwenyi on 2018/7/4.
 */
public class Master<T, V> {
    private Queue<T> queue = new ConcurrentLinkedDeque<>();

    public Map<Integer, Thread> workers = Maps.newHashMap();

    private Vector<V> results = new Vector<>();

    public Master(Worker<T, V> worker, int workerCount) {
        worker.setQueue(queue);
        worker.setResults(results);
        for (int i = 0; i < workerCount; i++) {
            workers.put(i, new Thread(worker, "Worker-" + i));
        }
    }

    public void submit(T t) {
        queue.add(t);
    }

    public boolean isDone() {
        for (Map.Entry<Integer, Thread> entry : workers.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public void execute() {
        for (Map.Entry<Integer, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }

    public Vector<V> get() {
        return results;
    }


    public static void main(String[] args) throws InterruptedException {
        int loopResult = 0;
        long loopStartTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(5L);
            loopResult += i * i * i;
        }
        System.out.println(String.format("Use Time : %s, Result : %s", System.currentTimeMillis() - loopStartTime, loopResult));


        int masterWorkerResult = 0;
        Master<Integer, Integer> master = new Master<>(new Worker<Integer, Integer>() {
            @Override
            protected Integer execute(Integer integer) {
                return integer * integer * integer;
            }
        }, 10);
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(5L);
            master.submit(i);
        }
        long masterWorkerStartTime = System.currentTimeMillis();
        master.execute();
        while (true) {
            if (master.isDone()) {
                break;
            }
        }
        for (Integer integer : master.get()) {
            masterWorkerResult += integer;
        }
        System.out.println(String.format("Use Time : %s, Result : %s", System.currentTimeMillis() - masterWorkerStartTime, masterWorkerResult));

    }
}
