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
		GameState state = new GameState(dealerHand, playersHand);

		assertNotNull(state);
	}
	
	
	@Test
	public void dealerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		state.UpdateDealerHand(dealerHand);
		
		assertNotNull(state.GetDealerHand());
	}

	@Test
	public void playerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		String user = "user";
		
		state.UpdatePlayerHand(playersHand, user); // not working. to be worked on
		
		assertNotNull(state.GetPlayersHands());	
	}
	
	// below are to be worked on. 
	@Test
	public void getDealerHandReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertEquals(); // work on this
	}
	
	@Test
	public void getPlayersHandsReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Hand> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertEquals(); // work on this
	}
}
