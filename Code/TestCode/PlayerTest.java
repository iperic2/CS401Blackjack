import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class PlayerTest {

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
		
		// to be worked on
//		tester.setBalance(amount);
//		assertEquals(amount, tester.getBalance());
	}

	@Test
	public void GetCurrentMoneyReturnsExpectedValue()
	{
		// to be worked on
	}
	
	@Test
	public void OnCreatePlayerDoesNotReturnNull()
	{
		String user = "user";
		String pass = "pass";
		
        Player onCreate = new Player(user, pass, new Balance(2500, true));
        
        assertNotNull(onCreate);
	}
	
	@Test
	public void SetHandReturnsNotNull()
	{
		Player tester = new Player("user","pass", new Balance(2500, true));
		Vector<Card> cards = new Vector<>();
		Hand hand = new Hand(cards);
		
		tester.setHand(hand);
	}
	
	@Test
	public void ToStringReturnsNotNull()
	{
		Player tester = new Player("user","pass", new Balance(2500, true));
		
		assertNotNull(tester.toString());
	}
}