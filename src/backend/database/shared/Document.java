package backend.database.shared;

import java.util.Date;

import backend.PublicationStrategy;

public class Document
{
	private int documentId;
	private String documentTitle;
	private String author;
	private Date creationDate;
	private Date lastModifiedDate;
	private String fileExtension;
	private PublicationStrategy publicationStrategy;
	
	public Document(int id, String title, String author, Date creation, 
			Date lastModified, String fileExtension)
	{
		documentId = id;
		documentTitle = title;
		this.author = author;
		creationDate = creation;
		lastModifiedDate = lastModified;
		this.fileExtension = fileExtension;
	}
	
	public void setPublicationStrategy(PublicationStrategy strategy)
	{
		publicationStrategy = strategy;
	}
	
//	public void 
}
