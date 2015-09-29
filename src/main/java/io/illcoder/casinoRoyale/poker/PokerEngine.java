package io.illcoder.casinoRoyale.poker;


import io.illcoder.casinoRoyale.core.*;

import java.util.*;

/**
 * Created by seth on 9/27/2015.
 * PokerEngine contains the methods and variables to run a heads up limit texas hold'em poker game.
 */
public class PokerEngine {
    Dealer dealer = new Dealer();
    Scanner scan = new Scanner(System.in);
    Player user;
    Player cpu;
    Player sb;
    Player bb;
    Player board;
    Player burn;
    int smallBlind = 1;
    int bigBlind =2;
    int bigBet = 4;
    int pot = 0;
    int action;
    int raiseCount = 0;
    boolean playerFolded = false;
    boolean continueLoop = true;
    GameControl gc = new GameControl();
    List<Card> sevenCards;

    public PokerEngine (Player _user) {
        this.user = _user;
        this.cpu = new Player("CPU");
        this.board = new Player("BOARD");
        this.burn = new Player("BURN");


        sb = cpu;
        bb = user;


    }
    public void startGameMessage() {
        System.out.println("Welcome to the Poker Game " + user.getName() + ". You currently have $" +
                user.getMoney() + " in chips.\nStarting first hand...\n");

        gc.pause(1);
        nextHand();
    }

    public void playerContinue() {
        System.out.println("\nWould you like to play another hand " + user.getName() + "? You currently have $" +
                user.getMoney() + " in chips.\n\nEnter 1 to play or 2 to quit.");
        int userChoice = scan.nextInt();

        switch (userChoice) {
            case 1:
                nextHand();
                break;
            case 2:
                continueLoop = false;
                break;
            default:
                nextHand();
                break;
        }
    }

    public void clearAllHands() {
        sb.getHand().clear();
        bb.getHand().clear();
        board.getHand().clear();
        burn.getHand().clear();
        playerFolded = false;
    }

    public void nextHand() {
        clearAllHands();
        dealer.shuffleDeck();
        //System.out.println(dealer.getCardIndex());
        if (sb.getName().equalsIgnoreCase("CPU")) {
            sb = user;
            bb = cpu;
        } else {
            sb = cpu;
            bb = user;
        }

        pot = smallBlind + bigBlind;
        sb.setMoney(sb.getMoney() - smallBlind);
        bb.setMoney(bb.getMoney() - bigBlind);
        dealHoleCards();

        preflop();

        if (playerFolded) {
            determineWinner();
            return;
        } else {
            flop();
        }

        if (playerFolded) {
            determineWinner();
            return;
        } else {
            turn();
        }

        if (playerFolded) {
            determineWinner();
        } else {
            river();
            determineWinner();
        }

    }

    public void updateDisplay() {

        if (user.getHand().size() > 0){
            System.out.println("\nYou have: " + user.getHand());
        }
        if (board.getHand().size() > 0) {
            System.out.println("Board: " + board.getHand());
        }
        System.out.println("Pot: $" + pot + " - " + cpu.getName() + ": $" + cpu.getMoney() +
                " - " + user.getName() + ": $" + user.getMoney());
    }

    public void displayPot(){
        System.out.println("Pot: $" + pot + " - " + cpu.getName() + ": $" + cpu.getMoney() +
                " - " + user.getName() + ": $" + user.getMoney());
    }

    public void preflop(){
        raiseCount = 0;
        System.out.println("Dealing hole cards...");
        gc.pause();
        updateDisplay();
        sbActionCompleteBlind(smallBlind, bigBlind);

    }

    public void flop(){
        raiseCount = 0;
        System.out.println("Dealing flop...");
        burn.addCard(dealer.dealCard());
        board.addCard(dealer.dealCard());
        board.addCard(dealer.dealCard());
        board.addCard(dealer.dealCard());
        System.out.println(board.getHand());
        gc.pause();
        updateDisplay();
        bbActionNoBet(bigBlind);
    }

    public void turn(){
        raiseCount = 0;
        System.out.println("Dealing turn...");
        burn.addCard(dealer.dealCard());
        board.addCard(dealer.dealCard());
        System.out.println("     [" + board.getHandCard(3) + "]");
        gc.pause();
        updateDisplay();
        bbActionNoBet(bigBet);
    }

