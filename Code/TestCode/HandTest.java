import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void testConstructors() {
        Hand emptyHand = new Hand();
        Card[] cards = new Card[3];
        assertNotNull(emptyHand);
        assertNotNull(cards);
    }

    @Test
    public void testBlackjack() {
        Vector<Card> cards = new Vector<>();
        cards.add(new Card(Suit.SPADE, Rank.ACE, 1));
        cards.add(new Card(Suit.HEART, Rank.KING, 10));
        cards.add(new Card(Suit.DIAMOND, Rank.QUEEN, 10));
        Hand startingHand = new Hand(cards);
        assertTrue(startingHand.isBlackJack());
    }

    @Test
    public void testBust() {
        Vector<Card> cards = new Vector<>();
        cards.add(new Card(Suit.SPADE, Rank.SIX, 6));
        cards.add(new Card(Suit.HEART, Rank.EIGHT, 8));
        cards.add(new Card(Suit.CLUB, Rank.NINE, 9));
        Hand startingHand = new Hand(cards);
        assertTrue(startingHand.isBust());
    }

}