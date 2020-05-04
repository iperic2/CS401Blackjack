import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class GameServerTest
{
	private String signupUsername;
	private String signupPassword;
	private String loginUsername;
	private String loginPassword;
	
	@Test
	public void signupUserTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired username: ");
		signupUsername = input.next();
	}
	
	@Test
	public void signupUserNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired username: ");
		signupUsername = input.next();
		
		assertNotNull(signupUsername);
	}

	@Test
	public void signupPassTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired password: ");
		signupPassword = input.next();
	}
	
	@Test
	public void signupPassNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter desired password: ");
		signupPassword = input.next();
		
		assertNotNull(signupPassword);
	}
	
	@Test
	public void loginUserTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your username: ");
		loginUsername = input.next();
	}
	
	@Test
	public void loginUserNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your username: ");
		loginUsername = input.next();
		
		assertNotNull(loginUsername);
	}
	
	@Test
	public void loginPassTest()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your password: ");
		loginUsername = input.next();
	}
	
	@Test
	public void loginPassNotNull()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your password: ");
		loginUsername = input.next();
		
		assertNotNull(loginUsername);
	}

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