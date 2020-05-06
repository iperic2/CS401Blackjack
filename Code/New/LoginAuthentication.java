import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LoginAuthentication {

    private final static String host = "jdbc:mysql://localhost:3306/dbuser";
    private final static String databaseUsername = "root";
    private final static String databasePassword = "!@Alan12345678";
    private String username;
    private String password;

    public boolean loginVerify(String username, String password) {
        try {
            Connection con = DriverManager.getConnection(host, databaseUsername, databasePassword);
            Statement stmt = con.createStatement();
            String sql = "SELECT username, userPassword FROM users WHERE username = \"" + username + '"';
            System.out.println(sql);
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
        }
        catch (SQLException error) {
            System.out.println(error.getMessage());
                return false;
        }
        return true;
    }
}