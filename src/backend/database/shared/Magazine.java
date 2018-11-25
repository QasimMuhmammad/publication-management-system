package backend.database.shared;

import java.util.Date;

public class Magazine extends Document
{
	private int issueId;
	
	public Magazine(int id, String title, String author, Date creation,
			Date lastModified, String fileExtension, int issueId)
	{
		super(id, title, author, creation, lastModified, fileExtension);
		this.issueId = issueId;
	}
	
	public int getIssueId()
	{
		return issueId;
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("--- Magazine ---\n");
		stringBuilder.append(super.toString());
		stringBuilder.append("Issue ID: " + issueId + "\n");
		return stringBuilder.toString();
	}
}
