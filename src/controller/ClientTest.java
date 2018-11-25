package controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import backend.Server;

class ClientTest
{
	public static final int SERVER_PORT = 9001;
	public static final String SERVER_HOSTNAME = "localhost";
	static private Server server;
	static private Client client;

	
	@BeforeAll
	static void setUpClass() throws Exception
	{
		System.out.println("BEFORE CLASS");
		server = new Server(SERVER_PORT);
		server.runServer();
		System.out.println("HELLO");
	}

	
	@BeforeEach
	void setUp() throws Exception
	{
		System.out.println("Stuff");
		client = new Client(SERVER_HOSTNAME, SERVER_PORT);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		client = null;
	}

	@AfterAll
	static void tearDownClass() throws Exception
	{
		System.out.println("Shutting down tests...");
		server.shutdown();
	}

	@Test
	void testClient()
	{
		client.func();
//		fail("Not yet implemented");
	}
	@Test
	void stuff()
	{
		
	}
	

}
