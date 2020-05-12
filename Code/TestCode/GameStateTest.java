import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

public class GameStateTest
{
	// Test constructor is not null.
	@Test
	public void constructorIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);

		assertNotNull(state);
	}
	
	// Test that dealer hand is not null.
	@Test
	public void dealerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertNotNull(state.getDealerHand());
		
	}

	// Test player hand is not null.
	@Test
	public void playerHandIsNotNull()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertNotNull(state.getPlayers());
	}
	
	// Test that dealer hand returns expected.
	@Test
	public void getDealerHandReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertEquals(); // work on this
	}
	
	// Test that player hand returns expected.
	@Test
	public void getPlayersHandsReturnsExpected()
	{
		Hand dealerHand = new Hand();
		HashMap<String, Player> playersHand = new HashMap<>();
		GameState state = new GameState(dealerHand, playersHand);
		
		assertEquals(); // work on this
	}
}