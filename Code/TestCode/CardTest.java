import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testConstructor() {
        Card empty = new Card();
        Card kingSpade = new Card(Suit.SPADE, Rank.KING, 13);
        assertNotNull(empty);
        assertNotNull(kingSpade);
    }

    @Test
    public void testGetters() {
        Card aceSpade = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Suit.SPADE, aceSpade.getSuit());
        assertEquals(Rank.ACE, aceSpade.getRank());
        assertEquals(1, aceSpade.getValue());
    }

}