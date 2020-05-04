public class Dealer
{
	private String dealerID;
	private Hand hand;

	public Dealer() 
	{
		dealerID = "";
	}

	public Dealer(String id)
	{
		dealerID = id;
	}

	public void setHand(Hand hand)
	{
		this.hand = hand;
	}

	public void setDealerID(String dealerID)
	{
		this.dealerID = dealerID;
	}

	public String getDealerID()
	{
		return dealerID;
	}

	public void drawCard()
	{

	}
}