class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class GenericContainers {
    public static <T> T firstElement(T[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        return values[0];
    }

    public static void main(String[] args) {
        Box<String> nameBox = new Box<>();
        nameBox.set("Riya");

        Box<Integer> numberBox = new Box<>();
        numberBox.set(25);

        Pair<String, Integer> student =
                new Pair<>("Aman", 20);

        String[] names = {"Neha", "Riya", "Aman"};

        System.out.println("Name: " + nameBox.get());
        System.out.println("Number: " + numberBox.get());
        System.out.println("Pair: " + student.getFirst()
                + ", " + student.getSecond());
        System.out.println("First array value: "
                + firstElement(names));
    }
}