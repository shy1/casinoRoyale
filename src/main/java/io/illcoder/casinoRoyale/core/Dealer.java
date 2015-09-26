package io.illcoder.casinoRoyale.core;

import java.util.Collections;
import java.util.List;

/**
 * Created by syoung on 9/22/15.
 */
public class Dealer {

    private Deck deck = new Deck();
    private List<Card> cardDeck = deck.getShuffledDeck();
    private int cardIndex = 0;
    public Dealer(){

    }



    /**
     * Starts a game depending on the gameType argument that is passed.
     *
     *
    public void startGame(int _gametype, Player _user) {
        switch (_gametype) {
            case 1:
                BlackjackEngine game = new BlackjackEngine;
                game.runGame(_user);
                break;
            case 2:
                PokerEngine game = new PokerEngine;
                game.runGame(_user);
                break;
        }
     }
*/

    /**
     * Deals a single card from the deck array and increments
     * the cardIndex counter to prevent same card from being dealt again
     * @return topCard - the next card object in the deck
     */
    public Card dealCard() {
        Card topCard = cardDeck.get(cardIndex);
        cardIndex++;
        return topCard;
    }

    /**
     * Shuffles the cardDeck arraylist by calling the deck class's shuffleDeck function
     */
    public void shuffleDeck() {
        deck.shuffleDeck(cardDeck);
    }

    /**
     * Returns the card object from cardDeck with the index specified in the idx argument
     * @param idx - index of the desired card in the cardDeck arraylist
     * @return Card - the card with the specified index
     */
    public Card getCardByIndex(int idx) {
        return cardDeck.get(idx);
    }



}