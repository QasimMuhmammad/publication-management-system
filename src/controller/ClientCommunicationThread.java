package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientCommunicationThread extends Thread
{
	private PrintWriter printWriter;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	
	public ClientCommunicationThread(Socket socket)
	{
		try
		{
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (SocketTimeoutException e)
		{
			// do nothing
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		while(!isInterrupted())
		{
			
		}
	}
}
