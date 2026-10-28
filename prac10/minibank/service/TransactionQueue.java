
package service;

import java.util.ArrayDeque;
import java.util.Queue;

public class TransactionQueue {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final int capacity;

    public TransactionQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void add(Runnable task)
            throws InterruptedException {
        while (tasks.size() == capacity) {
            wait();
        }

        tasks.add(task);
        notifyAll();
    }

    public synchronized Runnable remove()
            throws InterruptedException {
        while (tasks.isEmpty()) {
            wait();
        }

        Runnable task = tasks.remove();
        notifyAll();
        return task;
    }

    public void process(int taskCount) throws InterruptedException {
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < taskCount; i++) {
                    remove().run();
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        consumer.join();
    }
}