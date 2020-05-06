import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJackGUI extends JPanel {

    JPanel topPanel = new JPanel(); //button panel on top
    JPanel dealerPanel = new JPanel(); //dealer's cards panel in middle
    JPanel playerPanel = new JPanel(); //player's cards panel on bottom

    JButton dealButton = new JButton();
    JButton hitButton = new JButton();
    JButton holdButton = new JButton();

    JLabel dealerLabel = new JLabel();
    JLabel playerLabel = new JLabel();
    JLabel currentMoney = new JLabel();

    JTextPane playerMoney = new JTextPane();

    //Labels for card visuals
    JLabel playerCard1;
    JLabel playerCard2;
    JLabel playerCardHit;
    JLabel dealerCard0;
    JLabel dealerCard1;
    JLabel dealerCard2;
    JLabel dealerCardHit;

    // GUI constructor
    public BlackJackGUI() {
        home();
    }

    public void home() {
        JFrame homeFrame = new JFrame("Home");
        JButton registerButton = new JButton();
        JButton loginButton = new JButton();
        registerButton.setBounds(100, 50, 100, 50);
        loginButton.setBounds(100, 150, 100, 50);
        homeFrame.add(registerButton);
        homeFrame.add(loginButton);
        homeFrame.setSize(300, 300);
        homeFrame.setLayout(null);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean login() {
        JFrame loginFrame = new JFrame();
        JFrame errorFrame = new JFrame();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(0, 2, 2, 2));

        JTextField nameField = new JTextField(5);
        JTextField passwordField = new JTextField(5);

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
                JOptionPane.showMessageDialog(errorFrame, "Error! Username or password is empty string.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            LoginAuthentication verify = new LoginAuthentication();
            if(verify.loginVerify(username, password))
                done = true;
            else
                JOptionPane.showMessageDialog(errorFrame, "Error! Incorrect username or password.",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
        } while(!done);
        JOptionPane.showMessageDialog(errorFrame, "Hello, " + username + ".\nWelcome to CS401 Blackjack.",
                                      "Login Message", JOptionPane.INFORMATION_MESSAGE);
            return true;
    }


    // In-game GUI
    public void inGame() {

        topPanel.setBackground(new Color(0, 125, 0));
        dealerPanel.setBackground(new Color(0, 125, 0));
        playerPanel.setBackground(new Color(0, 125, 0));

        topPanel.setLayout(new FlowLayout());

        dealButton.setText("Deal");
        dealButton.addActionListener(new dealButton()); //performs dealButton method
        hitButton.setText("Hit");
        hitButton.addActionListener(new hitButton());
        hitButton.setEnabled(false);
        holdButton.setText("Hold");
        holdButton.addActionListener(new holdButton());
        holdButton.setEnabled(false);

        dealerLabel.setText("Dealer: ");
        dealerLabel.setFont(new java.awt.Font("Arial Bold", 1, 20));
        dealerLabel.setForeground(Color.black);
        playerLabel.setText("Player: ");
        playerLabel.setFont(new java.awt.Font("Arial Bold", 1, 20));
        playerLabel.setForeground(Color.black);
        currentMoney.setText("Money: ");
        currentMoney.setFont(new java.awt.Font("Arial Bold", 1, 20));
        currentMoney.setForeground(Color.black);
        //currentMoney.setHorizontalAlignment(SwingConstants.RIGHT);

        topPanel.add(dealButton);
        topPanel.add(hitButton);
        topPanel.add(holdButton);

        dealerPanel.add(dealerLabel);
        //adding card visuals to dealer panel
        dealerCard0 = new JLabel(new ImageIcon("CardImages/back.jpg"));
        dealerPanel.add(dealerCard0);

        playerPanel.add(playerLabel);
        playerPanel.add(currentMoney);
        playerMoney.setText("$2000"); //current acct's money should display here
        playerMoney.setFont(new java.awt.Font("Arial Bold", 1, 20));
        playerPanel.add(playerMoney);
        
        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(dealerPanel,BorderLayout.CENTER);
        add(playerPanel,BorderLayout.SOUTH);
    }

    //display GUI method
    public void display(){
        JFrame myFrame = new JFrame("BlackJack");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(800,600));

        myFrame.pack();
        myFrame.setVisible(true);
    }

    class dealButton implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            //insert method
            dealerCard0 = new JLabel(new ImageIcon("back.jpg"));
            dealerPanel.add(dealerCard0);
        }
    }

    class hitButton implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            //insert method
        }
    }

    class holdButton implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            //insert method
        }
    }

}
