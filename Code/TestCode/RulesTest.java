import org.junit.Test;
import static org.junit.Assert.*;

public class RulesTest
{
	// Test not null.
	@Test
	public void notNull()
	{
		int playerValue = 3000;
		int dealerValue = 9001;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertNotNull(tester);		
	}

	// Test that outcome is not null.
	@Test
	public void equalToNotNull()
	{
		// return 0 if equal
		int playerValue = 21;
		int dealerValue = 21;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertNotNull(tester.gameOutcome());
	}
	
	// Test outcome is equal to 0.
	@Test
	public void equalToZero()
	{
		// return 0 if equal
		int playerValue = 21;
		int dealerValue = 21;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertEquals(0, tester.gameOutcome());
	}
	
	// Test outcome is equal to 1.
	@Test
	public void equalToOne()
	{
		// return 1 if dealer > player
		int playerValue = 20;
		int dealerValue = 21;
		
		Rules tester = new Rules(dealerValue, playerValue);
		
		assertEquals(1, tester.gameOutcome());
	}
	
	// Test outcome is equal to 2.
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