package controller;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
	Socket clientSocket;
	Socket notifications;
	
	/** Initializes server and client connection
	 * @param servername Name of the server
	 * @param port number for the port
	 */
	
	PrintWriter myWriter;
	
	ObjectInputStream myInputStream;
	ObjectOutputStream myOutputStream;

	public Client(String servername, int port) {
		try {
			clientSocket = new Socket(servername,port);
			System.out.println("Connected Client");
			myWriter = new PrintWriter(clientSocket.getOutputStream(), true);
			
			myOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			myInputStream = new ObjectInputStream(clientSocket.getInputStream());
			
			System.out.println("Done creating client");
			
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
		Client myClient = new Client("localhost", 8081);
	}

}
