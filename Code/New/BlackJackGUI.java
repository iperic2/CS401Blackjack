import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Vector;

public class BlackJackGUI extends JPanel {

    private Player player;
    private DatabaseManagement db;
    private Game play;
    private int playerCardNumber;
    private int numPlayerHit;
    private int dealerCardNumber;
    private int numDealerHit;

    public BlackJackGUI() {
        player = new Player();
        db = new DatabaseManagement();
        numPlayerHit = 0;
        numDealerHit = 0;
    }

   final Runnable startApp = new Runnable() {
        @Override
        public void run() {
            JFrame homeFrame = new JFrame("CS401 Blackjack");
            JButton registerButton = new JButton("Sign Up");
            JButton loginButton = new JButton("Sign In");
            registerButton.setBounds(100, 50, 100, 50);
            loginButton.setBounds(100, 150, 100, 50);
            homeFrame.add(registerButton);
            homeFrame.add(loginButton);
            homeFrame.setSize(300, 300);
            homeFrame.setLayout(null);
            homeFrame.setLocationRelativeTo(null);
            homeFrame.setVisible(true);
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    homeFrame.setVisible(false);
                    login();
                    if(player.getUsername().isEmpty() || player.getPassword().isEmpty())
                        homeFrame.setVisible(true);
                    else
                        menu();
                }
            });

            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    homeFrame.setVisible(false);
                    register();
                    if(player.getUsername().isEmpty() || player.getPassword().isEmpty() || player.getEmail().isEmpty())
                        homeFrame.setVisible(true);
                    else
                        menu();
                }
            });
        }
    };

    public void login() {
        JFrame loginFrame = new JFrame();
        JFrame errorFrame = new JFrame();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(0, 2, 2, 2));

        JTextField nameField = new JTextField(10);
        JTextField passwordField = new JTextField(10);

        loginPanel.add(new JLabel("Username: "));
        loginPanel.add(nameField);

        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passwordField);

        boolean done = false;
        do {
            int option = JOptionPane.showConfirmDialog(loginFrame, loginPanel, "Sign in to CS401 Blackjack",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == 0) {
                player.setUsername(nameField.getText());
                player.setPassword(passwordField.getText());
            }
            else
                return;
            if(player.getUsername().isEmpty() || player.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(errorFrame, "Error! Username or password cannot be an empty string.",
                                              "Error Message", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            else if(db.loginVerify(player.getUsername(), player.getPassword()))
                done = true;
            else {
                JOptionPane.showMessageDialog(errorFrame, "Error! Incorrect username or password.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            player = db.getPlayer();
        } while(!done);
    }

    public void register() {
        Frame registerFrame = new JFrame();
        JFrame errorFrame = new JFrame();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(0, 2, 2, 2));

        JTextField nameField = new JTextField(10);
        JTextField passwordField = new JTextField(10);
        JTextField emailField = new JTextField(10);

        loginPanel.add(new JLabel("Username: "));
        loginPanel.add(nameField);

        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passwordField);

        loginPanel.add(new JLabel("Email: "));
        loginPanel.add(emailField);

        boolean done = false;
        do {
            int option = JOptionPane.showConfirmDialog(registerFrame, loginPanel, "Registration",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == 0) {
                player.setUsername(nameField.getText());
                player.setPassword(passwordField.getText());
                player.setEmail(emailField.getText());
            }
            else
                return;
            if(player.getUsername().isEmpty() || player.getPassword().isEmpty() || player.getEmail().isEmpty()) {
                JOptionPane.showMessageDialog(errorFrame, "Error! Username, password, or email cannot be an " +
                        "empty string.", "Error Message", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if(!db.isExist(player.getUsername(), player.getEmail())) {
                db.addNewUser(player.getUsername(), player.getPassword(), player.getEmail());
                player.setBalance(BigDecimal.valueOf(2500));
                done = true;
            }
            else
                JOptionPane.showMessageDialog(errorFrame, "Error! Username or email is taken.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
        } while(!done);
        JOptionPane.showMessageDialog(errorFrame, "Hello, " + player.getUsername() +
                        ".\nWelcome to CS401 Blackjack.\n" +
                        "You are rewarded with a sign-up bonus of $2500.",
                "Login Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void menu() {
        JFrame menuFrame = new JFrame("Main Menu");
        JButton playButton = new JButton("Play");
        JButton profileButton = new JButton("Profile");
        JButton exitButton = new JButton("Log Out");
        playButton.setBounds(100, 50, 100, 50);
        profileButton.setBounds(100, 150, 100, 50);
        exitButton.setBounds(100, 250, 100, 50);
        menuFrame.add(playButton);
        menuFrame.add(profileButton);
        menuFrame.add(exitButton);
        menuFrame.setSize(800, 600);
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                inGame();
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                profile();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                System.exit(0);
            }
        });
    }

    public void profile() {
        JFrame frame = new JFrame("Account Profile");
        JButton menuButton = new JButton("Main menu");
        JButton exitButton = new JButton("Log Out");
        menuButton.setBounds(650, 425, 100, 50);
        exitButton.setBounds(650, 500, 100, 50);

        JPanel userInfoPanel = new JPanel();
        JLabel infoLabel = new JLabel();
        infoLabel.setText("username: ");
        userInfoPanel.add(infoLabel);
        frame.add(userInfoPanel);

        frame.add(menuButton);
        frame.add(exitButton);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                menu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
                System.exit(0);
            }
        });
    }

    // In-game GUI
    public void inGame() {
        //to do: requires better alignment for panels 
        //ex: place bets & text field should be aligned left side of the window
        //needs actual game methods, randomly generated card display, win conditions, etc
        
        JPanel topPanel = new JPanel(); //button panel on top
        JPanel dealerPanel = new JPanel(); //dealer's cards panel in middle
        JPanel playerPanel = new JPanel(); //player's cards panel on bottom

        JButton betButton = new JButton();
        JButton dealButton = new JButton();
        JButton hitButton = new JButton();
        JButton holdButton = new JButton();

        JLabel dealerLabel = new JLabel();
        JLabel playerLabel = new JLabel();
        JLabel currentMoney = new JLabel();
        JLabel placeBets = new JLabel();

        JTextPane playerMoney = new JTextPane();
        JTextPane betMoney = new JTextPane();

        //Labels for card visuals
        JLabel playerCard1;
        JLabel playerCard2;
        Vector<JLabel> playerCardsHit = new Vector<>();
        JLabel dealerCard1;
        JLabel dealerCard2;
        Vector<JLabel> dealerCardsHit = new Vector<>();

        topPanel.setBackground(new Color(0, 125, 0));
        dealerPanel.setBackground(new Color(0, 125, 0));
        playerPanel.setBackground(new Color(0, 125, 0));

        topPanel.setLayout(new FlowLayout());
        //testing different layouts below
        //BoxLayout bl = new BoxLayout(playerPanel, BoxLayout.LINE_AXIS);
        //playerPanel.setLayout(bl);

        betButton.setText("Bet");
        dealButton.setText("Deal");
        dealButton.setEnabled(false);
        hitButton.setText("Hit");
        hitButton.setEnabled(false);
        holdButton.setText("Hold");
        holdButton.setEnabled(false);

        dealerLabel.setText("Dealer: ");
        dealerLabel.setFont(new java.awt.Font("Arial Bold", 1, 20));
        dealerLabel.setForeground(Color.black);
        playerLabel.setText("Player: ");
        playerLabel.setFont(new java.awt.Font("Arial Bold", 1, 20));
        playerLabel.setForeground(Color.black);
        placeBets.setText("Place bets: ");
        placeBets.setFont(new java.awt.Font("Arial Bold", 1, 20));
        placeBets.setForeground(Color.black);
        currentMoney.setText("Money: ");
        currentMoney.setFont(new java.awt.Font("Arial Bold", 1, 20));
        currentMoney.setForeground(Color.black);
        //currentMoney.setHorizontalAlignment(SwingConstants.RIGHT);

        topPanel.add(placeBets);
        betMoney.setText("$500"); //user should input bets here
        betMoney.setFont(new java.awt.Font("Arial Bold", 1, 20));
        topPanel.add(betMoney);
        //placeBets.setHorizontalAlignment(SwingConstants.LEFT);
        //placeBets.setVerticalAlignment(SwingConstants.BOTTOM);

        topPanel.add(betButton);
        topPanel.add(dealButton);
        topPanel.add(hitButton);
        topPanel.add(holdButton);

        dealerPanel.add(dealerLabel);

        currentMoney.setAlignmentX(LEFT_ALIGNMENT);
        playerPanel.add(currentMoney);
        playerMoney.setText(player.getBalance().toString()); //current acct's money should display here
        playerMoney.setFont(new java.awt.Font("Arial Bold", 1, 20));
        playerPanel.add(playerMoney);

        playerPanel.add(playerLabel);

        
        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(dealerPanel,BorderLayout.CENTER);
        add(playerPanel,BorderLayout.SOUTH);

        //Displays in-game GUI
        JFrame myFrame = new JFrame("BlackJack");
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(800,600));
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        play = new Game(1);
        //Button Methods below
        betButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
                //insert method for updating bet money
                dealButton.setEnabled(true);
                betButton.setEnabled(false);
                myFrame.setVisible(true);
            }
         });

        playerCard1 = new JLabel(new ImageIcon("back.jpg"));
        playerCard2 = new JLabel(new ImageIcon("back.jpg"));
        dealerCard1 = new JLabel(new ImageIcon("back.jpg"));
        dealerCard2 = new JLabel(new ImageIcon("back.jpg"));

        dealButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
                play.newGame();
                play.cardsDistribution();
                playerCardNumber = 2;
                dealerCardNumber = 2;
                dealerCard1.setIcon(getCardImage(getCardImagePath(play.getDealerHand().getCard(0))));
                playerCard1.setIcon(getCardImage(getCardImagePath(play.getPlayerHand().getCard(0))));
                playerCard2.setIcon(getCardImage(getCardImagePath(play.getPlayerHand().getCard(1))));
                dealerPanel.add(dealerCard1);
                dealerPanel.add(dealerCard2);
                playerPanel.add(playerCard1);
                playerPanel.add(playerCard2);
                hitButton.setEnabled(true);
                holdButton.setEnabled(true);
                dealButton.setEnabled(false);
                myFrame.setVisible(true);
            }
        });

        hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
                play.hit();
                JLabel playerCardHit = new JLabel();
                playerCardsHit.add(playerCardHit);
                playerCardsHit.elementAt(numPlayerHit++).setIcon(getCardImage(getCardImagePath(play.getPlayerHand().getCard(playerCardNumber++))));
                playerPanel.add(playerCardsHit.elementAt(numPlayerHit -  1));
                myFrame.setVisible(true);
            }
        });

        holdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    myFrame.setVisible(false);
                    play.dealerDraw();
                    JLabel playerCardHit = new JLabel();
                    playerCardsHit.add(playerCardHit);
                    dealerPanel.add(dealerCardsHit.elementAt(numDealerHit - 1));
                    myFrame.setVisible(true);
                }
            });
    }

    public void save() {

    }

    public String getCardImagePath(Card card) {
        String cardImagePath = "";
        switch(card.getSuit()) {
            case SPADE:
                cardImagePath = getRankString(card) + "s.jpg";
                break;
            case HEART:
                cardImagePath = getRankString(card) + "h.jpg";
                break;
            case CLUB:
                cardImagePath = getRankString(card) + "c.jpg";
                break;
            case DIAMOND:
                cardImagePath = getRankString(card) + "d.jpg";
                break;
        }
        return cardImagePath;
    }

    public ImageIcon getCardImage(String path) {
        ImageIcon cardImage = new ImageIcon(path);
        return cardImage;
    }

    public String getRankString(Card card) {
        String rankString = "";
        switch(card.getRank()) {
            case ACE:
                rankString = "ace";
                break;
            case TWO:
                rankString = "2";
                break;
            case THREE:
                rankString = "3";
                break;
            case FOUR:
                rankString = "4";
                break;
            case FIVE:
                rankString = "5";
                break;
            case SIX:
                rankString = "6";
                break;
            case SEVEN:
                rankString = "7";
                break;
            case EIGHT:
                rankString = "8";
                break;
            case NINE:
                rankString = "9";
                break;
            case TEN:
                rankString = "10";
                break;
            case JACK:
                rankString = "jack";
                break;
            case QUEEN:
                rankString = "queen";
                break;
            case KING:
                rankString = "king";
        }
        return rankString;
    }

    public Player getPlayer() {
        return player;
    }
}
