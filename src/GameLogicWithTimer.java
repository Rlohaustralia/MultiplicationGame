import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class GameLogicWithTimer {


    private static final int ROUND_COUNT = 5;
    private static final int CORRECT_ANSWER_POINTS = 20;
    private static final int TIME_LIMIT = 3000;
    private int score = 0;
    private int questionNumber = 1;



    public void startGame() {
        // Generate five questions per a round
        for (int i = 0 ; i < ROUND_COUNT; i++) {
            playGame();
        }
    }

    private void playGame() {

        // Generate random numbers and multiply them
        Random random1 = new Random();
        Random random2 = new Random();
        int firstNum = random1.nextInt(9) + 1;
        int secondNum = random2.nextInt(9) + 1;
        int multiply = firstNum * secondNum;
        System.out.printf("Question %d --- %d X %d%n", questionNumber, firstNum, secondNum);


        // Schedule the timer task
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                System.out.println("Time's up! No points earned.");
                timer.cancel();
                questionNumber ++;
                askNextQuestion();
            }
        };
        timer.schedule(task,TIME_LIMIT);


        // Read the user's input and cancel the timer if the user type a response
        Scanner keyboard = new Scanner(System.in);
        int answer = keyboard.nextInt();
        timer.cancel();


        // Check the result and calculate the score
        if (answer == multiply) {
            System.out.println("Correct! You earned " + CORRECT_ANSWER_POINTS);
            score += CORRECT_ANSWER_POINTS;
        } else {
            System.out.println("Incorrect! No points earned.");
        }
        questionNumber++;
        System.out.println("이젠 여기에 있습니다.");
    }



    private void askNextQuestion() {
        System.out.println("틀려서 여기왔어요");
        if (questionNumber <= ROUND_COUNT) {
            playGame();
        } else {
            showResult();
        }
    }


    public void showResult() {

        Scanner keyboard = new Scanner(System.in);

        System.out.printf("%nYou've scored %d out of 100.%n", score);
        System.out.println("Would you like to play another game? [Y or N] ");
        String yesOrNo = keyboard.next();
        System.out.println("???");

        // Validate the user's input
        while(!(yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("N"))){
            System.out.println("Please type a valid character [Y or N]");
            yesOrNo = keyboard.next();
        }

        if(yesOrNo.equalsIgnoreCase("Y")){
            score = 0; // Reset the score for the next round
            questionNumber = 1; // Reset the questionNumber for the next round
            startGame();

        } else {
            System.out.println("Game end");
        }

    }
}

