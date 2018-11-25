package backend;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import backend.database.DatabaseEntity;

/**
 * Used by server to enable multi-threaded clients
 * 
 * @author qasimmuhammad
 *
 */
public class ServerControl implements Runnable
{

	/**
	 * Used to output Messages to client
	 */
	ObjectOutputStream outputMessage;

	/**
	 * Used to input messages to client
	 */
	ObjectInputStream inputMessage;

	/**
	 * Connects the reader to tell server when the client sends a message
	 */
	BufferedReader fromClient;
	
	private DatabaseEntity databaseController;

	/**
	 * Initializes the Control object
	 * 
	 * @param toConnect
	 *            connects the server to ClientGUI
	 */
	public ServerControl(Socket toConnect, DatabaseEntity db)
	{
		try
		{
			System.out.println("Setting up server control");
			outputMessage = new ObjectOutputStream(toConnect.getOutputStream());
			System.out.println("Setting up server control1");
			
			// HANGS HERE
			inputMessage = new ObjectInputStream(toConnect.getInputStream());
			
			System.out.println("Setting up server control2");
			fromClient = new BufferedReader(
					new InputStreamReader(toConnect.getInputStream()));
			databaseController = db;
			System.out.println("Finished Setting up server control3");

		} catch (IOException e)
		{
			e.getStackTrace();
		}
	}

	/*
	 * Runs this thread
	 */
	public void run()
	{	System.out.println("Running SERVER-Q");
		while (true)
		{
			System.out.println("Running SERVER-Q2");
			try
			{	String intialCommand = fromClient.readLine();
				
				if (intialCommand.equals("Incoming Message"))
				{
					String command = fromClient.readLine();
					switch (command)
					{
					case "LOGIN":
						System.out.println("LOGIN ATTEMPT");
						handleLogin();
						break;

					case "REGISTER":
						System.out.println("REGISTER ATTEMPT");
						handleRegistration();
						break;
					case "UNSUBSCRIBE":
						// handleUnsubscribe();
					}
					
				}
				else if(intialCommand.equals("Setup Message"))
				{
					
					
				}
				
				
			} catch (IOException e)
			{
				e.printStackTrace();
			} catch (NullPointerException e)
			{
				System.out.println("A client has closed");
				break;
			}

		}

	}

	
	public void handleLogin()
	{
		try
		{
			System.out.println("Waiting for input from client");
			String user = fromClient.readLine();
			String[] arr = user.split(" ");
			
			System.out.println("Recieved Username" + arr[0] + " and Password " + arr[1]);
			String result = databaseController.login(arr[0],arr[1]);
			
			System.out.println("Sending back " + result);

			outputMessage.writeObject(result);
			outputMessage.flush();
			outputMessage.reset();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void handleRegistration()
	{
		System.out.println("Waiting for input from client");
		String user;
		try
		{
			user = fromClient.readLine();
			String[] arr = user.split(" ");
			
			boolean result = databaseController.registerUser(arr[0], arr[1]);
			System.out.println("Sending back " + result);
			outputMessage.writeObject(result);
			outputMessage.flush();
			outputMessage.reset();
			
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
