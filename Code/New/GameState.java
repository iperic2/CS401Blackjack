import java.util.HashMap;

public class GameState
{
    private Hand dealerHand;
    private HashMap<String, Hand> playersHands;
    private HashMap<String, Balance> playersBalance;

    public GameState(Hand dHand, HashMap<String, Hand> psHands, HashMap<String, Balance> psBalance)
    {
        this.dealerHand = dHand;
        this.playersHands = psHands;
        this.playersBalance = psBalance;
    }

    public void UpdateDealerHand(Hand dHand)
    {
        this.dealerHand = dHand;
    }

    public void UpdatePlayerHand(Hand pHand, String username)
    {
        this.playersHands.replace(username, pHand);
    }

    public void UpdatePlayerBalance(Balance pBalance, String username)
    {
        this.playersBalance.replace(username, pBalance);
    }

    public Hand GetDealerHand()
    {
        return dealerHand;
    }
    public HashMap<String, Hand> GetPlayersHands()
    {
        return playersHands;
    }

    public HashMap<String, Balance> GetPlayersBalance()
    {
        return playersBalance;
    }
    
}