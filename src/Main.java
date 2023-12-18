// Developer : Eojin Ra
// This source code is a simple console-based Mulitiplication game implemented in Java
// Last updated : 18 Dec 2023

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