import java.util.Random;
import java.util.Scanner;

public class  GameLogic {

    private static int score = 0;

    public static void playGame() {
        Scanner keyboard = new Scanner(System.in);

        // Generate five questions per a round
        int round = 5;

        for (int i = 1; i <= round; i++) {

            // Generate random numbers and multiply them
            Random random1 = new Random();
            Random random2 = new Random();
            int firstNum = random1.nextInt(9) + 1;
            int secondNum = random2.nextInt(9) + 1;
            int multiply = firstNum * secondNum;

            System.out.printf("%n%d X %d%n", firstNum, secondNum);
            int answer = keyboard.nextInt();

            if (answer == multiply) {
                System.out.println("Correct!");
                score += 20;
            } else {
                System.out.println("Incorrect!");
            }
        }
    }

    public static void showResult() {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("%nYou've scored %d out of 100.%n", score);
        System.out.println("Would you like to play another game? [Y or N] ");
        String answer = keyboard.next();


        // Validate the user's input
        while(!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))){
            System.out.println("Please type a valid character [Y or N]");
            answer = keyboard.next();
        }
        if(answer.equalsIgnoreCase("Y")){
            score = 0; // Reset the score for the next round
            playGame();
            showResult();

        } else {
            System.out.println("Game end");
        }
    }
}
