
public class Player {
	private String username;   // name of player and username 
	private String password;	// password for player
	private double money;		//amount of money of player
	
	public Player(String username,String password, double money)
	{
		this.username = username;
		this.password = password;
		this.money = money;
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

	public double getCurrentMoney()
	{
		return money;
	}

	public void onCreatePlayer()
	{
		// create player
	}

	public void setHand()
	{
		// set hand
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
		return username + " " + password +" " + money;
	}
}
