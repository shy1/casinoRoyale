package io.illcoder.casinoRoyale.poker;

import io.illcoder.casinoRoyale.core.Card;
import io.illcoder.casinoRoyale.core.Dealer;
import io.illcoder.casinoRoyale.core.Rank;
import io.illcoder.casinoRoyale.core.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by seth on 9/28/2015.
 * class to evaluate hand strength
 */
public class Hand {

    private int[] value;
    private static List<Card> hand1 = new ArrayList<Card>();
    private static List<Card> hand2 = new ArrayList<Card>();
    List<Card> theHand;

//    public Hand(List<Card> _hand) {
//        theHand = _hand;
//        value = new int[6];
//
//
//
//        int[] cardRanks = new int[15];
//
//        for (int i = 0; i < 15; i++) {
//            cardRanks[i] = 0;
//        }
//
//        for (int j = 0; j < 5; j++){
//            Card card = theHand.get(j);
//            cardRanks[card.getCardPokerValue()]++;
//            System.out.println(card.getCardPokerValue());
//        }
//    }

    public Hand(List<Card> _hand) {
        //Dealer dealer = new Dealer();
        value = new int[6];
        // theHand = new ArrayList<Card>();
        // List<Card> hand2 = new ArrayList<Card>();
        int sameRanks = 1;
        int sameRanks2 = 1;
        int smallRankValue = 0;
        int largeRankValue = 0;
        boolean flush = true;
        boolean straight = false;
        int topStraightRank = 0;
        int[] highCardRanks = new int[5];
        int idx = 0;

//        for (int k = 0; k < 5; k++){
//            theHand.add(dealer.dealCard());
//        }
        theHand = _hand;

        // array to hold counts of each card rank
        int[] cardRanks = new int[15];

        for (int i = 0; i < 15; i++) {
            cardRanks[i] = 0;
        }

        // loop through the 5 cards counting those with the same rank and
        // checking for a flush
        for (int j = 0; j < 5; j++){
            //Card card = theHand.get(j);
            cardRanks[theHand.get(j).getCardPokerValue()]++;
            if (j < 4){
                if (theHand.get(j).getSuit() != theHand.get(j + 1).getSuit()){
                    flush = false;
                }
            }
//            System.out.println(theHand.get(j).getCardPokerValue() + ":" + theHand.get(j).getSuit());

        }
//        System.out.println(Arrays.toString(cardRanks));
//        System.out.println(flush);

        for (int n = 2; n < 11; n++){
            if (cardRanks[n] == 1 && cardRanks[n+1] == 1 && cardRanks[n+2] == 1 && cardRanks[n+3] == 1 && cardRanks[n+4] == 1){
                straight = true;
                topStraightRank = n + 4;
                break;
            }
        }

        // check for A-5 wheel straight
        if (cardRanks[14] == 1 && cardRanks[2] == 1 && cardRanks[3] == 1 && cardRanks[4] == 1 && cardRanks[5] == 1){
            straight = true;
            topStraightRank = 5;
        }
//        System.out.println(straight + ":" + topStraightRank);
        // goes through cardRanks array and records any pairs, trips, or quads
        for (int m = 14; m > 1; m--){
            if (cardRanks[m] > sameRanks){
                if (sameRanks != 1){
                    sameRanks2 = sameRanks;
                    smallRankValue = largeRankValue;
                }
                sameRanks = cardRanks[m];
                largeRankValue = m;
            } else if (cardRanks[m] > sameRanks2){
                sameRanks2 = cardRanks[m];
                smallRankValue = m;
            }

            if (cardRanks[m] == 1){
                highCardRanks[idx] = m;
                idx++;
            }
        }
//        System.out.println(sameRanks + ":" + largeRankValue + "\n" + sameRanks2 + ":" + smallRankValue);
//        System.out.println(Arrays.toString(highCardRanks));

        /**
         * assign hand rankings
         */

        // no pair
        if (sameRanks == 1){
            value[0] = 1;
            value[1] = highCardRanks[0];
            value[2] = highCardRanks[1];
            value[3] = highCardRanks[2];
            value[4] = highCardRanks[3];
            value[5] = highCardRanks[4];
        }

        // one pair
        if(sameRanks == 2 && sameRanks2 == 1){
            value[0] = 2;
            value[1] = largeRankValue;
            value[2] = highCardRanks[0];
            value[3] = highCardRanks[1];
            value[4] = highCardRanks[2];
        }

        // two pair
        if(sameRanks == 2 && sameRanks2 == 2){
            value[0] = 3;
            value[1] = largeRankValue > smallRankValue ? largeRankValue : smallRankValue;
            value[2] = largeRankValue < smallRankValue ? largeRankValue : smallRankValue;
            value[3] = highCardRanks[0];
        }

        // trips
        if(sameRanks == 3 && sameRanks2 != 2){
            value[0] = 4;
            value[1] = largeRankValue;
            value[2] = highCardRanks[0];
            value[3] = highCardRanks[1];
        }

        if(straight){
            value[0] = 5;
            value[1] = topStraightRank;
        }

        if(flush){
            value[0] = 6;
            value[1] = highCardRanks[0];
            value[2] = highCardRanks[1];
            value[3] = highCardRanks[2];
            value[4] = highCardRanks[3];
            value[5] = highCardRanks[4];
        }

        // full house
        if(sameRanks == 3 && sameRanks2 == 2){
            value[0]=7;
            value[1]=largeRankValue;
            value[2]=smallRankValue;
        }

        // quads
        if (sameRanks == 4){
            value[0] = 8;
            value[1] = largeRankValue;
            value[2] = highCardRanks[0];
        }

        // straight flush
        if (straight && flush){
            value[0] = 9;
            value[1] = topStraightRank;
        }
    }

