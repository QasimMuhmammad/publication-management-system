package backend.database.data;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;

import org.junit.jupiter.api.Test;

class CSVFileReaderTest
{

	@Test
	void testReadFile()
	{
		File file = new File("src/backend/database/data/login.txt");
		Path path = file.toPath();
		System.out.println(file.getAbsolutePath());
		
		try
		{
			CSVFileReader test = new CSVFileReader(path);
			
			while (test.hasNext())
			{
				StringBuilder out = new StringBuilder();
				String[] fields = test.next();
				for (String string : fields)
				{
					out.append(string + ", ");
				}
				System.out.println(out);
			}
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
