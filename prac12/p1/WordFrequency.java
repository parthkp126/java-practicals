import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph =
                "Java is useful and Java is popular for programming";

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : paragraph.toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .split("\\s+")) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> words =
                new ArrayList<>(frequency.entrySet());

        words.sort(
                Comparator.comparingInt(
                                (Map.Entry<String, Integer> entry) ->
                                        entry.getValue())
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        for (Map.Entry<String, Integer> entry : words) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}