package backend.database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.database.shared.Book;
import backend.database.shared.Document;
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
	
	@Test
	void testBookSearchAndUpdate()
	{
		Double price = 62.42;
		Book book = new Book(300, "Mary had a Little Lamb",
				"Sheep Killas", new java.sql.Date(2018, 10, 24), 
				new java.sql.Date(2018, 10, 24),
					"mobi", false, true, "Children's Bedtime Story", 123907541, 
					price);
		db.addDocument(book);
		Vector<Document> result = db.getSearch(book.getDocumentTitle());
		
		assertTrue(result.size() > 0);
		
		for (Document document : result)
		{
			System.out.println(document);
		}
		
		price = 29.99;
		book = (Book) result.get(0);
		book.setPrice(price);
		
		
		db.modifyDocument(book);
		
		result = db.getSearch(book.getDocumentTitle());
		Book resultBook = (Book) result.get(0);
		for (Document document : result)
		{
			System.out.println(document);
		}
		
		assertEquals(price, resultBook.getPrice());
		
	}
	
	@Test
	public void testJournalSearchAndUpdate()
	{
		Journal journal = new Journal(981247, "Hello World", "!me", 
				new java.sql.Date(2018, 11, 24),
				new java.sql.Date(2018, 11, 24), "c", 33.00);
		
		db.addDocument(journal);
		
		Vector<Document> result;
		result = db.getSearch(journal.getDocumentTitle());
		journal = (Journal) result.get(0);
		
		assertNotNull(journal);
		
		String newTitle = "FiFo";
		String newAuthor = "LiFo Stacko Gang";
		journal.setDocumentTitle(newTitle);
		
		journal.setAuthor(newAuthor);
		db.modifyDocument(journal);
		
		result = db.getSearch(journal.getDocumentTitle());
		journal = (Journal) result.get(0);
		
		assertEquals(newTitle, journal.getDocumentTitle());
		assertEquals(newAuthor, journal.getAuthor());
	}

}
