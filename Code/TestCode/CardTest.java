import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testConstructor() {
        Card empty = new Card();
        Card kingSpade = new Card("Spade", "King", 13);
        assertNotNull(empty);
        assertNotNull(kingSpade);
    }

    @Test
    public void testGetters() {
        Card aceSpade = new Card("Spade", "Ace", 1);
        assertEquals("Spade", aceSpade.getSuit());
        assertEquals("Ace", aceSpade.getRank());
        assertEquals(1, aceSpade.getValue());
    }

}