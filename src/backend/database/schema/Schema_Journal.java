package backend.database.schema;

public interface Schema_Journal extends Schema_Document
{
	// Changes Made: Removed journalTitle
	public static final String JOURNAL_TABLENAME = "journal";
	
	public static final String JOURNAL_PATH 
	= "src/backend/database/data/journal.txt";
}
