package backend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import backend.database.schema.Schema_Magazine;

public class DatabaseInsertMagazine implements DatabaseInsertStrategy, 
Schema_Magazine
{
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public DatabaseInsertMagazine(Connection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void insert(String[] magazine)
	{
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
			preparedStatement.setDouble(7, Double.parseDouble(magazine[6]));
			preparedStatement.executeUpdate();
		} catch (SQLException | ParseException e)
		{
			e.printStackTrace();
		}
	}

}
