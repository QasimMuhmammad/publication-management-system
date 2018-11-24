package backend.database.schema;

public interface Schema_Book extends Schema_Login
{
	public static final String BOOK_TABLENAME = "book";
	public static final String BOOK_ISBN = "isbn";
	public static final String BOOK_IS_FICTION = "fiction";
	public static final String BOOK_GENRE = "genre";
}
