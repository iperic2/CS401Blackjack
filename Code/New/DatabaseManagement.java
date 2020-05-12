import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.math.BigDecimal;

public class DatabaseManagement {

    private final static String host = "jdbc:mysql://localhost:3306/dbuser";
    private final static String databaseUsername = "root";
    private final static String databasePassword = "!@Alan12345678";
    private Connection con;
    Player player;

    public DatabaseManagement(){
        try {
        con = DriverManager.getConnection(host, databaseUsername, databasePassword);
        player = new Player();
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
    }

    public boolean isExist(String username, String email) {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT username FROM users WHERE username = \"" + username + '"';
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                return true;
            sql = "SELECT email FROM users WHERE email = \"" + email + '"';
            rs = stmt.executeQuery(sql);
            if(rs.next())
                return true;
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
        return false;
    }

    public void addNewUser(String username, String password, String email) {
        try {
        Statement stmt = con.createStatement();
        String sql = "INSERT INTO users (username, userPassword, email, balance)" +
                     "VALUES (\"" + username + "\", \"" + password + "\", \"" + email + "\", 2500)";
        stmt.executeUpdate(sql);
        player.setUsername(username);
        player.setPassword(password);
        player.setEmail(email);
        player.setBalance(BigDecimal.valueOf(2500));
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
    }

    public boolean loginVerify(String username, String password) {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT username, userPassword, email, balance FROM users " +
                         "WHERE username = \"" + username + '"';
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.next())
                return false;
            else {
                player.setUsername(rs.getString("username"));
                player.setPassword(rs.getString("userPassword"));
                if(player.getPassword().compareTo(password) != 0)
                    return false;
                player.setEmail(rs.getString("email"));
                player.setBalance(rs.getBigDecimal("balance"));
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
        return true;
    }

    public void setBalance(BigDecimal balance) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE users SET balance = " + balance +
                         " WHERE username = \"" + player.getUsername() + '"';
            stmt.executeUpdate(sql);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
    }

    public void changePassword(String password){
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE users SET userPassword = \"" + password + "\" WHERE username = \"" +
                         player.getUsername() + '"';
            stmt.executeUpdate(sql);
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
    }

    public Player getPlayer() {
        return player;
    }

}