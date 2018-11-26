package backend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import backend.database.schema.Schema_Promotion;

public class DatabaseInsertPromotion implements DatabaseInsertStrategy, 
	Schema_Promotion
{

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public DatabaseInsertPromotion(Connection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void insert(String[] promotion)
	{
		String sql;
		
		sql = "INSERT INTO " + PROMOTION_TABLENAME 
				+ "(" 
				+ PROMOTION_STRING
				+ ")"
				+ " VALUES" + "(?)";
		
		try
		{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, promotion[0]);
			preparedStatement.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}


}
