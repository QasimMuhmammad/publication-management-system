package backend.database;

public interface DatabaseInsertStrategy
{
	abstract public void insertFromFile(String[] fields);
}
