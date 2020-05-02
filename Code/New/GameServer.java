import java.util.Scanner;

// allow user to sign up or login
public class GameServer
{
	private String signupUsername;
	private String signupPassword;
	private String loginUsername;
	private String loginPassword;
	
	// allow user to sign up
	public void signUp()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter desired username: ");
		signupUsername = input.next();

		System.out.println("Please enter desired password: ");
		signupPassword = input.next();
	}    

	// allow user to login
	public void login()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Username: ");
		loginUsername = input.next();

		System.out.println("Password: ");
		loginPassword = input.next();

		if (loginUsername.equals(signupUsername) && loginPassword.equals(signupPassword)) 
		System.out.println("Login success.");
		
		// code to connect user should be added below
	}
}
