package backend.database.shared;

import java.io.Serializable;
import java.util.Date;

import backend.PublicationStrategy;
import backend.PublishException;

public abstract class Document implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int documentId;
	private String documentTitle;
	private String author;
	private Date creationDate;
	private Date lastModifiedDate;
	private String fileExtension;
	private Double price;

	private PublicationStrategy publicationStrategy;
	
	
	public Document(int id, String title, String author, Date creation,
			Date lastModified, String fileExtension, Double price)
	{
		this.documentId = id;
		this.documentTitle = title;
		this.author = author;
		this.creationDate = creation;
		this.lastModifiedDate = lastModified;
		this.fileExtension = fileExtension;
		this.price = price;
	}
	
	public abstract String getType();

	public void publish() throws PublishException
	{
		this.publicationStrategy.performPublicationStrategy();
	}

	public void setPublicationStrategy(PublicationStrategy strategy)
	{
		this.publicationStrategy = strategy;
	}

	public int getDocumentId()
	{
		return documentId;
	}

	public String getDocumentTitle()
	{
		return documentTitle;
	}

	public String getAuthor()
	{
		return author;
	}

	public Date getCreationDate()
	{
		return creationDate;
	}

	public Date getLastModifiedDate()
	{
		return lastModifiedDate;
	}

	public String getFileExtension()
	{
		return fileExtension;
	}
	
	public Double getPrice()
	{
		return price;
	}
	
	public void setDocumentId(int documentId)
	{
		this.documentId = documentId;
	}

	public void setDocumentTitle(String documentTitle)
	{
		this.documentTitle = documentTitle;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}

	public void setFileExtension(String fileExtension)
	{
		this.fileExtension = fileExtension;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("ID: " + documentId + "\n");
		stringBuilder.append("Title: " + documentTitle + "\n");
		stringBuilder.append("Author: " + author + "\n");
		stringBuilder
				.append("Creation Date: " + creationDate.toString() + "\n");
		stringBuilder.append("Last Modified Date: "
				+ lastModifiedDate.toString() + "\n");
		stringBuilder.append("File Extension: " + fileExtension + "\n");
		stringBuilder.append("Price: " + price + "\n");
		return stringBuilder.toString();
	}

}
