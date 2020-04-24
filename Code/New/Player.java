import java.math.BigDecimal;

public class Player extends User{
	private String username;   // name of player and username 
	private String password;	// password for player
	private Balance balance;		//amount of money of player
	private Hand hand;
	
	public Player(String username,String password, Balance balance)
	{
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public void setUsername(String user)
	{
		this.username = user;
	}

	public String getUsername()
	{
		return username;
	}

	public void setPassword(String password)
	{
		password = password;
	}

	public String getPassword()
	{
		return password;
	}

	public void setBalance(BigDecimal amount) {
		this.balance.setBalance(amount);
	}

	public BigDecimal getBalance()
	{
		return balance.getAmount();
	}

	public void onCreatePlayer()
	{
		// create player
	}

	public void setHand(Hand hand)
	{
		this.hand = hand;
	}

	/* Does this method return the number of cards for the player?
	public double getHandSize()
	{

		return handSize;
	}
	*/

	/* Need to declare Card class first
	public void setHand(card c)
	{
		card = c;
	}
	*/

	public void Display()
	{
		// display???
	}

	/* What does this method do?
	public double sizeLimit()
	{
		// return or set?
	}
	*/

	public String toString()
	{
		return username + " " + password +" " + balance;
	}
}
