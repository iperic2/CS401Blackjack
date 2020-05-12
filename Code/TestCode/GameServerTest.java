import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;

public class GameServerTest
{
	private String signupUsername;
	private String signupPassword;
	private String loginUsername;
	private String loginPassword;
	
	// Test that sign up user goes through.
	@Test
	public void signupUserTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired username: ");
		signupUsername = input.next();
	}
	
	// Test that sign up user is not null.
	@Test
	public void signupUserNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired username: ");
		signupUsername = input.next();
		
		assertNotNull(signupUsername);
	}

	// Test that sign up password goes through.
	@Test
	public void signupPassTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired password: ");
		signupPassword = input.next();
	}
	
	// Test that signup password is not null.
	@Test
	public void signupPassNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired password: ");
		signupPassword = input.next();
		
		assertNotNull(signupPassword);
	}
	
	// Test that login user goes through.
	@Test
	public void loginUserTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your username: ");
		loginUsername = input.next();
	}
	
	// Test that login user is not null.
	@Test
	public void loginUserNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your username: ");
		loginUsername = input.next();
		
		assertNotNull(loginUsername);
	}
	
	// Test that login password goes through.
	@Test
	public void loginPassTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your password: ");
		loginUsername = input.next();
	}
	
	// Test that login password is not null.
	@Test
	public void loginPassNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your password: ");
		loginUsername = input.next();
		
		assertNotNull(loginUsername);
	}

	// Test that user login is equal to user signup.
	@Test
	public void userLoginIsEqualToSignup()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Signup username: ");
		signupUsername = input.next();
		
		System.out.println("Login username: ");
		loginUsername = input.next();
		
		assertEquals(loginUsername, signupUsername);
	}
	
	// Test that password login is equal to password signup.
	@Test
	public void passLoginIsEqualToSignup()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Signup password: ");
		signupPassword = input.next();
		
		System.out.println("Login password: ");
		loginPassword = input.next();
		
		assertEquals(loginPassword, signupPassword);
	}
}