package controller;
import java.io.IOException;
import java.net.Socket;

public class Client
{
	Socket clientSocket;
	
	/** Initializes server and client connection
	 * @param servername Name of the server
	 * @param port number for the port
	 */
	public Client(String servername, int port) {
		try {
			clientSocket = new Socket(servername,port);
		} catch (IOException e) {
			System.err.println("Unable to connect to the server.");
			e.printStackTrace();
		}
		
		
	}
	
	public void func()
	{
		System.out.println("In Func");
	}
	
	public static void main(String[] args)
	{
		Client myClient = new Client("localhost", 9091);
	}

}
