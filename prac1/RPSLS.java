
import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    static int winner(Move a, Move b) {
        if (a == b) {
            return 0;
        }

        return switch (a) {
            case ROCK -> (b == Move.SCISSORS || b == Move.LIZARD) ? 1 : -1;
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {

            Move computer = Move.values()[random.nextInt(Move.values().length)];

            System.out.print("enter your move (rock, paper, scissors, lizard, spock): ");
            Move player = Move.valueOf(sc.nextLine().toUpperCase());

            int result = winner(player, computer);

            System.out.println("round " + round);
            System.out.println("you: " + player.toString().toLowerCase());
            System.out.println("computer: " + computer.toString().toLowerCase());

            if (result == 1) {
                System.out.println("round winner: you");
                playerScore++;
            } else if (result == -1) {
                System.out.println("round winner: computer");
                computerScore++;
            } else {
                System.out.println("round winner: tie");
            }

            System.out.println();
        }

        if (playerScore > computerScore) {
            System.out.println("you win " + playerScore + "-" + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("computer wins " + computerScore + "-" + playerScore);
        } else {
            System.out.println("it's a tie " + playerScore + "-" + computerScore);
        }

        sc.close();
    }
}


