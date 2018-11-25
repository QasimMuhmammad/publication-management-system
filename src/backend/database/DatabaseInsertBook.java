package backend.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import backend.database.schema.Schema_Book;

public class DatabaseInsertBook implements DatabaseInsertStrategy, Schema_Book
{
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public DatabaseInsertBook(Connection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void insert(String[] book)
	{
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
				+ BOOK_ISBN+ ", "
				+ DOCUMENT_PRICE
				+ ")"
				+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?)";
		
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
			preparedStatement.setDouble(10, Double.parseDouble(book[9]));
			preparedStatement.executeUpdate();
			
		} catch (SQLException | ParseException e)
		{
			e.printStackTrace();
		}
	}

}
