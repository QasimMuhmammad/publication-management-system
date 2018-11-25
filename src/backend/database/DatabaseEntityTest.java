package backend.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DatabaseEntityTest
{
	static private DatabaseEntity db;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		db = new DatabaseEntity();
		db.connect();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception
	{
		db.destroyDatabase();
		db.disconnect();
	}

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testRegisterUser()
	{
		String username, password;
		username = "Paul";
		password = "secure";
		
		System.out.println("In RegisterUser");
		
		assertTrue(db.registerUser(username, password));
		
		assertEquals(LOGIN_USERS.LOGIN_USER_REGISTERED_BUYER,
				db.login(username, password));
		
		assertFalse(db.registerUser(username, password));
	}
	
	@Test
	void testLoginUser()
	{
		String username, password;
		username = "jimmy";
		password = "1";
		
		assertEquals(db.login(username, password),
				LOGIN_USERS.LOGIN_USER_REGISTERED_BUYER);
	}

}
