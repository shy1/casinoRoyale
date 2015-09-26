package io.illcoder.casinoRoyale.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sstrauss on 9/25/15.
 */
public class PlayerTest {
    Player player = new Player("Sean");
    Player player2 = new Player("Tariq");
    Card card = new Card(Suit.CLUBS, Rank.EIGHT);
    //List<Card> hand = new ArrayList<Card>();
    Dealer dealer = new Dealer();

    @Test
    public void testGetName() throws Exception {

        Assert.assertEquals("Test getter for name attribute.","Sean", player.getName());
    }

    @Test
    public void testGetMoney() throws Exception {

        Assert.assertEquals("Tests the getter for the money attribute",500, player.getMoney());
    }

    @Test
    public void testAddCard() throws Exception {
        player.addCard(card);
        Assert.assertEquals("Should add 1 card to hand.", 1, player.getHand().size());
        player.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        Assert.assertEquals("Should add 1 card to hand.", 2, player.getHand().size());

    }

    @Test
    public void testSetName() throws Exception {
        Assert.assertEquals("Sean", player.getName());
        player.setName("Tariq");
        Assert.assertEquals("Test that player has the correct name after setting", "Tariq", player.getName());
    }

    @Test
    public void testSetMoney() throws Exception {
        Assert.assertEquals(500, player.getMoney());
        player.setMoney(50);
        Assert.assertEquals("Test that the player has the correct amount of money after setting", 50, player.getMoney());
    }

    @Test
    public void testGetHand() throws Exception {

        for (int i = 0; i < 3; i++){
            player.addCard(dealer.dealCard());
        }
        Assert.assertEquals("Adds 3 cards to the hand list and makes sure hand array has a size of 3",3, player.getHand().size());
    }

    @Test
    public void testGetHandCard() throws Exception {
        player.addCard(card);
        player.addCard(new Card(Suit.DIAMONDS, Rank.JACK));
        Assert.assertEquals("Should display just the first card in hand", card, player.getHandCard(0));

    }


}