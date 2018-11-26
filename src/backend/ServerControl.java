package backend;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import com.mysql.cj.xdevapi.DbDoc;

import backend.database.DatabaseEntity;
import backend.database.LOGIN_USERS;
import backend.database.shared.Book;
import backend.database.shared.Document;
import backend.database.shared.Promotion;
import controller.ConcretePromotionListSubject;
import controller.ConcreteRegisteredBuyerObserver;
import controller.PromotionListSubject;

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

	Socket socket;

	private ConcreteRegisteredBuyerObserver observer;

	private String username;
	private String password;
	private String type;

	/**
	 * Connects the reader to tell server when the client sends a message
	 */
	BufferedReader fromClient;

	private DatabaseEntity databaseEntity;

	private ConcretePromotionListSubject promotionList;

	/**
	 * Initializes the Control object
	 *
	 * @param toConnect
	 *            connects the server to ClientGUI
	 */
	public ServerControl(Socket toConnect, DatabaseEntity db,
			ConcretePromotionListSubject subject)
	{
		this.promotionList = subject;
		this.socket = toConnect;
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
			databaseEntity = db;
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
				System.out.println("Initial Command is " + intialCommand);
				if (intialCommand.equals("Incoming Message"))
				{
					String command = fromClient.readLine();
					System.out.println("INcoming message is " + command);
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
						System.out.println("UNSUBSCRIBE ATTEMPT");
						handleUnsubscribe();
						break;
					case "LOGOUT":
						handleLogout();
						break;
					default:
						System.err.println("Error: Don't know what " + command + " means...");
						break;
					}

				}
				else if(intialCommand.equals("INITIALIZE DOCUMENTS"))
				{
					handlieInitialize();

				}
				else if(intialCommand.equals("SEARCH DOCUMENTS"))
				{
					handleSearch();
				}
				else if(intialCommand.equals("Operator Remove"))
				{
					handleOperatorRemove();
				}

				else
				{
					System.err.println("Error: What does " + intialCommand + " mean?");
				}

			} catch (SocketException e)
			{
				break;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
}

	private void handleUnsubscribe()
	{
		if (!databaseEntity.unregisterUser(username, password))
		{
			System.err.println("Unable to unregister user " + username);
			try
			{
				throw new Exception();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Successfully deleted " + username + " from the database");
		handleLogout();
	}

	private void handleLogout()
	{

		if (type.equals(LOGIN_USERS.LOGIN_USER_REGISTERED_BUYER))
		{
			promotionList.unregister(observer);
		}
		try
		{
			socket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	private void handleOperatorRemove()
	{
		System.out.println("Operator Removing");
		try
		{
			String[] toRemove = fromClient.readLine().split(",");
			databaseController.removeDocument(toRemove);

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void handleLogin()
	{
		try
		{
			System.out.println("Waiting for input from client");
			String user = fromClient.readLine();
			String[] arr = user.split(" ");
			username = arr[0];
			password = arr[1];
			System.out.println("Recieved Username" + arr[0] + " and Password " + arr[1]);
			type = databaseEntity.login(arr[0],arr[1]);


			System.out.println("Sending back " + type);
			outputMessage.flush();
			outputMessage.reset();

			outputMessage.writeObject(type);

			if (type.equals(LOGIN_USERS.LOGIN_USER_REGISTERED_BUYER))
			{
				// TODO: Add a logout command to unregister a user when they
				// log out.
				observer = new ConcreteRegisteredBuyerObserver(promotionList,
						socket);

				outputMessage.writeObject(databaseEntity.getAllPromotions());
				outputMessage.flush();
				outputMessage.reset();

			}



		} catch (IOException e)
		{
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

			boolean result = databaseEntity.registerUser(arr[0], arr[1]);
			System.out.println("Sending back " + result);
			outputMessage.writeObject(result);
			outputMessage.flush();
			outputMessage.reset();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void handlieInitialize()
	{
		System.out.println("Initializing all the documents");
		Vector<Document> myBooks = databaseEntity.getAllDocuments();

		try
		{
			outputMessage.writeObject(myBooks);
			outputMessage.flush();
			outputMessage.reset();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void handleSearch()
	{
		System.out.println("Handling a search request");
		String docName;
		try
		{
			docName = fromClient.readLine();
			Vector<Document> mySearchResult = (databaseEntity.getSearch(docName));
			System.out.println("Sending back size of " + mySearchResult.size());
			outputMessage.writeObject(mySearchResult);
			outputMessage.flush();
			outputMessage.reset();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
