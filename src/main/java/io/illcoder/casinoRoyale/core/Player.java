package io.illcoder.casinoRoyale.core;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by sstrauss on 9/24/15.
 * Player class that holds a name, amount of money, and a hand that is an ArrayList of Card objects.
 */
public class Player {
    private String name;
    private int money = 500;
    private List<Card> hand = new ArrayList<Card>();


    /**
     * Constructor with a name property.
     * @param name
     */
    public Player(String name){
        this.name = name;
    }

    /**
     * Default Constructor takes no inputs
     */
    public Player(){

    }

    /**
     * Returns the name attribute
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the players bankroll.
     * @return money attribute.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds a single card to the players hand
     * @param card is called from dealer.dealCard();
     */
    public void addCard(Card card) {
        this.hand.add(card);

    }

    /**
     * Allows player to change the value of the name attribute.
     * @param name change players name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the money attribute.
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Display the players hand.
     * @return hand - an ArrayList of Card objects
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Method is used in BlackJack game to display just one of the cpu players cards at the
     * beginning of the game to simulate how a real game of BlackJack begins with one card up.
     * @param _i - index of the which Card in the hand ArrayList to return
     * @return Card - the desired Card object
     */
    public Card getHandCard(int _i){
        return hand.get(_i);
    }




}

