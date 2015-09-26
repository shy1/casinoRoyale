package test.illcoder.casinoRoyale;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by syoung on 9/25/15.
 */
public class DealerTest {
    Dealer dealer = new Dealer();

    @Test
    public void dealCardTest() {
/*        for (int i = 0; i < 10; i++) {
            Card card1 = dealer.dealCard();
            System.out.println(card1.getRank() + ":" + card1.getSuit());
        }
*/
        Card card2 = dealer.dealCard();
        //System.out.println(card2.getRank() + ":" + card2.getSuit());
        assertNotEquals("Test that running dealCard returns different cards each time", card2, dealer.dealCard());
    }
    @Test
    public void shuffleDeckTest(){
        Card testCard = dealer.getCardByIndex(0);
        dealer.shuffleDeck();

        Card testCard2 = dealer.getCardByIndex(0);
        System.out.println(testCard.getRank() + ":" + testCard.getSuit());
        System.out.println(testCard2.getRank() + ":" + testCard2.getSuit());

        assertNotEquals("Testing that the first card of the dealer's deck is different after running shuffleDeck", testCard, dealer.getCardByIndex(0));
    }
}
