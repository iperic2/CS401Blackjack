
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

	public double getHandSize()
	{
		return handSize;
	}

	public void setHand(card c)
	{
		card = c;
	}

	public void Display()
	{
		// display???
	}

	public double sizeLimit()
	{
		// return or set?
	}

	public String toString()
	{
		return username + " " + password +" " + money;
	}
}
