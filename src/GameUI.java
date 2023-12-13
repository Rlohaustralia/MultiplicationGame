import java.util.Scanner;

public class GameUI {

    // Welcome message
    public static void welcomeMessage() {
        System.out.println("Hello, Let's start the multiplication game!");
    }


    public static void getUserName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type your prefer user name: ");
        String userName = keyboard.next();
        System.out.printf("%nHello %s. ",userName);
    }


    public static void gameRules() {
        System.out.println("Here are the rules of the game:\n" +
                "1. You will play five games for each round.\n" +
                "2. You will earn 20 scores for each correct answer.\n" +
                "3. If you answer all questions correctly, you will receive 100 scores.\n" +
                "4. After finishing a round, you can choose to play more if you'd like.\n");
    }

    public static void readyToPlay() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Are you ready to play? [Y or N]");
        String yesOrNo = keyboard.next();

        while (true) {
            // Validate the user's input
            while (!(yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("N"))){
                System.out.println("Please type a valid character [Y or N]");
                yesOrNo = keyboard.next();
            }

            if (yesOrNo.equalsIgnoreCase("Y")){
                System.out.println("Okay, Let's get started it!");
                break;
            } else if (yesOrNo.equalsIgnoreCase("N")) {
                gameRules();
                System.out.println("Are you ready to play now? [Y or N]");
                yesOrNo = keyboard.next();

                // Validate the user's input
                while (!(yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("N"))){
                    System.out.println("Please type a valid character [Y or N]");
                    yesOrNo = keyboard.next();
                }
            }
        }
    }
}

