import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest
{
	@Test
	public void constructorNotNull()
	{
		User tester = new User();
		
		assertNotNull(tester);
	}
	
	@Test
	public void parameterConstructorNotNull()
	{	
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertNotNull(tester);
	}
	
	@Test
	public void setUserNotNull()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertNotNull(tester.getUsername());
	}
	
	@Test
	public void setPassNotNull()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertNotNull(tester.getPassword());
	}
	
	@Test
	public void setUserIsEqualToGet()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertEquals(user, tester.getUsername());
	}
	
	@Test
	public void setPassIsEqualToGet()
	{
		String user = "user";
		String pass = "pass";
		
		User tester = new User(user, pass);
		
		assertEquals(pass, tester.getPassword());
	}
	
	@Test
	public void verifyLoginTest()
	{
		// to be worked on.
	}
}
