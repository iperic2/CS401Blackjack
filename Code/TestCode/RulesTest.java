import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RulesTest
{
	@Test
	public void notNull()
	{
		int playerValue = 3000;
		int dealerValue = 9001;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertNotNull(tester);		
	}

	@Test
	public void equalToNotNull()
	{
		// return 0 if equal
		int playerValue = 21;
		int dealerValue = 21;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertNotNull(tester.gameOutcome());
	}
	
	// the 3 below are to make sure each outcome returns the expected return.
	@Test
	public void equalToZero()
	{
		// return 0 if equal
		int playerValue = 21;
		int dealerValue = 21;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertEquals(0, tester.gameOutcome());
	}
	
	@Test
	public void equalToOne()
	{
		// return 1 if dealer > player
		int playerValue = 20;
		int dealerValue = 21;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertEquals(1, tester.gameOutcome());
	}
	
	@Test
	public void equalToTwo()
	{
		// return 2 if player > dealer
		int playerValue = 21;
		int dealerValue = 20;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertEquals(2, tester.gameOutcome());
	}
}