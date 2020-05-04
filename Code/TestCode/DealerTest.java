import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class DealerTest
{
	@Test
	public void dealerIsNotNull()
	{
		Dealer deal = new Dealer();
		
		assertNotNull(deal);
	}
	

	// for some reason, this is failing.
	// to be worked on.
	@Test
	public void setIsEqualToGet()
	{
		Dealer deal = new Dealer();
		
		String ID = "Iron Man";
		
		deal.setDealerID("ID");
		
		assertEquals(ID, deal.getDealerID());
	}

	@Test
	public void handIsNotNull()
	{
		Vector<Card> cards = new Vector<>();
		Hand hand = new Hand(cards);
		
		assertNotNull(hand);
	}
}