    public void river(){
        raiseCount = 0;
        System.out.println("Dealing river...");
        burn.addCard(dealer.dealCard());
        board.addCard(dealer.dealCard());
        System.out.println("     [" + board.getHandCard(4)+ "]");
        gc.pause();
        updateDisplay();
        bbActionNoBet(bigBet);
    }

    public void checkMessage(Player _player) {
        System.out.println("\n" + _player.getName() + " checks.");
    }
    public void callMessage(Player _player) {
        System.out.println("\n" + _player.getName() + " calls.");
    }
    public void raiseMessage(Player _player) {
        System.out.println("\n" + _player.getName() + " raises.");
    }
    public void foldMessage(Player _player) {
        System.out.println("\n" + _player.getName() + " folds.");
    }
    public void betMessage(Player _player) {
        System.out.println("\n" + _player.getName() + " bets.");
    }

    /**
     * make separate preflop first sbActionFacingBet method for completing the
     * small blind that gives the bb an option to check or raise after the sb
     * calls. when sb calls any other time the action is over.
     * @param prevBetSize
     * @param betSize
     */
    public void sbActionFacingBet(int prevBetSize, int betSize) {
        //System.out.println(" ");
        if (raiseCount > 3) {
            if (sb.getName().equalsIgnoreCase("CPU")) {
                Random rand = new Random();
                action = rand.nextInt(2) + 1;
            } else {
                System.out.println("\nEnter 1 to CALL, 2 to FOLD.");
                action = scan.nextInt();
            }
            switch (action) {
                case 1:
                    pot = pot + prevBetSize;
                    sb.setMoney(sb.getMoney() - prevBetSize);
                    callMessage(sb);
                    break;
                case 2:
                    sb.getHand().clear();
                    playerFolded = true;
                    foldMessage(sb);

                    break;
                default:
                    System.out.println("Invalid input.\n");
                    sbActionFacingBet(prevBetSize, betSize);
                    break;
                }

        } else {
            if (sb.getName().equalsIgnoreCase("CPU")) {
                Random rand = new Random();
                action = rand.nextInt(3) + 1;

            } else {
                System.out.println("\nEnter 1 to CALL, 2 to RAISE, 3 to FOLD.");
                action = scan.nextInt();
            }
            switch (action) {
                case 1:
                    pot = pot + prevBetSize;
                    sb.setMoney(sb.getMoney() - prevBetSize);
                    callMessage(sb);
                    break;
                case 2:
                    raiseCount++;
                    pot = pot + prevBetSize + betSize;
                    sb.setMoney(sb.getMoney() - prevBetSize - betSize);
                    raiseMessage(sb);
                    displayPot();
                    bbActionFacingBet(betSize, betSize);
                    break;
                case 3:
                    sb.getHand().clear();
                    foldMessage(sb);
                    playerFolded = true;

                    break;
                default:
                    System.out.println("Invalid input.\n");
                    sbActionFacingBet(prevBetSize, betSize);
                    break;
            }
        }
    }

    public void sbActionCompleteBlind(int prevBetSize, int betSize) {
        //System.out.println(" ");
        if (raiseCount > 3) {
            if (sb.getName().equalsIgnoreCase("CPU")) {
                Random rand = new Random();
                action = rand.nextInt(2) + 1;
            } else {
                System.out.println("\nEnter 1 to CALL, 2 to FOLD.");
                action = scan.nextInt();
            }
            switch (action) {
                case 1:
                    pot = pot + (betSize / 2);
                    sb.setMoney(sb.getMoney() - prevBetSize);
                    callMessage(sb);
                    bbActionAfterComplete(betSize);
                    break;
                case 2:
                    sb.getHand().clear();
                    foldMessage(sb);
                    playerFolded = true;

                    break;
                default:
                    System.out.println("Invalid input.\n");
                    sbActionCompleteBlind(prevBetSize, betSize);
                    break;
            }

        } else {
            if (sb.getName().equalsIgnoreCase("CPU")) {
                Random rand = new Random();
                action = rand.nextInt(3) + 1;
            } else {
                System.out.println("\nEnter 1 to CALL, 2 to RAISE, 3 to FOLD.");
                action = scan.nextInt();
            }
            switch (action) {
                case 1:
                    pot = pot + prevBetSize;
                    sb.setMoney(sb.getMoney() - prevBetSize);
                    callMessage(sb);
                    bbActionAfterComplete(betSize);
                    break;
                case 2:
                    raiseCount++;
                    pot = pot + prevBetSize + betSize;
                    sb.setMoney(sb.getMoney() - prevBetSize - betSize);
                    raiseMessage(sb);
                    displayPot();
                    bbActionFacingBet(betSize, betSize);
                    break;
                case 3:
                    sb.getHand().clear();
                    foldMessage(sb);
                    playerFolded = true;

                    break;
                default:
                    System.out.println("Invalid input.\n");
                    sbActionCompleteBlind(prevBetSize, betSize);
                    break;
            }
        }
    }

