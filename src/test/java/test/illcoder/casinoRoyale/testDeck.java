package test.illcoder.casinoRoyale;
import io.illcoder.casinoRoyale.core.Deck;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by gsuhocki on 9/24/15.
 * Test the getShuffledDeck function to verify the method works.
 */
public class TestDeck {


    Deck deck1 = new Deck();

        @Test
        public void getShuffledDeckTest(){
            List<Card> deck2 = deck1.getShuffledDeck();
            assertEquals("Testing that getShuffledDeck returns an array of cards with 52 members", 52, deck2.size());

        }

        @Test
        public void shuffleDeckTest(){
            List<Card> deck2 = deck1.getShuffledDeck();
            Card testCard = deck2.get(0);
            deck1.shuffleDeck(deck2);


            assertNotEquals("Testing that the first card of deck2 is different after running shuffleDeck", testCard, deck2.get(0));
        }
}

