package backend.database.shared;

import java.util.Date;

public class Magazine extends Document
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int issueId;
	
	public Magazine(int id, String title, String author, Date creation,
			Date lastModified, String fileExtension, int issueId, Double price)
	{
		super(id, title, author, creation, lastModified, fileExtension,price);
		this.issueId = issueId;
	}
	
	public int getIssueId()
	{
		return issueId;
	}
	
	public void setIssueId(int issueId)
	{
		this.issueId = issueId;
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
	
	@Override
	public String getType()
	{
		return "Magazine";
	}
	
}
