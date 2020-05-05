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
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Suit.SPADE, tester.getSuit());
    }
    
    @Test
    public void rankIsEqualToGet()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Rank.ACE, tester.getRank());
    }
    
    @Test
    public void valueIsEqualToGet()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(1, tester.getValue());
    }
    
    @Test
    public void ToStringReturnsNotNull()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
    	
    	assertNotNull(tester.toString());
    }
}