package backend.database.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;


public class CSVFileReader implements Iterator<String[]>
{
	private BufferedReader bufferedReader;
	private String nextLine;
	public CSVFileReader(final Path filePath) throws FileNotFoundException
	{
		File file = filePath.toFile();
		if (!file.exists())
		{
			throw new FileNotFoundException();
		}
		bufferedReader = new BufferedReader(new FileReader(file));
		try
		{
			nextLine = bufferedReader.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public boolean hasNext()
	{
		return nextLine != null;
	}

	@Override
	public String[] next()
	{
		String retVal = nextLine;
		try
		{
			if (hasNext())
			{
				nextLine = bufferedReader.readLine();
				return retVal.split(",");
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
