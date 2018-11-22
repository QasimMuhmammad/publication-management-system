import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	/**
	 * Starts the server
	 */
	public Server(int port)
	{
		try
		{
			serverSocket = new ServerSocket(port);
			pool = Executors.newCachedThreadPool();
			System.out.println("Server is running");
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
		try
		{
			while (true)
			{

				ServerControl handleMessage = new ServerControl(
						serverSocket.accept());
				pool.execute(handleMessage);

			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}

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
