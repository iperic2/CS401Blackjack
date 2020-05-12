import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest
{
	// Test constructor is not null.
	@Test
	public void constructorNotNull()
	{
		User tester = new User();
		
		assertNotNull(tester);
	}
	
	// Test constructor with parameters is not null.
	@Test
	public void parameterConstructorNotNull()
	{	
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertNotNull(tester);
	}
	
	// Test set user is not null.
	@Test
	public void setUserNotNull()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertNotNull(tester.getUsername());
	}
	
	// Test set password is not null.
	@Test
	public void setPassNotNull()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertNotNull(tester.getPassword());
	}
	
	// Test username returns expected.
	@Test
	public void setUserIsEqualToGet()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertEquals(user, tester.getUsername());
	}
	
	// Test password returns expected.
	@Test
	public void setPassIsEqualToGet()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertEquals(pass, tester.getPassword());
	}
	
	// Test to verify login.
	@Test
	public void verifyLoginTest()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertEquals(user, tester.getUsername());
		assertEquals(pass, tester.getPassword());
	}
}