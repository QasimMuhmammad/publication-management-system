package backend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import backend.database.schema.Schema_Login;

public class DatabaseInsertUser implements DatabaseInsertStrategy, Schema_Login
{
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public DatabaseInsertUser(Connection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void insertFromFile(String[] user)
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

}
