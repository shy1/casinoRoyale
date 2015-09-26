package test.illcoder.casinoRoyale;

import test.illcoder.casinoRoyale.Card;
import test.illcoder.casinoRoyale.Rank;
import test.illcoder.casinoRoyale.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by syoung on 9/22/15.
 *Build card deck to play poker or blackjack
 *
 */
public class Deck {
    List<Card> deck;

    /**
     * Creates a new array list for each Suit of cards 2 through Ace
     * when the Deck object is constructed
     */
    public Deck(){
        deck = new ArrayList();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
               deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles an arraylist of Card objects
     * @param _deck - the arraylist of cards to be shuffled
     */
    public void shuffleDeck(List<Card> _deck){
        Collections.shuffle(_deck);
    }

    /**
     * Shuffles the deck arraylist and returns it
     * @return deck - the shuffled arraylist
     */
    public List<Card> getShuffledDeck() {
        Collections.shuffle(deck);
        return deck;
    }
/* Added to test the delivery of the shuffled deck
/*    public static void main (String[] args){
        Deck deck1 = new Deck();
        List<Card> deck2 = deck1.getShuffledDeck();
        System.out.println(deck2.get(0));
        deck1.shuffleDeck(deck2);

        System.out.println(deck2.get(0));
    }
*/
}