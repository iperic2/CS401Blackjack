import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class DeckTest
{
	@Test
	public void DeckExistsAndIsNull()
	{
		// this fails...???
//		Deck deck1 = new Deck();
//		
//		assertNull(deck1);
	}
	
    @Test 
    public void DeckExistsAndIsNotNull()
    {
    	Deck deck1 = new Deck();
		
		assertNotNull(deck1);
    }
    
    @Test 
    public void GetCardIsNotNull()
    {
    	
    }
    
    @Test 
    public void CreateTwoDecksAndShouldNotBeEqualToEachOther()
    {
    	  	
    	Deck deck1 = new Deck();
    	Deck deck2 = new Deck();
    	
    	deck1.newDeck();
    	deck2.newDeck();
    	
    	assertNotEquals(deck1, deck2);
    }
    
    @Test 
    public void DrawTwoCardsAndShouldNotBeEqualToEachOther()
    {
    	
    }
    
    @Test 
    public void StopDrawShouldStopDraw()
    {
    	
    }
    @Test 
    public void DisplayFrontSideShouldReturnSuitAndVal()
    {
    	
    }
    
    @Test 
    public void DisplayBackSideShouldDisplayAmountOfCardsPlayerHas()
    {
    	
    }
    
    @Test 
    public void ShuffleParameterObjectIsNotEqualToShuffleReturnObject()
    {
    	
    }
}
