import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Riya", 95);
        scores.put("Aman", 88);
        scores.put("Neha", 95);
        scores.put("Karan", 76);

        int topN = 3;

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort(
                Comparator.comparingInt(
                                (Map.Entry<String, Integer> entry) ->
                                        entry.getValue())
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        System.out.println("Top " + topN + " players:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);
            System.out.println(player.getKey() + ": " + player.getValue());
        }
    }
}