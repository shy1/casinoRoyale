package test.illcoder.casinoRoyale;

import io.illcoder.casinoRoyale.core.Rank;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.*;
/**
 * Created by clouie on 9/22/15.
 */



public class RankTest {


    @Test
    public void getPokerValueTest(){
        assertEquals("Testing the value Rank.TWO should return 2", 2, Rank.TWO.getPokerValue());
        assertEquals("Testing the value Rank.THREE should return 3", 3, Rank.THREE.getPokerValue());
        assertEquals("Testing the value Rank.FOUR should return 4", 4, Rank.FOUR.getPokerValue());
        assertEquals("Testing the value Rank.FIVE should return 5", 5, Rank.FIVE.getPokerValue());
        assertEquals("Testing the value Rank.SIX should return 6", 6, Rank.SIX.getPokerValue());
        assertEquals("Testing the value Rank.SEVEN should return 7", 7, Rank.SEVEN.getPokerValue());
        assertEquals("Testing the value Rank.EIGHT should return 8", 8, Rank.EIGHT.getPokerValue());
        assertEquals("Testing the value Rank.NINE should return 9", 9, Rank.NINE.getPokerValue());
        assertEquals("Testing the value Rank.TEN should return 10", 10, Rank.TEN.getPokerValue());
        assertEquals("Testing the value Rank.JACK should return 11", 11, Rank.JACK.getPokerValue());
        assertEquals("Testing the value Rank.QUEEN should return 12", 12, Rank.QUEEN.getPokerValue());
        assertEquals("Testing the value Rank.KING should return 13", 13, Rank.KING.getPokerValue());
        assertEquals("Testing the value Rank.ACE should return 14", 14, Rank.ACE.getPokerValue());
    }

    @Test
    public void getBlackjackValueTest(){
        assertEquals("Testing the value Rank.TWO should return 2", 2, Rank.TWO.getBlackjackValue());
        assertEquals("Testing the value Rank.THREE should return 3", 3, Rank.THREE.getBlackjackValue());
        assertEquals("Testing the value Rank.FOUR should return 4", 4, Rank.FOUR.getBlackjackValue());
        assertEquals("Testing the value Rank.FIVE should return 5", 5, Rank.FIVE.getBlackjackValue());
        assertEquals("Testing the value RANK.SIX should return 6", 6, Rank.SIX.getBlackjackValue());
        assertEquals("Testing the value Rank.SEVEN should return 7", 7, Rank.SEVEN.getBlackjackValue());
        assertEquals("Testing the value Rank.EIGHT should return 8", 8, Rank.EIGHT.getBlackjackValue());
        assertEquals("Testing the value Rank.NINE should return 9", 9, Rank.NINE.getBlackjackValue());
        assertEquals("Testing the value Rank.TEN should return 10", 10, Rank.TEN.getBlackjackValue());
        assertEquals("Testing the value Rank.JACK should return 10", 10, Rank.JACK.getBlackjackValue());
        assertEquals("Testing the value Rank.QUEEN should return 10", 10, Rank.QUEEN.getBlackjackValue());
        assertEquals("Testing the value Rank.KING should return 10", 10, Rank.KING.getBlackjackValue());
        assertEquals("Testing the value Rank.ACE should return 11", 11, Rank.ACE.getBlackjackValue());

    }



}
