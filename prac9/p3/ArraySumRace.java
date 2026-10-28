public class ArraySumRace {
    static class SharedTotal {
        private long total = 0;

        public synchronized void add(long value) {
            total += value;
        }

        public long getTotal() {
            return total;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1;
        }

        int threadCount = 4;
        Thread[] threads = new Thread[threadCount];
        SharedTotal total = new SharedTotal();

        int chunkSize = numbers.length / threadCount;

        for (int t = 0; t < threadCount; t++) {
            final int start = t * chunkSize;
            final int end = (t == threadCount - 1)
                    ? numbers.length
                    : start + chunkSize;

            threads[t] = new Thread(() -> {
                long subtotal = 0;

                for (int i = start; i < end; i++) {
                    subtotal += numbers[i];
                }

                total.add(subtotal);
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Total: " + total.getTotal());
    }
}