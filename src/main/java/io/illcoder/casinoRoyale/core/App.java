package io.illcoder.casinoRoyale.core;

import java.io.IOException;
import java.util.Scanner;


/**
 * This program greets the player and sends them to games based upon their input. As well
 * as serving as a return pad for players that leave a game
 */
public class App {

    //Dealer dealer = new Dealer;


    //intiates scanner for entire class
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(" __   __    ______     ___           _______. __  .__   __.   ______      .______        ______   ____    ____  ___       __       _______  __   __  \n" +
                "|  | |  |  /      |   /   \\         /       ||  | |  \\ |  |  /  __  \\     |   _  \\      /  __  \\  \\   \\  /   / /   \\     |  |     |   ____||  | |  | \n" +
                "|  | |  | |  ,----'  /  ^  \\       |   (----`|  | |   \\|  | |  |  |  |    |  |_)  |    |  |  |  |  \\   \\/   / /  ^  \\    |  |     |  |__   |  | |  | \n" +
                "|  | |  | |  |      /  /_\\  \\       \\   \\    |  | |  . `  | |  |  |  |    |      /     |  |  |  |   \\_    _/ /  /_\\  \\   |  |     |   __|  |  | |  | \n" +
                "|__| |__| |  `----./  _____  \\  .----)   |   |  | |  |\\   | |  `--'  |    |  |\\  \\----.|  `--'  |     |  |  /  _____  \\  |  `----.|  |____ |__| |__| \n" +
                "(__) (__)  \\______/__/     \\__\\ |_______/    |__| |__| \\__|  \\______/     | _| `._____| \\______/      |__| /__/     \\__\\ |_______||_______|(__) (__) \n" +
                "                                                                                                                                                     ");
        System.out.print("The Casino Royale's doors swoosh open at your approach.\n A myriad of fragrances and aromas accompany the cool\n" +
                "air that makes the dry heat of desert \n a distant memory. A middle aged attendant" +
                " with a snake like smile you don't trust approaches. Hey whats your name pal?: ");
        //Starts method for name input after prompt and game selection
            menuSelection();
    }
    //created method containing all main menu user input.
    private static void menuSelection() {
        //This string will set the players name
        //Player player1 = new Player(String name, int money)
        //playerName = player.name
        String playerName = scanner.nextLine();
        Scanner in = new Scanner(System.in);
        System.out.printf("Welcome to the Game room " + playerName + "! what do you wanna play? " +
                "1 for BlackJack, " +
                "2 for Poker, or " +
                "0 to quit:  ");
        //start loop for switch statement
        Boolean continueLoop = true;
        while (continueLoop) {
            /*
            *The first int takes the user input to choose which game they want to play
            *The second int specifies the gameType by case number
            *The String gameSelection is the message displayed when the user selects a game
            * The default case value gives an error if the user input an invalid selection and uses the continue; to allow another input
             */
            int input = in.nextInt();
            int gameType = input;
            String gameSelection;
            switch (gameType) {
                case 1:
                    gameSelection = " You strut confidently to the BlackJack table." +
                            " A slovenly man past his prime gaze meets yours as sit, he smiles confident of his pending victory.";
                    //starts a new blackjack game by creating BlackJackDealer object current loops ends

                    break;
                case 2:
                    gameSelection = "You have a seat at the poker table. Your opponent smells like urine and failed dreams.";
                    //starts a new blackjack game by creating PokerDealer object current loops ends

                    break;
                case 0:
                    gameSelection = "You cut and run out the front door on foot. Your getting to old for this shit.";
                    //ends the program by terminating loop
                    break;
                default:
                    System.out.println("It's either 1 for BlackJack, 2 for Poker, or 0 to quit...This ain't rocket science kid.");
                    //continues loop since an invalid response was given prompts player with correct commands and allows them to try again.
                    continue;

            }
            System.out.println(gameSelection);
            //close loop to end program
            continueLoop = false;
        }

    }
}
//End