package backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

import backend.database.schema.Schema_Login;

public class DatabaseEntity implements Database_Configuration, Schema_Login
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

	public void registerUser(String username, String password)
	{
		String sql;
		
		// TODO: Check if user already exists.

		try
		{
			sql = "INSERT INTO " + LOGIN_TABLENAME + " VALUES" + "(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username.toLowerCase());
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, LOGIN_USERS.REGISTERED_BUYER.getId());
			preparedStatement.executeUpdate();
			
			sql = "SELECT * FROM " + LOGIN_TABLENAME + " WHERE " 
					+ LOGIN_USERNAME 
					+ "= ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rSet = preparedStatement.executeQuery();
			
			while (rSet.next())
			{
				System.out.println("Username: " 
						+ rSet.getString(1) 
						+ " Password: " 
						+ rSet.getString(2));
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean login(String username, String password)
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
				System.out.println("Authenticated User: " + rSet.getString(1));
				System.out.println("Type: " + rSet.getInt(2));
				return true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
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
				populateDatabase();
			}

			preparedStatement = connection.prepareStatement("SHOW TABLES;");
			rSet = preparedStatement.executeQuery();

			System.out.println("Existing Tables:");

			while (rSet.next())
			{
				System.out.println(rSet.getString(1));
			}

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
		sql = "CREATE TABLE " + tableName + "("
				+ LOGIN_USERNAME + " VARCHAR(50) NOT NULL, "
				+ LOGIN_PASSWORD + " VARCHAR(50) NOT NULL, "
				+ LOGIN_USERTYPE + " INT(1) NOT NULL,"
				+ "PRIMARY KEY ( " + LOGIN_USERNAME + " ) " + ")";

		executeUpdate(sql);
		
		tableName = "";
		sql = "CREATE TABLE " + tableName + "(";
		
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
		// TODO: Populate the databse with data from text files.
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
}
