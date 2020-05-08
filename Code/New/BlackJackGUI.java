import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJackGUI extends JPanel {

    // GUI constructor
    public BlackJackGUI() {

    }

    public void home() {
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
                if(!login())
                    homeFrame.setVisible(true);
                else
                    menu();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                if(!register())
                    homeFrame.setVisible(true);
                else
                    menu();
            }
        });

    }

    public boolean register() {
        JFrame registerFrame = new JFrame();
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

        String username = "";
        String password = "";
        String email = "";
        boolean done = false;
        do {
            int option = JOptionPane.showConfirmDialog(registerFrame, loginPanel, "Registration",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == 0) {
                username = nameField.getText();
                password = passwordField.getText();
                email = emailField.getText();
            }
            else
                return false;
            if(username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(errorFrame, "Error! Username, password, or email cannot be an " +
                                              "empty string.", "Error Message", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            DatabaseManagement db = new DatabaseManagement();
            if(!db.isExist(username, email)) {
                db.addNewUser(username, password, email);
                done = true;
            }
            else
                JOptionPane.showMessageDialog(errorFrame, "Error! Username or email is taken.",
                                              "Error Message", JOptionPane.ERROR_MESSAGE);
        } while(!done);
        JOptionPane.showMessageDialog(errorFrame, "Hello, " + username +
                                      ".\nWelcome to CS401 Blackjack.\n" +
                                      "You are rewarded with a sign-up bonus of $2500.",
                                      "Login Message", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public boolean login() {
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

        String username = "";
        String password = "";
        boolean done = false;
        do {
            int option = JOptionPane.showConfirmDialog(loginFrame, loginPanel, "Sign in to CS401 Blackjack",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == 0) {
                username = nameField.getText();
                password = passwordField.getText();
            }
            else
                return false;
            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(errorFrame, "Error! Username or password cannot be an empty string.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            DatabaseManagement db = new DatabaseManagement();
            if(db.loginVerify(username, password))
                done = true;
            else
                JOptionPane.showMessageDialog(errorFrame, "Error! Incorrect username or password.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
        } while(!done);
        JOptionPane.showMessageDialog(errorFrame, "Hello, " + username + ".\nWelcome back to CS401 Blackjack.",
                                      "Login Message", JOptionPane.INFORMATION_MESSAGE);
            return true;
    }

    public void menu() {
        JFrame menuFrame = new JFrame("Main Menu");
        JButton playButton = new JButton("Play");
        JButton profileButton = new JButton("Profile");
        playButton.setBounds(100, 50, 100, 50);
        profileButton.setBounds(100, 150, 100, 50);
        menuFrame.add(playButton);
        menuFrame.add(profileButton);
        menuFrame.setSize(800, 800);
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                display();
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                profile();
            }
        });
    }

    public void profile() {

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
        JLabel playerCardHit;
        JLabel dealerCard1;
        JLabel dealerCard2;
        JLabel dealerCardHit;

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
        playerMoney.setText("$2500"); //current acct's money should display here
        playerMoney.setFont(new java.awt.Font("Arial Bold", 1, 20));
        playerPanel.add(playerMoney);

        playerPanel.add(playerLabel);

        
        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(dealerPanel,BorderLayout.CENTER);
        add(playerPanel,BorderLayout.SOUTH);

        //Displays in-game GUI
        JFrame myFrame = new JFrame("BlackJack");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(800,600));

        myFrame.pack();
        myFrame.setVisible(true);

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

        playerCard1 = new JLabel(new ImageIcon("CardImages/back.jpg"));
        playerCard2 = new JLabel(new ImageIcon("CardImages/back.jpg"));
        playerCardHit = new JLabel(new ImageIcon("CardImages/back.jpg")); //should be a randomly generated card
        dealerCard1 = new JLabel(new ImageIcon("CardImages/back.jpg"));
        dealerCard2 = new JLabel(new ImageIcon("CardImages/back.jpg"));
        dealerCardHit = new JLabel(new ImageIcon("CardImages/back.jpg")); //should be a randomly generated card

        dealButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
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
                playerPanel.add(playerCardHit);
                myFrame.setVisible(true);
            }
        });

        holdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    myFrame.setVisible(false);
                    dealerPanel.add(dealerCardHit);
                    myFrame.setVisible(true);
                }
            });

    }
}
