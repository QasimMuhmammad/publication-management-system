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
	void RegisterUser()
	{
		String username, password;
		username = "Paul";
		password = "secure";
		
		System.out.println("In RegisterUser");
		db.registerUser(username, password);
		System.out.println("Valid Login!");
		
	}

}
