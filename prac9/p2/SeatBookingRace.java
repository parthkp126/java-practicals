public class SeatBookingRace {
    static class Booking {
        private int seatsLeft = 5;

        public synchronized boolean book() {
            if (seatsLeft > 0) {
                seatsLeft--;
                return true;
            }
            return false;
        }

        public int getSeatsLeft() {
            return seatsLeft;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Booking booking = new Booking();
        Thread[] users = new Thread[10];
        int[] successfulBookings = {0};

        for (int i = 0; i < users.length; i++) {
            users[i] = new Thread(() -> {
                if (booking.book()) {
                    synchronized (successfulBookings) {
                        successfulBookings[0]++;
                    }
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " booked a seat");
                } else {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " could not book");
                }
            });
            users[i].start();
        }

        for (Thread user : users) {
            user.join();
        }

        System.out.println("Successful bookings: "
                + successfulBookings[0]);
        System.out.println("Seats left: " + booking.getSeatsLeft());
    }
}