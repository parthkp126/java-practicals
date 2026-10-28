package prac2;


public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    public void park(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("two wheeler parked");
            } else {
                System.out.println("Full");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("four wheeler parked");
            } else {
                System.out.println("Full");
            }
        }
    }

    public void leave(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("two wheeler left");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("four wheeler left");
            }
        }
    }

    public static void main(String[] args) {

        ParkingLot parking = new ParkingLot(2, 2);

        parking.park("two");
        parking.park("two");
        parking.park("two");

        parking.park("four");
        parking.park("four");
        parking.park("four");

        parking.leave("two");
        parking.park("two");

        System.out.println("two wheelers: " + parking.twoWheelers);
        System.out.println("four wheelers: " + parking.fourWheelers);
        System.out.println("revenue: $" + revenue);
    }
}

