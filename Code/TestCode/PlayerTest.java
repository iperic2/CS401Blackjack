import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.Vector;

public class PlayerTest
{
	// Test player is not null.
	@Test
    public void PlayerIsNotNull()
	{
		Vector<Player> notEmpty = new Vector<>();
		
		assertNotNull(notEmpty);
		
		String user = "user";
		String pass = "pass";
		
        Player insertNotNull = new Player(user, pass, new Balance(2500, true));
        
        assertNotNull(insertNotNull);
    }
	
	// Test get player info returns expected.
	@Test
	public void PlayerSetInfoIsEqualToPlayerGetInfo()
	{
		Player tester = new Player("user","pass", new Balance(2500, true));
		
		String user = "user";
		String pass = "pass";	
		
		tester.setUsername(user);
		assertEquals(user, tester.getUsername());
		
		tester.setPassword(pass);
		assertEquals(pass, tester.getPassword());
		
		BigDecimal amount = new BigDecimal(2500);
		
		tester.setBalance(amount);
		assertEquals(amount, tester.getBalance());
	}

	// Test current money returns expected.
	// To be worked on.
	@Test
	public void GetCurrentMoneyReturnsExpectedValue()
	{
		
	}
	
	// Test creating player doesn't return null.
	@Test
	public void OnCreatePlayerDoesNotReturnNull()
	{
		String user = "user";
		String pass = "pass";
		
        Player onCreate = new Player(user, pass, new Balance(2500, true));
        
        assertNotNull(onCreate);
	}
	
	// Test hand doesn't return null.
	@Test
	public void SetHandReturnsNotNull()
	{
		Player tester = new Player("user","pass", new Balance(2500, true));
		Vector<Card> cards = new Vector<>();
		Hand hand = new Hand(cards);
		
		tester.setHand(hand);
	}
	
	// Test toString doesn't return null.
	@Test
	public void ToStringReturnsNotNull()
	{
		Player tester = new Player("user","pass", new Balance(2500, true));
		
		assertNotNull(tester.toString());
	}
}