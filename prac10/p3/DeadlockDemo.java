public class DeadlockDemo {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    private static void pause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        Thread first = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1 locked A");
                pause();

                synchronized (lockB) {
                    System.out.println("Thread 1 locked B");
                }
            }
        });

        Thread second = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2 locked B");
                pause();

                synchronized (lockA) {
                    System.out.println("Thread 2 locked A");
                }
            }
        });

        first.setDaemon(true);
        second.setDaemon(true);

        first.start();
        second.start();

        Thread.sleep(300);
        System.out.println("Opposite lock order can cause deadlock.");

        Thread safeFirst = new Thread(() -> lockInOrder("Safe thread 1"));
        Thread safeSecond = new Thread(() -> lockInOrder("Safe thread 2"));

        safeFirst.start();
        safeSecond.start();

        safeFirst.join();
        safeSecond.join();

        System.out.println("Consistent lock order completed.");
    }

    private static void lockInOrder(String name) {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println(name + " acquired A then B");
            }
        }
    }
}