class Stack<T> {
    private Object[] values;
    private int size;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be positive.");
        }

        values = new Object[capacity];
        size = 0;
    }

    public void push(T value) {
        if (size == values.length) {
            throw new IllegalStateException("Stack is full.");
        }

        values[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty.");
        }

        T value = (T) values[--size];
        values[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty.");
        }

        return (T) values[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class GenericStack {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>(5);
        names.push("Riya");
        names.push("Aman");

        System.out.println("Top name: " + names.peek());
        System.out.println("Removed: " + names.pop());

        Stack<Integer> numbers = new Stack<>(5);
        numbers.push(10);
        numbers.push(20);

        System.out.println("Removed number: " + numbers.pop());
    }
}