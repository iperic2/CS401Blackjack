import java.math.BigDecimal;

public class Player extends User{

	private BigDecimal balance;		//amount of money of player
	private Hand hand;

	public  Player() {
		balance = new BigDecimal(0);
		hand = new Hand();
	}

	public Player(BigDecimal balance)
	{
		this.balance = balance;
	}

	public void setBalance(BigDecimal amount) {
		this.balance = amount;
	}

	public BigDecimal getBalance()
	{
		return balance;
	}

	public void setHand(Hand hand)
	{
		this.hand = hand;
	}

	public Hand getHand() {
		return hand;
	}

}
