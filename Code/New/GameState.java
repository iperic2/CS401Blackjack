import java.math.BigDecimal;
import java.util.HashMap;

public class GameState {

    private Hand dealerHand;
    private HashMap<String, Player> players;

    public GameState(Hand dHand, HashMap<String, Player> players) {
        this.dealerHand = dHand;
        this.players = players;
    }

    public void setDealerHand(Hand dHand) {
        this.dealerHand = dHand;
    }

    public void setPlayerHand(Hand pHand, String username) {
        this.players.get(username).setHand(pHand);
    }

    public void setPlayerBalance(BigDecimal pBalance, String username) {
        this.players.get(username).setBalance(pBalance);
    }

    public Hand getDealerHand() {
        return dealerHand;
    }
    public HashMap<String, Player> getPlayers() {
        return players;
    }

}