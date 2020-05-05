import java.util.Map;

public class GameState {

    private Hand dealerHand;
    private Map<String, Hand> playersHands;
    private Map<String, Balance> playersBalance;

    public GameState(Hand dHand, Map<String, Hand> psHands, Map<String, Balance> psBalance) {
        this.dealerHand = dHand;
        this.playersHands = psHands;
        this.playersBalance = psBalance;
    }

    public void UpdateDealerHand(Hand dHand) {
        this.dealerHand = dHand;
    }

    public void UpdatePlayerHand(Hand pHand, String username) {
        this.playersHands.replace(username, pHand);
    }

    public void UpdatePlayerBalance(Balance pBalance, String username) {
        this.playersBalance.replace(username, pBalance);
    }

    public Hand GetDealerHand() {
        return dealerHand;
    }
    public Map<String, Hand> GetPlayersHands() {
        return playersHands;
    }

    public Map<String, Balance> GetPlayersBalance() {
        return playersBalance;
    }
    
}