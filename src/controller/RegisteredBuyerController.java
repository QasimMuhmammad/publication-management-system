package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Vector;

import Frontend.RegisteredView;
import backend.database.shared.Promotion;

public class RegisteredBuyerController extends OrdinaryBuyerController
{
	private RegisteredView myViews;
	private Socket notification;
	private Thread notifyThread;

	public RegisteredBuyerController(String user, String pass, Client oldClient,
			Order myOldOrders)
	{
		myClient = oldClient;
		myOrders = myOldOrders;
		myViews = new RegisteredView(user, pass);
		System.out.println("constructor 1");
		BuyerListeners(myViews);
		RegisteredListeners();
		System.out.println("constructor 2");
		NotificationSetup();
		initializeViews(myViews);
		System.out.println("constructor 3");
		myViews.setVisible(true);
		System.out.println("RB VISIBLE YES:");

	}

	public void RegisteredListeners()
	{
		myViews.getUnsubscribeButton().addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					notification.close();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				myClient.myWriter.println("UNSUBSCRIBE");
				myViews.dispose();
				OrdinaryBuyerController ordinaryBuyerController = new OrdinaryBuyerController();
				ordinaryBuyerController
						.setClient(new Client("localhost", 9000));
				ordinaryBuyerController.setupViews();
				ordinaryBuyerController.initializeViews(myViews);

			}
		});

	}

	public void NotificationSetup()
	{
		try
		{
			notification = new Socket("localhost", 9001);
			notification.setSoTimeout(1000);
			ObjectInputStream objectInputStream = new ObjectInputStream(
					notification.getInputStream());
			notifyThread = new NotificationThread(objectInputStream);
			notifyThread.start();
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void handlePromotionList()
	{

	}

	public void setPromotionsList(Vector<Promotion> myPromotionList)
	{
		myViews.setPromotionList(myPromotionList);
	}

	class NotificationThread extends Thread
	{
		private ObjectInputStream objectInputStream;

		public NotificationThread(ObjectInputStream objectInputStream)
		{
			this.objectInputStream = objectInputStream;
		}

		@Override
		public void run()
		{
			System.out.println("Begin Notification Thread");
			while (!isInterrupted())
			{
				try
				{
					Vector<Promotion> promotions = (Vector<Promotion>) objectInputStream
							.readObject();

					if (promotions != null)
					{
						System.out.println("Notification success!");
						setPromotionsList(promotions);
						myViews.showNotification();
					}
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SocketTimeoutException e)
				{
					
					// do nothing on timeout.
				}

				catch (SocketException e)
				{
					System.err.println(
							"Socket Exception. Shutting down listener.");
					e.printStackTrace();
					break;
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			System.out.println("Shutting down notification thread...");
		}
	}
}
