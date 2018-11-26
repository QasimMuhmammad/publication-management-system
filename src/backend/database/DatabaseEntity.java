package backend.database;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;

import backend.database.schema.Schema_Book;
import backend.database.schema.Schema_Journal;
import backend.database.schema.Schema_Login;
import backend.database.schema.Schema_Magazine;
import backend.database.shared.Book;
import backend.database.shared.Document;
import backend.database.shared.Journal;
import backend.database.shared.Magazine;

public class DatabaseEntity implements Database_Configuration, Schema_Login,
		Schema_Book, Schema_Magazine, Schema_Journal
{
	private Properties connectionProps;
	private Connection connection;
	private PreparedStatement preparedStatement;

	public DatabaseEntity()
	{
		connectionProps = new Properties();
		connectionProps.put("user", DB_USERNAME);
		connectionProps.put("password", DB_PASSWORD);
	}
	
	public void addDocument(Document document)
	{
		Class<? extends Document> class1 = document.getClass();
		
		if (class1 == Journal.class)
		{
			Journal journal = (Journal) document;
			String sql;
			
			sql = "INSERT INTO " + JOURNAL_TABLENAME 
					+ "(" 
					+ DOCUMENT_TITLE + ", "
					+ DOCUMENT_AUTHOR + ", "
					+ DOCUMENT_CREATION_DATE + ", "
					+ DOCUMENT_LAST_MODIFIED_DATE + ", "
					+ DOCUMENT_FILE_EXTENSION+ ", "
					+ DOCUMENT_PRICE
					+ ")"
					+ " VALUES" + "(?,?,?,?,?,?)";
			
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, journal.getDocumentTitle());
				preparedStatement.setString(2, journal.getAuthor());
				preparedStatement.setDate(3, 
						(Date) journal.getCreationDate());
				preparedStatement.setDate(4, 
						(Date) journal.getLastModifiedDate());
				preparedStatement.setString(5, journal.getFileExtension());
				preparedStatement.setDouble(6, journal.getPrice());
				preparedStatement.executeUpdate();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		} else if (class1 == Book.class)
		{
			Book book = (Book) document;
			String sql;
			sql = "INSERT INTO " + BOOK_TABLENAME 
					+ "(" 
					+ DOCUMENT_TITLE + ", "
					+ DOCUMENT_AUTHOR + ", "
					+ DOCUMENT_CREATION_DATE + ", "
					+ DOCUMENT_LAST_MODIFIED_DATE + ", "
					+ DOCUMENT_FILE_EXTENSION + ", "
					+ BOOK_IS_HARDCOVER + ", "
					+ BOOK_IS_FICTION + ", "
					+ BOOK_GENRE + ", "
					+ BOOK_ISBN + ", "
					+ DOCUMENT_PRICE
					+ ")"
					+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?)";
			
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, book.getDocumentTitle());
				preparedStatement.setString(2, book.getAuthor());
				preparedStatement.setDate(3, 
						(java.sql.Date) book.getCreationDate());
				preparedStatement.setDate(4, 
						(java.sql.Date) book.getLastModifiedDate());
				preparedStatement.setString(5, book.getFileExtension());
				preparedStatement.setBoolean(6, book.isHardCover());
				preparedStatement.setBoolean(7, book.isFiction());
				preparedStatement.setString(8, book.getGenre());
				preparedStatement.setInt(9, book.getIsbn());
				preparedStatement.setDouble(10, book.getPrice());
				preparedStatement.executeUpdate();
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		} else if (class1 == Magazine.class)
		{
			Magazine magazine = (Magazine) document;

			String sql;
			
			sql = "INSERT INTO " + MAGAZINE_TABLENAME 
					+ "(" 
					+ DOCUMENT_TITLE + ", "
					+ DOCUMENT_AUTHOR + ", "
					+ DOCUMENT_CREATION_DATE + ", "
					+ DOCUMENT_LAST_MODIFIED_DATE + ", "
					+ DOCUMENT_FILE_EXTENSION + ", "
					+ MAGAZINE_ISSUE_ID + ", "
					+ DOCUMENT_PRICE
					+ ")"
					+ " VALUES" + "(?,?,?,?,?,?,?)";
			
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, magazine.getDocumentTitle());
				preparedStatement.setString(2, magazine.getAuthor());
				preparedStatement.setDate(3, 
						(java.sql.Date) magazine.getCreationDate());
				preparedStatement.setDate(4, 
						(java.sql.Date) magazine.getLastModifiedDate());
				preparedStatement.setString(5, magazine.getFileExtension());
				preparedStatement.setInt(6, magazine.getIssueId());
				preparedStatement.setDouble(7, magazine.getPrice());
				preparedStatement.executeUpdate();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void modifyDocument(Document document)
	{
		Class<? extends Document> class1 = document.getClass();
		
		if (class1 == Journal.class)
		{
			Journal journal = (Journal) document;
			String sql;
			
			sql = "UPDATE " + JOURNAL_TABLENAME + " SET "
					+ DOCUMENT_TITLE + "=?, "
					+ DOCUMENT_AUTHOR + "=?, "
					+ DOCUMENT_CREATION_DATE + "=?, "
					+ DOCUMENT_LAST_MODIFIED_DATE + "=?, "
					+ DOCUMENT_FILE_EXTENSION + "=?, "
					+ DOCUMENT_PRICE + "=?"
					+ " WHERE " + DOCUMENT_ID + "=?;";
			
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, journal.getDocumentTitle());
				preparedStatement.setString(2, journal.getAuthor());
				preparedStatement.setDate(3, 
						(Date) journal.getCreationDate());
				preparedStatement.setDate(4, 
						(Date) journal.getLastModifiedDate());
				preparedStatement.setString(5, journal.getFileExtension());
				preparedStatement.setInt(6, journal.getDocumentId());
				preparedStatement.setDouble(7, journal.getPrice());
				preparedStatement.executeUpdate();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		} else if (class1 == Book.class)
		{
			System.out.println("ISABOOK");
			Book book = (Book) document;
			String sql;
			sql = "UPDATE " + BOOK_TABLENAME + " SET "
					+ DOCUMENT_TITLE + "=?, "
					+ DOCUMENT_AUTHOR + "=?, "
					+ DOCUMENT_CREATION_DATE + "=?, "
					+ DOCUMENT_LAST_MODIFIED_DATE + "=?, "
					+ DOCUMENT_FILE_EXTENSION + "=?, "
					+ BOOK_IS_HARDCOVER + "=?, "
					+ BOOK_IS_FICTION + "=?, "
					+ BOOK_GENRE + "=?, "
					+ BOOK_ISBN + "=?, "
					+ DOCUMENT_PRICE + "=? "
					+ " WHERE " + DOCUMENT_ID + "=?;";
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, book.getDocumentTitle());
				preparedStatement.setString(2, book.getAuthor());
				preparedStatement.setDate(3, 
						(java.sql.Date) book.getCreationDate());
				preparedStatement.setDate(4, 
						(java.sql.Date) book.getLastModifiedDate());
				preparedStatement.setString(5, book.getFileExtension());
				preparedStatement.setBoolean(6, book.isHardCover());
				preparedStatement.setBoolean(7, book.isFiction());
				preparedStatement.setString(8, book.getGenre());
				preparedStatement.setInt(9, book.getIsbn());
				preparedStatement.setDouble(10, book.getPrice());
				preparedStatement.setInt(11, book.getDocumentId());
				preparedStatement.executeUpdate();
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		} else if (class1 == Magazine.class)
		{
			Magazine magazine = (Magazine) document;

			String sql;
			
			sql = "UPDATE " + MAGAZINE_TABLENAME + " SET "
					+ DOCUMENT_TITLE + "=?, "
					+ DOCUMENT_AUTHOR + "=?, "
					+ DOCUMENT_CREATION_DATE + "=?, "
					+ DOCUMENT_LAST_MODIFIED_DATE + "=?, "
					+ DOCUMENT_FILE_EXTENSION + "=?, "
					+ MAGAZINE_ISSUE_ID + "=?, "
					+ DOCUMENT_PRICE  + "=?"
					+ " WHERE " + DOCUMENT_ID + "=?;";
			
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, magazine.getDocumentTitle());
				preparedStatement.setString(2, magazine.getAuthor());
				preparedStatement.setDate(3, 
						(java.sql.Date) magazine.getCreationDate());
				preparedStatement.setDate(4, 
						(java.sql.Date) magazine.getLastModifiedDate());
				preparedStatement.setString(5, magazine.getFileExtension());
				preparedStatement.setInt(6, magazine.getIssueId());
				preparedStatement.setDouble(7, magazine.getPrice());
				preparedStatement.setInt(8, magazine.getDocumentId());
				preparedStatement.executeUpdate();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("Unknown document.");
		}
	}
	
	

	public Vector<Book> getAllBooks()
	{
		String sql;
		Vector<Book> result = new Vector<Book>();

		try
		{
			sql = "SELECT * FROM " + BOOK_TABLENAME + ";";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				result.add(new Book(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getDate(5),
						resultSet.getString(6),
						resultSet.getString(7).equals("true") ? true : false,
						resultSet.getString(8).equals("true") ? true : false,
						resultSet.getString(9),
						resultSet.getInt(10),resultSet.getDouble(11)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	public Vector<Journal> getAllJournals()
	{
		String sql;
		Vector<Journal> result = new Vector<Journal>();

		try
		{
			sql = "SELECT * FROM " + JOURNAL_TABLENAME + ";";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				result.add(new Journal(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getDate(5),
						resultSet.getString(6),resultSet.getDouble(7)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}
	
	public Vector<Magazine> getAllMagazines()
	{
		String sql;
		Vector<Magazine> result = new Vector<Magazine>();

		try
		{
			sql = "SELECT * FROM " + MAGAZINE_TABLENAME + ";";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				result.add(new Magazine(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getDate(5),
						resultSet.getString(6),
						resultSet.getInt(7),resultSet.getDouble(8)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	public Vector<Document> getAllDocuments()
	{
		Vector<Document> result = new Vector<Document>();
		result.addAll(getAllBooks());
		result.addAll(getAllMagazines());
		result.addAll(getAllJournals());
		
		return result;	
	}
	
	public boolean unregisterUser(String username, String password)
	{
		String sql;
		boolean returnVal = false;
		
		try
		{
			sql = "SELECT * FROM " + LOGIN_TABLENAME + " WHERE "
					+ LOGIN_USERNAME + "= ? AND " + LOGIN_PASSWORD + "= ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username.toLowerCase());
			preparedStatement.setString(2, password);
			ResultSet rSet = preparedStatement.executeQuery();

			if (rSet.next())
			{
				System.out.println("Unregistering " + username);
				sql = "DELETE FROM " + LOGIN_TABLENAME + " WHERE " 
						+ LOGIN_USERNAME + "=?;";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, username.toLowerCase());
				preparedStatement.executeUpdate();
				returnVal = true;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return returnVal;
	}
	
	public boolean registerUser(String username, String password)
	{
		String sql;
		boolean returnVal = false;

		try
		{
			sql = "SELECT * FROM " + LOGIN_TABLENAME + " WHERE "
					+ LOGIN_USERNAME + "= ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rSet = preparedStatement.executeQuery();

			if (rSet.next())
			{
				System.out.println(
						"Username: " + rSet.getString(1) + " already exists ");
				returnVal = false;
			} else
			{
				sql = "INSERT INTO " + LOGIN_TABLENAME + " VALUES" + "(?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, username.toLowerCase());
				preparedStatement.setString(2, password);
				preparedStatement.setInt(3,
						LOGIN_USERS.REGISTERED_BUYER.getId());
				preparedStatement.executeUpdate();
				returnVal = true;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return returnVal;

	}

	public String login(String username, String password)
	{
		String sql;
		try
		{
			sql = "SELECT " + LOGIN_USERNAME + "," 
					+ LOGIN_USERTYPE + " FROM "
					+ LOGIN_TABLENAME + " WHERE " 
					+ LOGIN_USERNAME + "= ? AND "
					+ LOGIN_PASSWORD + "= ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username.toLowerCase());
			preparedStatement.setString(2, password);
			ResultSet rSet = preparedStatement.executeQuery();

			while (rSet.next())
			{
				int type = rSet.getInt(2);
				System.out.println("Found " + type);
				switch (type)
				{
				case 1:
					return LOGIN_USER_REGISTERED_BUYER;

				case 2:
					return LOGIN_USER_OPERATOR;
				}
				
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return LOGIN_USER_FAIL;
	}

	public void connect()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:" + "mysql" + "://"
					+ DB_HOSTNAME + ":" + DB_PORT + "/", connectionProps);
			System.out.println("Connected to database.");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		prepareDatabase();
	}

	public void disconnect()
	{
		try
		{
			connection.close();
			System.out.println("Disconnecting from database");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void destroyDatabase()
	{
		System.out.println("Destroying database...");
		executeUpdate("DROP DATABASE " + DB_NAME + ";");
	}

	public void prepareDatabase()
	{
		
		try
		{
			// See if the publication database exists
			preparedStatement = connection.prepareStatement("SHOW DATABASES;");
			ResultSet rSet = preparedStatement.executeQuery();

			Vector<String> databases = new Vector<String>();
			while (rSet.next())
			{
				databases.add(rSet.getString(1));
			}
			boolean publicationDbExists = false;

			for (String name : databases)
			{
				if (name.equals(DB_NAME))
				{
					publicationDbExists = true;
				}
			}

			if (publicationDbExists)
			{
				System.out.println(DB_NAME + " exists");
				executeUpdate("USE " + DB_NAME + ";");
			} else
			{
				System.out.println(DB_NAME + " does not exist");
				createDatabase();

				executeUpdate("USE " + DB_NAME + ";");

				createTables();
				System.out.println("Populating DB");

				populateDatabase();
			}

			preparedStatement = connection.prepareStatement("SHOW TABLES;");
			rSet = preparedStatement.executeQuery();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private void createDatabase()
	{
		System.out.println("Creating database...");
		executeUpdate("CREATE DATABASE " + DB_NAME + ";");
	}

	private void createTables()
	{
		String sql, tableName;

		tableName = LOGIN_TABLENAME;
		sql = "CREATE TABLE " + tableName + "(" + LOGIN_USERNAME
				+ " VARCHAR(50) NOT NULL, " + LOGIN_PASSWORD
				+ " VARCHAR(50) NOT NULL, " + LOGIN_USERTYPE
				+ " INT(1) NOT NULL, " + "PRIMARY KEY ( " + LOGIN_USERNAME
				+ " ) " + ")";
		executeUpdate(sql);

		String document = DOCUMENT_ID + " INT(13) NOT NULL AUTO_INCREMENT, "
				+ DOCUMENT_TITLE + " VARCHAR(50) NOT NULL, " 
				+ DOCUMENT_AUTHOR + " VARCHAR(50) NOT NULL, " 
				+ DOCUMENT_CREATION_DATE + " DATE NOT NULL, " 
				+ DOCUMENT_LAST_MODIFIED_DATE + " DATE NOT NULL, " 
				+ DOCUMENT_FILE_EXTENSION + " VARCHAR(10) NOT NULL, ";

		tableName = JOURNAL_TABLENAME;
		sql = "CREATE TABLE " + tableName + "(" + document + DOCUMENT_PRICE + " DOUBLE NOT NULL, "+ "PRIMARY KEY ( "
				+ DOCUMENT_ID + " ) " + ")";
		executeUpdate(sql);

		tableName = MAGAZINE_TABLENAME;
		sql = "CREATE TABLE " + tableName + "(" + document + MAGAZINE_ISSUE_ID
				+ " INT(5) NOT NULL, " + DOCUMENT_PRICE + " DOUBLE NOT NULL, " + "PRIMARY KEY ( " + DOCUMENT_ID + " ) "
				+ ")";
		executeUpdate(sql);

		tableName = BOOK_TABLENAME;
		sql = "CREATE TABLE " + tableName + "(" + document + BOOK_IS_HARDCOVER
				+ " CHAR(5) NOT NULL, " + BOOK_IS_FICTION
				+ " CHAR(5) NOT NULL, " + BOOK_GENRE + " VARCHAR(30) NOT NULL, "
				+ BOOK_ISBN + " INT(13) NOT NULL, " +DOCUMENT_PRICE + " DOUBLE NOT NULL, " + "PRIMARY KEY ( "
				+ DOCUMENT_ID + " ) " + ")";
		executeUpdate(sql);
	}

	private void populateDatabase()
	{
		File file;
		DatabaseFileLoader databaseFileLoader = new DatabaseFileLoader();

		file = new File(LOGIN_PATH);
		databaseFileLoader.setFile(file);
		databaseFileLoader
				.setDatabaseInsertStrategy(new DatabaseInsertUser(connection));
		databaseFileLoader.performInsertStrategy();

		file = new File(BOOK_PATH);
		databaseFileLoader.setFile(file);
		databaseFileLoader
				.setDatabaseInsertStrategy(new DatabaseInsertBook(connection));
		databaseFileLoader.performInsertStrategy();

		file = new File(MAGAZINE_PATH);
		databaseFileLoader.setFile(file);
		databaseFileLoader.setDatabaseInsertStrategy(
				new DatabaseInsertMagazine(connection));
		databaseFileLoader.performInsertStrategy();

		file = new File(JOURNAL_PATH);
		databaseFileLoader.setFile(file);
		databaseFileLoader.setDatabaseInsertStrategy(
				new DatabaseInsertJournal(connection));
		databaseFileLoader.performInsertStrategy();
	}

	public void insertUser(final String[] user)
	{
		String sql;
		sql = "INSERT INTO " + LOGIN_TABLENAME + " VALUES" + "(?,?,?)";

		try
		{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user[0].toLowerCase());
			preparedStatement.setString(2, user[1]);
			preparedStatement.setInt(3, Integer.parseInt(user[2]));
			preparedStatement.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void insertBook(final String[] book)
	{
		String sql;
		sql = "INSERT INTO " + BOOK_TABLENAME + "(" + DOCUMENT_TITLE + ", "
				+ DOCUMENT_AUTHOR + ", " + DOCUMENT_CREATION_DATE + ", "
				+ DOCUMENT_LAST_MODIFIED_DATE + ", " + DOCUMENT_FILE_EXTENSION
				+ ", " + BOOK_IS_HARDCOVER + ", " + BOOK_IS_FICTION + ", "
				+ BOOK_GENRE + ", " + BOOK_ISBN + ")" + " VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";

		try
		{
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book[0]);
			preparedStatement.setString(2, book[1]);
			preparedStatement.setDate(3,
					new java.sql.Date(formatter.parse(book[2]).getTime()));
			preparedStatement.setDate(4,
					new java.sql.Date(formatter.parse(book[3]).getTime()));
			preparedStatement.setString(5, book[4]);
			preparedStatement.setString(6, book[5]);
			preparedStatement.setString(7, book[6]);
			preparedStatement.setString(8, book[7]);
			preparedStatement.setInt(9, Integer.parseInt(book[8]));
			preparedStatement.executeUpdate();

		} catch (SQLException | ParseException e)
		{
			e.printStackTrace();
		}
	}

	public void insertMagazine(final String[] magazine)
	{
		String sql;

		sql = "INSERT INTO " + MAGAZINE_TABLENAME + "(" + DOCUMENT_TITLE + ", "
				+ DOCUMENT_AUTHOR + ", " + DOCUMENT_CREATION_DATE + ", "
				+ DOCUMENT_LAST_MODIFIED_DATE + ", " + DOCUMENT_FILE_EXTENSION
				+ ", " + MAGAZINE_ISSUE_ID + ")" + " VALUES" + "(?,?,?,?,?,?)";

		try
		{
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, magazine[0]);
			preparedStatement.setString(2, magazine[1]);
			preparedStatement.setDate(3,
					new java.sql.Date(formatter.parse(magazine[2]).getTime()));
			preparedStatement.setDate(4,
					new java.sql.Date(formatter.parse(magazine[3]).getTime()));
			preparedStatement.setString(5, magazine[4]);
			preparedStatement.setInt(6, Integer.parseInt(magazine[5]));
			preparedStatement.executeUpdate();
		} catch (SQLException | ParseException e)
		{
			e.printStackTrace();
		}
	}

	public void insertJournal(final String[] journal)
	{
		String sql;

		sql = "INSERT INTO " + JOURNAL_TABLENAME + "(" + DOCUMENT_TITLE + ", "
				+ DOCUMENT_AUTHOR + ", " + DOCUMENT_CREATION_DATE + ", "
				+ DOCUMENT_LAST_MODIFIED_DATE + ", " + DOCUMENT_FILE_EXTENSION
				+ ")" + " VALUES" + "(?,?,?,?,?)";

		try
		{
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, journal[0]);
			preparedStatement.setString(2, journal[1]);
			preparedStatement.setDate(3,
					new java.sql.Date(formatter.parse(journal[2]).getTime()));
			preparedStatement.setDate(4,
					new java.sql.Date(formatter.parse(journal[3]).getTime()));
			preparedStatement.setString(5, journal[4]);
			preparedStatement.executeUpdate();
		} catch (SQLException | ParseException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Executes an update using the provided sql string.
	 * 
	 * @param sql
	 *            the SQL command to execute
	 */
	private void executeUpdate(String sql)
	{
		try
		{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Vector<Document> getSearch(String docName)
	{
		String sql,sql1,sql2;
		Vector<Document> myResult = new Vector<Document>();
		
		sql = "SELECT * FROM " + BOOK_TABLENAME + " WHERE " + DOCUMENT_TITLE 
				+ "= ?;";
		sql1 = "SELECT * FROM " + MAGAZINE_TABLENAME + " WHERE " + DOCUMENT_TITLE 
				+ "= ?;";
		sql2 = "SELECT * FROM " + JOURNAL_TABLENAME + " WHERE " + DOCUMENT_TITLE 
				+ "= ?;";
		
		try
		{

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, docName);
			ResultSet rSet = preparedStatement.executeQuery();
			
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, docName);
			ResultSet rSet1 = preparedStatement.executeQuery();
			
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, docName);
			ResultSet rSet2 = preparedStatement.executeQuery();
			
			while(rSet.next())
			{
				myResult.add(new Book(
						rSet.getInt(1),
						rSet.getString(2),
						rSet.getString(3),
						rSet.getDate(4),
						rSet.getDate(5),
						rSet.getString(6),
						rSet.getString(7).equals("true") ? true : false,
						rSet.getString(8).equals("true") ? true : false,
						rSet.getString(9),
						rSet.getInt(10),rSet.getDouble(11)));
			}
			
			while(rSet1.next())
			{
				myResult.add(new Magazine(
						rSet1.getInt(1),
						rSet1.getString(2),
						rSet1.getString(3),
						rSet1.getDate(4),
						rSet1.getDate(5),
						rSet1.getString(6),
						rSet1.getInt(7),rSet1.getDouble(8)));
				
			}
			
			while(rSet2.next())
			{
				myResult.add(new Journal(
						rSet2.getInt(1),
						rSet2.getString(2),
						rSet2.getString(3),
						rSet2.getDate(4),
						rSet2.getDate(5),
						rSet2.getString(6),rSet2.getDouble(7)));
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		return myResult;
	}
}
