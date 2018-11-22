import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientTest
{
	public static final int SERVER_PORT = 9000;
	private Server server;
	private Client client;

	@BeforeClass
	void setUpClass() throws Exception
	{
		server = new Server(9000);
		server.runServer();
	}

	@BeforeEach
	void setUp() throws Exception
	{
		client = new Client("locahost", SERVER_PORT);

	}

	@AfterEach
	void tearDown() throws Exception
	{
		client = null;

	}

	@AfterClass
	void tearDownClass() throws Exception
	{
		server = null;
	}

	@Test
	void testClient()
	{
		fail("Not yet implemented");
	}

}