    public void sbActionNoBet(int betSize){
        if (sb.getName().equalsIgnoreCase("CPU")) {
            Random rand = new Random();
            action = rand.nextInt(2) + 1;
        } else {
            System.out.println("\nEnter 1 to CHECK, 2 to BET, 3 to FOLD.");
            action = scan.nextInt();
        }
        switch (action) {
            case 1:
                checkMessage(sb);
                break;
            case 2:
                pot = pot + betSize;
                sb.setMoney(sb.getMoney() - betSize);
                betMessage(sb);
                displayPot();
                bbActionFacingBet(betSize, betSize);
                break;
            case 3:
                sb.getHand().clear();
                foldMessage(sb);
                playerFolded = true;

                break;
            default:
                System.out.println("Invalid input.\n");
                sbActionNoBet(betSize);
                break;
        }
    }

    public void bbActionFacingBet(int prevBetSize, int betSize) {
        //System.out.println(" ");
        if (raiseCount > 3) {
            if (bb.getName().equalsIgnoreCase("CPU")) {
                Random rand = new Random();
                action = rand.nextInt(2) + 1;
            } else {
                System.out.println("\nEnter 1 to CALL, 2 to FOLD.");
                action = scan.nextInt();
            }
            switch (action) {
                case 1:
                    pot = pot + prevBetSize;
                    bb.setMoney(bb.getMoney() - prevBetSize);
                    callMessage(bb);
                    break;
                case 2:
                    bb.getHand().clear();
                    foldMessage(bb);
                    playerFolded = true;

                    break;
                default:
                    System.out.println("Invalid input.\n");
                    bbActionFacingBet(prevBetSize, betSize);
                    break;
            }

        } else {
            if (bb.getName().equalsIgnoreCase("CPU")) {
                Random rand = new Random();
                action = rand.nextInt(3) + 1;
            } else {
                System.out.println("\nEnter 1 to CALL, 2 to RAISE, 3 to FOLD.");
                action = scan.nextInt();
            }
            switch (action) {
                case 1:
                    pot = pot + prevBetSize;
                    bb.setMoney(bb.getMoney() - prevBetSize);
                    callMessage(bb);
                    break;
                case 2:
                    raiseCount++;
                    pot = pot + prevBetSize + betSize;
                    bb.setMoney(bb.getMoney() - prevBetSize - betSize);
                    raiseMessage(bb);
                    displayPot();
                    sbActionFacingBet(betSize, betSize);
                    break;
                case 3:
                    bb.getHand().clear();
                    foldMessage(bb);
                    playerFolded = true;

                    break;
                default:
                    System.out.println("Invalid input.\n");
                    bbActionFacingBet(prevBetSize, betSize);
                    break;
            }
        }
    }

    /**
     * may need separate methods for dealing with preflop completed small blinds and other opportunities to check
     * @param betSize
     */
    public void bbActionAfterComplete(int betSize){
        //System.out.println(" ");
        if (bb.getName().equalsIgnoreCase("CPU")) {
            Random rand = new Random();
            action = rand.nextInt(2) + 1;
        } else {
            System.out.println("\nEnter 1 to CHECK, 2 to RAISE, 3 to FOLD.");
            action = scan.nextInt();
        }
        switch (action) {
            case 1:
                checkMessage(bb);
                break;
            case 2:
                raiseCount++;
                pot = pot + betSize;
                bb.setMoney(bb.getMoney() - betSize);
                raiseMessage(bb);
                displayPot();
                sbActionFacingBet(betSize, betSize);
                break;
            case 3:
                sb.getHand().clear();
                foldMessage(bb);
                playerFolded = true;

                break;
            default:
                System.out.println("Invalid input.\n");
                bbActionAfterComplete(betSize);
                break;
        }
    }

