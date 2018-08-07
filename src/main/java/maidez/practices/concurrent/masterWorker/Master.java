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


    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            System.out.println(String.format("Table-%s", i));
        }
    }
}
