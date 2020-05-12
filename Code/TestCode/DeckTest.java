import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Vector;

public class DeckTest
{
	// Deck exists and is null?
	@Test
	public void DeckExistsAndIsNull()
	{

	}
	
	// Test that deck is not null.
    @Test 
    public void DeckExistsAndIsNotNull()
    {
    	Deck deck1 = new Deck();
		
		assertNotNull(deck1);
    }
    
    // Test that getting card is not null.
    @Test 
    public void GetCardIsNotNull()
    {
    	
    }
    
    // Test that creating 2 decks don't equal each other.
    @Test 
    public void CreateTwoDecksAndShouldNotBeEqualToEachOther()
    {
    	  	
    	Deck deck1 = new Deck();
    	Deck deck2 = new Deck();
    	
    	deck1.newDeck();
    	deck2.newDeck();
    	
    	assertNotEquals(deck1, deck2);
    }
    
    // Test that draws 2 cards that shouldn't equal each other.
    @Test 
    public void DrawTwoCardsAndShouldNotBeEqualToEachOther()
    {
    	
    }
    
    // Test that draw should only draw one card.
    @Test 
    public void StopDrawShouldStopDraw()
    {
    	
    }
    
    // Display card should only return suit and value.
    @Test 
    public void DisplayFrontSideShouldReturnSuitAndVal()
    {
    	
    }
    
    // Display backsided card should display amount of cards player has.
    @Test 
    public void DisplayBackSideShouldDisplayAmountOfCardsPlayerHas()
    {
    	
    }
    
    // Test that deck shouldn't be the same after a shuffle.
    @Test 
    public void ShuffleParameterObjectIsNotEqualToShuffleReturnObject()
    {
    	
    }
}