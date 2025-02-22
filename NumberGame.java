import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");
            totalScore += playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }

    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 10;
        int score = 0;

        System.out.println("\nGuess the number between " + lowerBound + " and " + upperBound + ". You have " + attempts + " attempts.");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int guess;
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            if (guess < lowerBound || guess > upperBound) {
                System.out.println("Out of range! Guess a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the correct number " + numberToGuess + "!");
                score += attempts;  // Higher score for fewer attempts used
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts--;
            System.out.println("Attempts left: " + attempts);
        }

        if (attempts == 0) {
            System.out.println("Game Over! The number was " + numberToGuess + ".");
        }

        return score;
    }
}

