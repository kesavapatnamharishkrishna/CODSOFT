import java.util.Random;
import java.util.Scanner;

public class Test 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int totalAttemptsUsed = 0;

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) 
        {
            int generatedNumber = r.nextInt(100);  
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n New Round! I have generated a number between 0 and 99.");
            System.out.println("You have " + maxAttempts + " attempts to guess it correctly.\n");

            while (attempts < maxAttempts) 
            {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == generatedNumber) 
                {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempt(s).");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } 
                else if (userGuess > generatedNumber) 
                {
                    System.out.println("Your guess is too high. Try again.");
                } 
                else 
                {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            if (!guessedCorrectly) 
            {
                System.out.println("\n Out of attempts! The correct number was: " + generatedNumber);
            }

            totalRounds++;
            totalAttemptsUsed += attempts;

            System.out.print("\n Do you want to play another round? (y/n): ");
            char choice = sc.next().toLowerCase().charAt(0);
            playAgain = (choice == 'y');
        }

        System.out.println("\n Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Attempts Used: " + totalAttemptsUsed);
        if (roundsWon > 0) 
        {
            double avgAttempts = (double) totalAttemptsUsed / roundsWon;
            System.out.printf("Average Attempts per Win: %.2f\n", avgAttempts);
        } 
        else 
        {
            System.out.println("Better luck next time!");
        }
    }
}
