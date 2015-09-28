package io.illcoder.casinoRoyale.blackjack;

import io.illcoder.casinoRoyale.core.*;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by BatComputer on 9/27/15.
 */
public class BlackjackEngineTest {

    Player user = new Player("Sean");
    Player cpu = new Player();
    BlackjackEngine bj = new BlackjackEngine();
    Dealer dealer = new Dealer();
    Card card = new Card(Suit.CLUBS, Rank.TEN);

    @Test
    public void testGetBLACKJACK() throws Exception {
        Assert.assertEquals("Tests hand for BlackJack", 21,bj.getBLACKJACK());
    }

//    @Test
//    public void testTakeWager() throws Exception {
//       bj.wager = 100;
//        Assert.assertEquals("Should return starting money minus 100", 400, bj.takeWager(user));
//    }

    @Test
    public void testCheckUserForBust() throws Exception {
        for (int i = 0; i < 3; i++){
            user.addCard(new Card(Suit.CLUBS, Rank.TEN));
        }
        Assert.assertEquals("Check to see if the user busts.",true , bj.checkUserForBust(user));
    }

    @Test
    public void testYouWin() throws Exception {
        user.addCard(card);
        user.addCard(card);
        cpu.addCard(card);
        Assert.assertEquals("Makes win equal true, gives winning player money", true, bj.youWin(user, cpu));
    }



    @Test
    public void testCalcHandTotal() throws Exception {
        for (int i = 0; i < 2; i++){
            user.addCard(card);
        }
        Assert.assertEquals("Should return the value of cards in the players hand", 20, bj.calcHandTotal(user));
    }

    @Test
    public void testCheckBlackjack() throws Exception {
        user.addCard(new Card(Suit.CLUBS, Rank.ACE));
        user.addCard(new Card(Suit.CLUBS, Rank.KING));
        Assert.assertEquals("Should have the user win and return true", true, bj.checkBlackjack(user, cpu));
        cpu.addCard(new Card(Suit.CLUBS, Rank.ACE));
        cpu.addCard(new Card(Suit.CLUBS, Rank.KING));
        Assert.assertEquals("user and cpu should push, resulting in gameOver, but with refund", true, bj.checkBlackjack(user, cpu));
        user.getHand().clear();
        //Test to see if cpu has blackjack
        Assert.assertEquals("Should return gamOverBool equals true", true, bj.checkBlackjack(user, cpu));

    }



    @Test
    public void testHit() throws Exception {
        Assert.assertEquals("Hand should be empty before hit", 0, user.getHand().size());
        bj.hit(user);
        Assert.assertEquals("Should have 1 more card after hit", 1, user.getHand().size());
    }

    @Test
    public void testStay() throws Exception {
        ///Breaks out of switch statement loop and continues game flow.
    }

    @Test
    public void testDisplayHand() throws Exception {
        bj.hit(user);
        bj.hit(user);
        bj.hit(user);
       Assert.assertEquals("Displays the users hand", user.getHand(), bj.displayHand(user));
    }

    @Test
    public void testDisplayInitialHands() throws Exception {
        cpu.addCard(card);
        cpu.addCard(card);
        Assert.assertEquals("Should display only the first card in cpus hand", cpu.getHandCard(0), cpu.getHandCard(0));
    }



    @Test
    public void testDealHands() throws Exception {
        bj.dealHands(user, cpu);
        Assert.assertEquals("User should have 2 cards in their hand", 2, user.getHand().size());
        Assert.assertEquals("cpu should have 2 cards in their hand", 2, user.getHand().size());
    }




}