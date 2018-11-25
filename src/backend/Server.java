package backend;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import backend.database.DatabaseEntity;

public class Server
{
	/**
	 * Used to start the server itself
	 */
	private ServerSocket serverSocket;

	/**
	 * Used to enable multi-threading to handle multiple clients
	 */
	private ExecutorService pool;
	
	private Thread socketAcceptor;
	
	private DatabaseEntity databaseController;
	
	/**
	 * Starts the server
	 */
	public Server(int port)
	{
		try
		{
			serverSocket = new ServerSocket(port);
			pool = Executors.newCachedThreadPool();
			databaseController= new DatabaseEntity();
			databaseController.connect();
			databaseController.prepareDatabase();
			System.out.println("Server set up");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Runs the server
	 */
	public void runServer()
	{
		System.out.println("Server is running");
		
		
				try
				{System.out.println("Waiting to Connect Client");
					while (true)
					{
						Socket mySocket = serverSocket.accept();
						System.out.println("Connected Client");

						ServerControl handleMessage = new ServerControl(
								mySocket, databaseController);
						System.out.println("About to execute Client");
						pool.execute(handleMessage);
					}
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			
		
	
		
	}
	
	public void shutdown()
	{
		pool.shutdown();
		databaseController.disconnect();
	}

	/**
	 * Starts the server
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args)
	{
		Server myServer = new Server(8086);
		myServer.runServer();

	}

}
