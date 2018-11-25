package backend.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

import backend.database.data.CSVFileReader;

public class DatabaseFileLoader
{
	private Path path;
	private DatabaseInsertStrategy strategy;
	
	public void setFile(File file)
	{
		this.path = file.toPath();
	}
	
	public void setDatabaseInsertStrategy(DatabaseInsertStrategy strategy)
	{
		this.strategy = strategy;
	}
	
	public void performInsertStrategy()
	{
		try
		{
			CSVFileReader reader = new CSVFileReader(path);
			
			while (reader.hasNext())
			{
				String[] fields = reader.next();
				strategy.insert(fields);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
