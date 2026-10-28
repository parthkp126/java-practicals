public class CounterRace {
    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public synchronized void incrementSafely() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        int incrementsPerThread = 100000;
        Counter counter = new Counter();

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Without synchronization: "
                + counter.getCount());

        counter = new Counter();
        Counter safeCounter = counter;

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    safeCounter.incrementSafely();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("With synchronization: "
                + safeCounter.getCount());
    }
}