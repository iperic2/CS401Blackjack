import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Vector;

public class DealerTest
{
	// Test that dealer is not null.
	@Test
	public void dealerIsNotNull()
	{
		Dealer deal = new Dealer();
		
		assertNotNull(deal);
	}
	
	// Test getting ID is as expected.
	@Test
	public void setIsEqualToGet()
	{
		Dealer deal = new Dealer();
		
		String ID = "Iron Man";
		
		deal.setDealerID(ID);
		
		assertEquals(ID, deal.getDealerID());
	}
	
	// Test that setting dealer ID is not null.
	@Test
	public void setDealerIDIsNotNull()
	{
		Dealer deal = new Dealer();
		
		String ID = "Iron Man";
		
		deal.setDealerID(ID);
		
		assertNotNull(deal.getDealerID());
	}
	
	// Test that setting hand is not null.
	@Test
	public void setHandIsNotNull()
	{
		Vector<Card> cards = new Vector<>();
		Hand hand = new Hand(cards);
		
		assertNotNull(hand);
	}
}