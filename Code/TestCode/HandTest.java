import org.junit.Test;
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
        Card[] cards = new Card[3];
        cards[0] = new Card("Spade", "Ace", 1);
        cards[1] = new Card("Heart", "King", 10);
        cards[2] = new Card("Diamond", "Queen", 10);
        Hand startingHand = new Hand(cards);
        assertTrue(startingHand.isBlackJack());
    }

    @Test
    public void testBust() {
        Card[] cards = new Card[3];
        cards[0] = new Card("Spade", "Six", 6);
        cards[1] = new Card("Heart", "Eight", 8);
        cards[2] = new Card("Diamond", "Nine", 9);
        Hand startingHand = new Hand(cards);
        assertTrue(startingHand.isBust());
    }

}