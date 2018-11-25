package backend.database.shared;

import java.util.Date;

public class Book extends Document
{
	private boolean isHardCover;
	private boolean isFiction;
	private String genre;
	private int isbn;
	
	public Book(int id, String title, String author, Date creation,
			Date lastModified, String fileExtension, boolean isHardCover,
			boolean isFiction, String genre, int isbn)
	{
		super(id, title, author, creation, lastModified, fileExtension);
		
		this.isHardCover = isHardCover;
		this.isFiction = isFiction;
		this.genre = genre;
		this.isbn = isbn;
	}

	public boolean isHardCover()
	{
		return isHardCover;
	}

	public boolean isFiction()
	{
		return isFiction;
	}

	public String getGenre()
	{
		return genre;
	}

	public int getIsbn()
	{
		return isbn;
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("--- Book ---\n");
		stringBuilder.append(super.toString());
		stringBuilder.append("Hardcover: " + isHardCover + "\n");
		stringBuilder.append("Fiction: " + isFiction + "\n");
		stringBuilder.append("Genre: " + genre + "\n");
		stringBuilder.append("ISBN: " + isbn + "\n");
		return stringBuilder.toString();
	}
}
