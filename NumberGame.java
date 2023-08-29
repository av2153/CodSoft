import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        playNumberGame();
    }

    public static void playNumberGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int upperLimit = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Game!");

        do {
            int targetNumber = random.nextInt(upperLimit) + 1;
            int attempts = 0;
            int guess;

            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess a number between 1 and " + upperLimit + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                guess = scanner.nextInt();

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1);
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you have used all your attempts. The number was: " + targetNumber);
                }
            }

            rounds++;
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        System.out.println("Thanks for playing the Number Game! Your final score: " + score);
        scanner.close();
    }
}

