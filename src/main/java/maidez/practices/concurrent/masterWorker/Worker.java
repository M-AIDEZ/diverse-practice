package maidez.practices.concurrent.masterWorker;

import java.util.Queue;
import java.util.Vector;

/**
 * Created by luwenyi on 2018/7/4.
 */
public abstract class Worker<T, V> implements Runnable {
    private Queue<T> queue;
    private Vector<V> results;

    public void setQueue(Queue<T> queue) {
        this.queue = queue;
    }

    public void setResults(Vector<V> results) {
        this.results = results;
    }

    protected abstract V execute(T t);

    @Override
    public void run() {
        while (true) {
            T poll = queue.poll();
            if (poll == null) {
                break;
            }
            results.add(execute(poll));
        }
    }
}