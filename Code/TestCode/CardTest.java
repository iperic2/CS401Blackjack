import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest
{
    @Test
    public void testConstructor()
    {
        Card empty = new Card();
        Card kingSpade = new Card(Suit.SPADE, Rank.KING, 13);
        assertNotNull(empty);
        assertNotNull(kingSpade);
    } 

    @Test
    public void setIsNotNull()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
    	
    	assertNotNull(tester);
    }
    
    @Test
    public void suitIsEqualToGet()
    {
    	Card aceSpade = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Suit.SPADE, aceSpade.getSuit());
    }
    
    @Test
    public void rankIsEqualToGet()
    {
    	Card aceSpade = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Rank.ACE, aceSpade.getRank());
    }
    
    @Test
    public void valueIsEqualToGet()
    {
    	Card aceSpade = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(1, aceSpade.getValue());
    }
}