    public void bbActionNoBet(int betSize){
        if (bb.getName().equalsIgnoreCase("CPU")) {
            Random rand = new Random();
            action = rand.nextInt(2) + 1;
        } else {
            System.out.println("\nEnter 1 to CHECK, 2 to BET, 3 to FOLD.");
            action = scan.nextInt();
        }
        switch (action) {
            case 1:
                checkMessage(bb);
                sbActionNoBet(betSize);
                break;
            case 2:
                pot = pot + betSize;
                bb.setMoney(bb.getMoney() - betSize);
                betMessage(bb);
                displayPot();
                sbActionFacingBet(betSize, betSize);
                break;
            case 3:
                sb.getHand().clear();
                foldMessage(bb);
                playerFolded = true;

                break;
            default:
                System.out.println("Invalid input.\n");
                bbActionNoBet(betSize);
                break;
        }
    }

    public void determineWinner(){
        if (sb.getHand().size() < 1) {
            bb.setMoney(bb.getMoney() + pot);
            System.out.println(bb.getName() + " wins the $" + pot + " pot.");
            return;
        } else if (bb.getHand().size() < 1) {
            sb.setMoney(sb.getMoney() + pot);
            System.out.println(sb.getName() + " wins the $" + pot + " pot.");
            return;
        }

        Hand sbHand = getTopCombo(sb);
        Hand bbHand = getTopCombo(bb);
        System.out.println("\n" + board.getName() + ": " + board.getHand());
        System.out.println(sb.getName() + " has: " + sb.getHand() + " - " + sbHand.getRankName());
        System.out.println(bb.getName() + " has: " + bb.getHand()+ " - " + bbHand.getRankName());
        int winner = sbHand.compare(bbHand);
        switch (winner){
            case -1:
                bb.setMoney(bb.getMoney() + pot);
                System.out.println("\n" + bb.getName() + " wins the $" + pot + " pot.");
                break;
            case 0:
                bb.setMoney(bb.getMoney() + (pot/2));
                sb.setMoney(sb.getMoney() + (pot/2));
                System.out.println("\nThe $" + pot + "pot is split.");
                break;
            case 1:
                sb.setMoney(sb.getMoney() + pot);
                System.out.println("\n" + sb.getName() + " wins the $" + pot + " pot.");
                break;
        }

        //System.out.println(winner);

    }

    public void dealHoleCards() {
        sb.addCard(dealer.dealCard());
        bb.addCard(dealer.dealCard());
        sb.addCard(dealer.dealCard());
        bb.addCard(dealer.dealCard());
    }

    public void quit() {

    }

    public void runGame() {
        startGameMessage();

        while (continueLoop) {
            playerContinue();
        }

    }

    public Hand getTopCombo(Player _player){
        ArrayList handCombos = new ArrayList<Hand>();
        List<Card> sevenCards = new ArrayList<Card>(board.getHand());

        sevenCards.add(_player.getHandCard(0));
        sevenCards.add(_player.getHandCard(1));
//        System.out.println(sevenCards);
        int hLength = sevenCards.size();

        for(int i = 0; i < hLength - 4; i++)
            for(int j = i+1; j < hLength - 3; j++)
                for(int k = j+1; k < hLength - 2; k++)
                    for(int m = k+1; m < hLength - 1; m++)
                        for(int n = m+1; n < hLength; n++){
                            List<Card> cHand = new ArrayList<Card>();
                            cHand.add(sevenCards.get(i));
                            cHand.add(sevenCards.get(j));
                            cHand.add(sevenCards.get(k));
                            cHand.add(sevenCards.get(m));
                            cHand.add(sevenCards.get(n));
//                            System.out.println(cHand);
                            Hand oHand = new Hand(cHand);
                            handCombos.add(oHand);
//                            System.out.println(oHand.getHandValue());
//                            System.out.println(handCombos.size());
                        }
        Hand topHand = (Hand) handCombos.get(0);

        for (int x = 1; x < handCombos.size(); x++){
            Hand tempHand = (Hand) handCombos.get(x);
//            System.out.println(topHand + ":" + tempHand + ":" + tempHand.compare(topHand));
            if (tempHand.compare(topHand) == 1) {
                topHand = (Hand) handCombos.get(x);
            }
        }
        return topHand;
    }

    public static void main(String[] args) {
        Player aPlayer = new Player("Seth");
        PokerEngine game = new PokerEngine(aPlayer);
        game.runGame();
    }

}
