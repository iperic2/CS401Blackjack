import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseManagement {

    private final static String host = "jdbc:mysql://localhost:3306/dbuser";
    private final static String databaseUsername = "root";
    private final static String databasePassword = "!@Alan12345678";
    Connection con;
    private String username;
    private String password;
    private String email;

    public DatabaseManagement(){
        try {
        con = DriverManager.getConnection(host, databaseUsername, databasePassword);
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
        } catch(SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
    }

    public boolean loginVerify(String username, String password) {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT username, userPassword FROM users WHERE username = \"" + username + '"';
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.next())
                return false;
            else {
                this.username = rs.getString("username");
                this.password = rs.getString("userPassword");
                System.out.println("username: " + this.username + "\npassword: " + this.password);
                if(this.password.compareTo(password) != 0)
                    return false;
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            System.exit(-1);
        }
        return true;
    }
}