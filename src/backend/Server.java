package backend;
import java.io.IOException;
import java.net.ServerSocket;
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
			databaseController.connect();
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
		
		socketAcceptor = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					while (true)
					{
						ServerControl handleMessage = new ServerControl(
								serverSocket.accept(), databaseController);
						pool.execute(handleMessage);
					}

				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
		
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
		Server myServer = new Server(9000);
		myServer.runServer();

	}

}
