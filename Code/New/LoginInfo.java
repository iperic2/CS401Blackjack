import java.io.Serializable;

public class LoginInfo implements Serializable {

    public String username;
    public String password;
    public String email;

    public LoginInfo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
