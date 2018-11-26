package backend.database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.database.shared.Book;
import backend.database.shared.Journal;
import backend.database.shared.Magazine;


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
		username = "jimmyTest";
		password = "1";
		
		db.registerUser(username, password);
		
		assertEquals(LOGIN_USERS.LOGIN_USER_REGISTERED_BUYER,
				db.login(username, password));
		
		db.unregisterUser(username, password);
		
		assertEquals(LOGIN_USERS.LOGIN_USER_FAIL, db.login(username, password));
	}
	
	@Test
	void testGetAllBooks()
	{
		Vector<Book> books = db.getAllBooks();
		for (Book book : books)
		{
//			System.out.println(book);
		}
	}
	
	@Test
	void testGetAllJournals()
	{
		Vector<Journal> journals = db.getAllJournals();
		for (Journal journal : journals)
		{
//			System.out.println(journal);
		}
	}
	
	@Test
	void testGetAllMagazines()
	{
		Vector<Magazine> magazines = db.getAllMagazines();
		for (Magazine magazine : magazines)
		{
//			System.out.println(magazine);
		}
	}

}
