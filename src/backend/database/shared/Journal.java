package backend.database.shared;

import java.util.Date;

public class Journal extends Document
{
	public Journal(int id, String title, String author, Date creation, 
			Date lastModified, String fileExtension)
	{
		super(id, title, author, creation, lastModified, fileExtension);
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("--- Journal ---\n");
		stringBuilder.append(super.toString());
		return stringBuilder.toString();
	}
}