    public int getHandValue(){
        return value[0];
    }

    public int compare(Hand compHand) {
        for (int i = 0; i < 6; i++){
            if (this.value[i] > compHand.value[i])
                return 1;
            else if (this.value[i]< compHand.value[i])
                return -1;
        }
        return 0;
    }

    public String toString(){
        return theHand + ":" + value[0] + ":" + value[1];
    }

    public String getRankName(){
        String rankName;
        switch (value[0]){
            case 1:
                rankName = "High Card";
                break;
            case 2:
                rankName = "One Pair";
                break;
            case 3:
                rankName = "Two Pair";
                break;
            case 4:
                rankName = "Three of a Kind";
                break;
            case 5:
                rankName = "Straight";
                break;
            case 6:
                rankName = "Flush";
                break;
            case 7:
                rankName = "Full House";
                break;
            case 8:
                rankName = "Four of a Kind";
                break;
            case 9:
                rankName = "Straight Flush";
                break;
            default:
                rankName = "Error: Unknown Hand Ranking";
                break;
        }
        return rankName;
    }
//    public static void main(String[] args) {
//
//
//        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
//        Card card2 = new Card(Suit.CLUBS, Rank.TEN);
//        Card card3 = new Card(Suit.CLUBS, Rank.KING);
//        Card card4 = new Card(Suit.CLUBS, Rank.QUEEN);
//        Card card5 = new Card(Suit.CLUBS, Rank.JACK);
//        hand1.add(card1);
//        hand1.add(card2);
//        hand1.add(card3);
//        hand1.add(card4);
//        hand1.add(card5);
//
//        Card card11 = new Card(Suit.CLUBS, Rank.ACE);
//        Card card22 = new Card(Suit.CLUBS, Rank.TEN);
//        Card card33 = new Card(Suit.CLUBS, Rank.JACK);
//        Card card44 = new Card(Suit.CLUBS, Rank.KING);
//        Card card55 = new Card(Suit.CLUBS, Rank.QUEEN);
//        hand2.add(card11);
//        hand2.add(card22);
//        hand2.add(card33);
//        hand2.add(card44);
//        hand2.add(card55);
//
//        Hand handOne = new Hand(hand1);
//        Hand handTwo = new Hand(hand2);
//        System.out.println(handOne.compare(handTwo));
//    }
}
