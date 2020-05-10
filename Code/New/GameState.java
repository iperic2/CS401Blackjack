import java.util.HashMap;

public class GameState
{
    private Hand dealerHand;
    private HashMap<String, Hand> playersHands;

    public GameState(Hand dHand, HashMap<String, Hand> psHands)
    {
        this.dealerHand = dHand;
        this.playersHands = psHands;
    }

    public void UpdateDealerHand(Hand dHand)
    {
        this.dealerHand = dHand;
    }

    public void UpdatePlayerHand(Hand pHand, String username)
    {
        this.playersHands.replace(username, pHand);
    }

    public Hand GetDealerHand()
    {
        return dealerHand;
    }
    public HashMap<String, Hand> GetPlayersHands()
    {
        return playersHands;
    }
}