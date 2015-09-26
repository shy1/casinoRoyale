package io.illcoder.casinoRoyale.core;
//import io.illcoder.casinoRoyale.core.CardValues
//import io.illcoder.casinoRoyale.core.Suit;

/**
 * Created by syoung on 9/22/15.
 */

public class Card {
    //CardValues cv = new CardValues();
    //private CardValues.Suit suit;
    //private CardValues.Rank rank;

    private Suit suit;
    private Rank rank;

    private int cardPokerValue;
    private int cardBlackjackValue;

    /**
     * Constructor for the Card class that establishes the value for suit and rank.
     * It also gets the Poker numeric value and the Blackjack numeric value which pulls from the Rank class.
     * @param suit
     * @param rank
     */
     Card(Suit suit, Rank rank){

        this.suit = suit;
        this.rank = rank;
        this.cardPokerValue = this.rank.getPokerValue();
        this.cardBlackjackValue = this.rank.getBlackjackValue();
    }

    /**
     * This function gets the suit value for the cards
     * @return
     */
    public Suit getSuit(){
        return this.suit;
    }

    /**
     * This function gets the rank value for the cards
     * @return
     */
    public Rank getRank(){
        return this.rank;
    }

    /**
     * This function gets the numeric value for poker for a particular rank
     * @return int cardPokerValue is the numeric value to be used in the poker game
     */
    public int getCardPokerValue(){
        return cardPokerValue;
    }

    /**
     * This function gets the numeric value for blackjack for a particular rank
     * @return int cardBlackjackValue is the numeric value to be used in the poker game
     */
    public int getCardBlackjackValue(){
        return cardBlackjackValue;
    }

    /**
     * This function displays the rank and suit of the shuffled card
     * @return
     */
    public String toString(){
        return "This Card is the " + rank + " of " + suit;
    }


}
