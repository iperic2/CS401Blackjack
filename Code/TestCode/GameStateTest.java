import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class GameStateTest
{	
	@Test
	public void constructorIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);

		assertNotNull(state);
	}
	
	@Test
	public void dealerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertNotNull(state.getDealerHand());
		
	}

	@Test
	public void playerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertNotNull(state.getPlayers());
	}
	
	// below are to be worked on. 
	@Test
	public void getDealerHandReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertEquals(); // work on this
	}
	
	@Test
	public void getPlayersHandsReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertEquals(); // work on this
	}
}