package test.illcoder.casinoRoyale;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by clouie on 9/23/15.
 */
public class CardTest {
    Card card = new Card(Suit.HEARTS, Rank.JACK);

    @Test
    public void getSuitTest(){


        assertEquals("Testing the value Card.HEART should return HEART", Suit.HEARTS, card.getSuit());
    }

    @Test
    public void getRankTest(){
        assertEquals("Testing the value Card.JACK should return JACK", Rank.JACK, card.getRank());
    }

    @Test
    public void getCardPokerValueTest(){
        assertEquals("Testing the cardPokerValue, Card.JACK should return int 11 ", 11, card.getCardPokerValue());
    }

    @Test
    public void getCardBlackjackValueTest(){
        assertEquals("Testing the cardBlackjackValue, Rank.JACK should return int 10 ", 10, card.getCardBlackjackValue());
    }
}
