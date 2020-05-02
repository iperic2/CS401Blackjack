import java.util.Vector;

public class BlackJackDriver {
    public static void main(String[] args){

    /*BlackJackGUI frame = new BlackJackGUI();
    frame.display();*/

    Vector<Player> players = new Vector<>();
    players.add(new Player("Alex", "abc", new Balance(2500, true)));
    Dealer dealer = new Dealer();
    Game game = new Game(dealer, players, 1);
    game.newTable();

    /*Vector<Card>cards = new Vector<>();
    cards.add(new Card(Suit.SPADE, Rank.ACE, Rank.ACE.getValue()));
    cards.add(new Card(Suit.SPADE, Rank.EIGHT, Rank.EIGHT.getValue()));
    cards.add(new Card(Suit.SPADE, Rank.TWO, Rank.TWO.getValue()));
    cards.add(new Card(Suit.HEART, Rank.ACE, Rank.ACE.getValue()));
    cards.add(new Card(Suit.CLUB, Rank.ACE, Rank.ACE.getValue()));
    cards.add(new Card(Suit.DIAMOND, Rank.ACE, Rank.ACE.getValue()));

    Hand hand = new Hand(cards);
    System.out.println(hand.handValue());*/

  }
}
