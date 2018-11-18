import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
	/**
	 * Used to start the server itself
	 */
	ServerSocket serverSocket;
	
	/**
	 * Used to enable multi-threading to handle multiple clients
	 */
	ExecutorService pool;
	
	
	/**
	 * Starts the server
	 */
	public Server() {
		
		try {
			serverSocket = new ServerSocket(9091);
			pool = Executors.newCachedThreadPool();
			System.out.println("Server is running");
		} catch (Exception e) {
			
		}
	}
	
	
	/**
	 * Runs the server
	 */
	public void runServer() {
		try {
			
			while (true) {
				
				ServerControl handleMessage = new ServerControl(serverSocket.accept());
				pool.execute(handleMessage);
				
				
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/** Starts the server
	 * @param args not used
	 */
	public static void main(String[] args) {
		Server myServer = new Server();
		myServer.runServer();
		
	}

	
}
