package backend.database.shared;

import java.util.Date;

public class Journal extends Document
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Journal(int id, String title, String author, Date creation, 
			Date lastModified, String fileExtension, Double price)
	{
		super(id, title, author, creation, lastModified, fileExtension, price);
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("--- Journal ---\n");
		stringBuilder.append(super.toString());
		return stringBuilder.toString();
	}
	
	@Override
	public String getType()
	{
		return "Journal";
	}
}
