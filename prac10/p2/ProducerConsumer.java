import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumer {
    static class Buffer {
        private final Queue<Integer> items = new ArrayDeque<>();
        private final int capacity = 3;

        public synchronized void put(int value)
                throws InterruptedException {
            while (items.size() == capacity) {
                wait();
            }

            items.add(value);
            System.out.println("Produced: " + value);
            notifyAll();
        }

        public synchronized int take()
                throws InterruptedException {
            while (items.isEmpty()) {
                wait();
            }

            int value = items.remove();
            System.out.println("Consumed: " + value);
            notifyAll();
            return value;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.put(i);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.take();
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Production and consumption completed.");
    }
}