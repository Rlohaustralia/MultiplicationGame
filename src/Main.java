public class Main {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {

        // Welcome message
        GameUI.welcomeMessage();

        // Get user's name
        GameUI.getUserName();

        // Explain the rules of the game
        GameUI.gameRules();

        // Ask users if they are ready to play
        GameUI.readyToPlay();

        // Play the game
        GameLogic.playGame();

        // Show the result
        GameLogic.showResult();

    }
}