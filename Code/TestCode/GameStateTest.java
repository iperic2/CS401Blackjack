import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class GameStateTest
{	
	@Test
	public void constructorIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);

		assertNotNull(state);
	}
	
	
	@Test
	public void dealerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);
		
		state.UpdateDealerHand(dealerHand);
		
		assertNotNull(state.GetDealerHand());
	}

	@Test
	public void playerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);
		
		String user = "user";
		
		state.UpdatePlayerHand(playersHand, user); // not working. to be worked on
		
		assertNotNull(state.GetPlayersHands());	
	}
	
	@Test
	public void PlayerBalanceIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);
		
		String user = "user";
		
		state.UpdatePlayerBalance(playersBalance, user); // not working. to be worked on.
		
		assertNotNull(state.GetPlayersBalance());
	}
	
	// below are to be worked on. 
	@Test
	public void getDealerHandReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);
		
		assertEquals(); // work on this
	}
	
	@Test
	public void getPlayersHandsReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);
		
		assertEquals(); // work on this
	}
	
	@Test
	public void getPlayerBalanceReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		HashMap<String, Balance> playersBalance = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand, playersBalance);
		
		assertEquals(); // work on this
	}
}