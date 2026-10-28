public class BoundedStats {
    public static <N extends Number> double average(N[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(
                    "Array must contain values.");
        }

        double sum = 0;

        for (N value : values) {
            sum += value.doubleValue();
        }

        return sum / values.length;
    }

    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30};
        Double[] decimals = {2.5, 3.5, 4.0};
        Long[] largeNumbers = {100L, 200L, 300L};

        System.out.println("Integer average: "
                + average(integers));
        System.out.println("Double average: "
                + average(decimals));
        System.out.println("Long average: "
                + average(largeNumbers));
    }
}