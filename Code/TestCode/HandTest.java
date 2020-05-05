import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class HandTest 
{
    @Test
    public void constructorIsNotNull()
    {
        Hand emptyHand = new Hand();
        Card[] cards = new Card[3];
        assertNotNull(emptyHand);
        assertNotNull(cards);
    }

    @Test
    public void handIsNotNull()
    {
    	Vector<Hand> hand = new Vector<>();
    	
    	assertNotNull(hand);
    }
    
    @Test
    public void addCardIsNotNull()
    {
    	Vector<Card> card = new Vector<>();
    	card.add(new Card(Suit.SPADE, Rank.ACE, 1));
    	
    	Hand newHand = new Hand(card);
    	
    	assertNotNull(newHand);
    }
    
    @Test
    public void ToStringIsNotNull()
    {
    	Vector<Card> card = new Vector<>();
    	Hand newHand = new Hand(card);
    	
    	assertNotNull(newHand.toString());
    }
    
    // to be worked on
    @Test
    public void toStringReturnsExpected()
    {
//    	Vector<Card> card = new Vector<>();
//    	card.add(new Card(Suit.HEART, Rank.KING, 10));
//    	card.add(new Card(Suit.HEART, Rank.JACK, 10));
//    	
//    	Hand newHand = new Hand(card);
//    	
//    	String tester = " [HEART - KING][HEART-JACK]";
//    	
//    	assertEquals(tester, newHand.toString());
    }
    
    // to be worked on
    @Test
    public void compareReturnsExpectedValue()
    {
    	Vector<Card> card = new Vector<>();
    	
    	card.add(new Card(Suit.HEART, Rank.KING, 10));
    	card.add(new Card(Suit.SPADE, Rank.ACE, 1));
    	
    	// ???    	
    }
    
    @Test
    public void testBlackjack()
    {
        Vector<Card> cards = new Vector<>();
        cards.add(new Card(Suit.SPADE, Rank.ACE, 1));
        cards.add(new Card(Suit.HEART, Rank.KING, 10));
        cards.add(new Card(Suit.DIAMOND, Rank.QUEEN, 10));
        Hand startingHand = new Hand(cards);
        assertTrue(startingHand.isBlackJack());
    }

    @Test
    public void testBust()
    {
        Vector<Card> cards = new Vector<>();
        cards.add(new Card(Suit.SPADE, Rank.SIX, 6));
        cards.add(new Card(Suit.HEART, Rank.EIGHT, 8));
        cards.add(new Card(Suit.CLUB, Rank.NINE, 9));
        Hand startingHand = new Hand(cards);
        assertTrue(startingHand.isBust());
    }
}