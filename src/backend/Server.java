package backend;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
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
			serverSocket.setSoTimeout(1000);
			pool = Executors.newCachedThreadPool();
			databaseController= new DatabaseEntity();
			databaseController.connect();
			databaseController.destroyDatabase();
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
		
		socketAcceptor = new SocketAcceptor();
		socketAcceptor.start();
	}
	
	public void shutdown()
	{
		pool.shutdown();
		databaseController.disconnect();
		socketAcceptor.interrupt();
	}
	
	class SocketAcceptor extends Thread
	{

		@Override
		public void run()
		{
			while (!isInterrupted())
			{
				Socket mySocket;
				try
				{
					mySocket = serverSocket.accept();
					
					System.out.println("Connected Client");
					
					ServerControl handleMessage = new ServerControl(
							mySocket, databaseController);
					System.out.println("About to execute Client");
					pool.execute(handleMessage);
				} catch (SocketTimeoutException e)
				{
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Server server = new Server(9000);
		server.runServer();
		
		
	}
}
