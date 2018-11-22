package backend;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

	/**
	 * Initializes the Control object
	 * 
	 * @param toConnect
	 *            connects the server to ClientGUI
	 */
	public ServerControl(Socket toConnect)
	{
		try
		{
			outputMessage = new ObjectOutputStream(toConnect.getOutputStream());
			inputMessage = new ObjectInputStream(toConnect.getInputStream());
			fromClient = new BufferedReader(
					new InputStreamReader(toConnect.getInputStream()));
		} catch (IOException e)
		{
			e.getStackTrace();
		}
	}

	/*
	 * Runs this thread
	 */
	public void run()
	{
		while (true)
		{
			try
			{
				if (fromClient.readLine().equals("Incoming Message"))
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

}
