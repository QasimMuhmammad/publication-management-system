package backend.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

import backend.database.data.CSVFileReader;
import backend.database.schema.Schema_Book;
import backend.database.schema.Schema_Journal;
import backend.database.schema.Schema_Login;
import backend.database.schema.Schema_Magazine;

public class DatabaseEntity implements Database_Configuration, Schema_Login,
Schema_Book, Schema_Magazine, Schema_Journal
{
	private Connection connection;
	private Properties connectionProps;
	private PreparedStatement preparedStatement;

	public DatabaseEntity()
	{
		connectionProps = new Properties();
		connectionProps.put("user", DB_USERNAME);
		connectionProps.put("password", DB_PASSWORD);
	}

	public boolean registerUser(String username, String password)
	{
		String sql;
		boolean returnVal = false;
		// TODO: Check if user already exists.

		try
		{	sql = "SELECT * FROM " + LOGIN_TABLENAME + " WHERE " 
				+ LOGIN_USERNAME 
				+ "= ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rSet = preparedStatement.executeQuery();
			
			if(rSet.next())
			{
				System.out.println("Username: " 
						+ rSet.getString(1) 
						+ " already exists ");
				returnVal= false;
			}
			
			else
			{
			sql = "INSERT INTO " + LOGIN_TABLENAME + " VALUES" + "(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username.toLowerCase());
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, LOGIN_USERS.REGISTERED_BUYER.getId());
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
		System.out.println("Attempting Login db");
		
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
				System.out.println("Authenticated User: " + rSet.getString(1));
				System.out.println("Type: " + rSet.getInt(2));
				return LOGIN_USER_REGISTERED_BUYER;
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
			}

			preparedStatement = connection.prepareStatement("SHOW TABLES;");
			rSet = preparedStatement.executeQuery();

			System.out.println("Existing Tables:");

			while (rSet.next())
			{
				System.out.println(rSet.getString(1));
			}
			
			registerUser("hi", "bye");

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
		System.out.print("CREATING TABLES1");
		
		tableName = LOGIN_TABLENAME;
		sql = "CREATE TABLE " + tableName + "("
				+ LOGIN_USERNAME + " VARCHAR(50) NOT NULL, "
				+ LOGIN_PASSWORD + " VARCHAR(50) NOT NULL, "
				+ LOGIN_USERTYPE + " INT(1) NOT NULL, "
				+ "PRIMARY KEY ( " + LOGIN_USERNAME + " ) " + ")";

		executeUpdate(sql);
		System.out.print("CREATED LOGIN_TABLES");
		
		/*
		String document = DOCUMENT_ID + " INT(13) NOT NULL AUTO_INCREMENT, "
				+ DOCUMENT_TITLE + " VARCHAR(50) NOT NULL, "
				+ DOCUMENT_AUTHOR + " VARCHAR(50) NOT NULL, "
				+ DOCUMENT_CREATION_DATE + " DATE NOT NULL, "
				+ DOCUMENT_LAST_MODIFIED_DATE + " DATE NOT NULL, "
				+ DOCUMENT_FILE_EXTENSION + " VARCHAR(10) NOT NULL, ";
		
		tableName = JOURNAL_TABLENAME;
		sql = "CREATE TABLE " + tableName + "("
				+ document
				+ "PRIMARY KEY ( " + DOCUMENT_ID + " ) " + ")";
		
		executeUpdate(sql);
		
		System.out.print("CREATED DOCUMENT_TABLES");
		
		tableName = MAGAZINE_TABLENAME;
		sql = "CREATE TABLE " + tableName + "("
				+ document 
				+ MAGAZINE_ISSUE_ID + " INT(5) NOT NULL "
				+ "PRIMARY KEY ( " + DOCUMENT_ID + " ) " + ")";
		
		executeUpdate(sql);
		
		System.out.print("CREATED DOCUMENT_TABLES");
		
		tableName = BOOK_TABLENAME;
		sql = "CREATE TABLE " + tableName + "("
				+ document 
				+ BOOK_IS_FICTION + " CHAR(5) NOT NULL "
				+ BOOK_GENRE + " VARCHAR(30) NOT NULL, "
				+ "PRIMARY KEY ( " + DOCUMENT_ID + " ) " + ")";
		
		executeUpdate(sql);
		
		System.out.print("CREATED MAGAZINE");
		*/
		
		
		// TODO: create magazine table
		// TODO: create journal table
		// TODO: create book table
//				+ LOGIN_USERNAME + " VARCHAR(50) NOT NULL, "
//				+ LOGIN_PASSWORD + " VARCHAR(50) NOT NULL, "
//				+ LOGIN_USERTYPE + " INT(1) NOT NULL,"
//				+ "PRIMARY KEY ( " + LOGIN_USERNAME + " ) " + ")";
		
	}

	private void populateDatabase()
	{
		// TODO: Populate the database with data from text files.
		
		File file;
		Path path;
		
		file = new File("src/backend/database/data/login.txt");
		path = file.toPath();
		
		try
		{
			CSVFileReader reader = new CSVFileReader(path);
			
			while (reader.hasNext())
			{
				StringBuilder out = new StringBuilder();
				String[] fields = reader.next();
				
				// TODO: Write into the table
			}
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insertUser() {}
	public void insertBook() {}
	public void insertMagazine() {}
	public void insertJournal() {}
	

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
}
