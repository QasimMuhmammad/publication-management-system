package backend.database;

public interface DatabaseInsertStrategy
{
	abstract public void insert(String[] fields);
}
