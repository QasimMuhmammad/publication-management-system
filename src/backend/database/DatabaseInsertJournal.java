package backend.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import backend.database.schema.Schema_Journal;
import backend.database.shared.Journal;

public class DatabaseInsertJournal implements DatabaseInsertStrategy,
Schema_Journal
{
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public DatabaseInsertJournal(Connection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void insertFromFile(String[] journal)
	{
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
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, journal[0]);
			preparedStatement.setString(2, journal[1]);
			preparedStatement.setDate(3, 
					new java.sql.Date(formatter.parse(journal[2]).getTime()));
			preparedStatement.setDate(4, 
					new java.sql.Date(formatter.parse(journal[3]).getTime()));
			preparedStatement.setString(5, journal[4]);
			preparedStatement.setDouble(6, Double.parseDouble(journal[5]));
			preparedStatement.executeUpdate();
		} catch (SQLException | ParseException e)
		{
			e.printStackTrace();
		}
	}
}
