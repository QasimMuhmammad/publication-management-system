package backend.database.schema;

public interface Schema_Book extends Schema_Login
{
	// Changes Made: None
	public static final String BOOK_TABLENAME = "book";
	public static final String BOOK_IS_FICTION = "fiction";
	public static final String BOOK_GENRE = "genre";
	public static final String BOOK_ISBN = "isbn";
	
	public static final String BOOK_PATH 
	= "src/backend/database/data/book.txt";
}
