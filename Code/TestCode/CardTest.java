import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest
{
	// Test constructor is not null.
    @Test
    public void testConstructor()
    {
        Card empty = new Card();
        Card kingSpade = new Card(Suit.SPADE, Rank.KING, 13);
        assertNotNull(empty);
        assertNotNull(kingSpade);
    } 

    // Test that card will not be null.
    @Test
    public void setIsNotNull()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
    	
    	assertNotNull(tester);
    }
    
    // Test that suit is as expected.
    @Test
    public void suitIsEqualToGet()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Suit.SPADE, tester.getSuit());
    }
    
    // Test that rank is as expected.
    @Test
    public void rankIsEqualToGet()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(Rank.ACE, tester.getRank());
    }
    
    // Test that value is as expected.
    @Test
    public void valueIsEqualToGet()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
        assertEquals(1, tester.getValue());
    }
    
    // Test that to string is not null.
    @Test
    public void ToStringReturnsNotNull()
    {
    	Card tester = new Card(Suit.SPADE, Rank.ACE, 1);
    	
    	assertNotNull(tester.toString());
    }
}