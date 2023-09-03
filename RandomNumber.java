import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();
        int randomNumber = random.nextInt(101); // Generates a random number between 0 and 100

        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        boolean guessCorrectly = false;

        System.out.println("*****-----Welcome to my Random Number Game!*****------");
        System.out.println("Enter your guess between 0 and 100.");

        while (!guessCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if(attempts>5) {
                System.out.println("XXXX----You have completed your 5 attempts, Better luck next time----XXXX");
                break;
            }
                if (userGuess < 0 || userGuess > 100) {
                    System.out.println("Please enter a number between 0 and 100.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number, which was " + randomNumber);
                    System.out.println("It took you " + attempts + " attempts.");
                    guessCorrectly = true;
                }
        }
        scanner.close();
    }
}
