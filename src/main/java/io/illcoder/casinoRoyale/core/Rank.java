package io.illcoder.casinoRoyale.core;

/**
 * Created by clouie on 9/22/15.
 * Adds all rank and numeric values for both poker and black jack for all possible cards
 */
public enum Rank {
    TWO(2,2), THREE(3,3), FOUR(4,4), FIVE(5,5), SIX(6,6), SEVEN(7,7), EIGHT(8,8), NINE(9,9), TEN(10,10), JACK(11,10),
    QUEEN(12,10), KING(13,10), ACE(14,11);

    private int pokerValue;
    private int blackjackValue;

    /**
     * Rank object Constructor that establishes the value type of poker and black jack
      * @param pokerValue
     * @param blackjackValue
     */
     Rank(int pokerValue, int blackjackValue){
        this.pokerValue = pokerValue;
        this.blackjackValue = blackjackValue;

    }

    /**
     * This function gets the numeric value for poker for a particular rank
      * @return int pokerValue is the numeric value to be used in the poker game
     */
    public int getPokerValue(){
        return this.pokerValue;
    }

    /**
     * This function gets the numeric value for black jack for a particular rank
     * @return int blackjackValue is the numeric value to be used in the black jack game
     */
    public int getBlackjackValue(){
        return this.blackjackValue;
    }

}

