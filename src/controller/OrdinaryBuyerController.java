package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Frontend.OrdinaryBuyerView;
import Frontend.Views;
import backend.database.shared.Book;
import backend.database.shared.Document;

public class OrdinaryBuyerController
{
	Order myOrders;
	OrdinaryBuyerView myViews;
	Client myClient;
	
	
	
	public OrdinaryBuyerController()
	{
		myOrders = new Order();
	}
	
	void setClient(Client myC)
	{
		myClient = myC;
		setupViews();
		initializeViews();
	}
	
	void setupViews()
	{	
		myViews = new OrdinaryBuyerView();
		loginOrdinaryBuyer();
		BuyerListeners(myViews);
		myViews.setVisible(true);
	}
	
	void initializeViews()
	{
		myClient.myWriter.println("INITIALIZE DOCUMENTS");
		receiveDocumentObject();
		
	}
	
	void loginOrdinaryBuyer()
	{
		myViews.getRegisterButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				String user =  myViews.getUserTextField().getText();
				String pass = myViews.getPasswordTextField().getText();
				
				myClient.myWriter.println("Incoming Message");
				myClient.myWriter.println("REGISTER");
				
				myClient.myWriter.println(user + " " + pass);
				System.out.println("Wrote objects to server");
				
				try
				{
					boolean result = (boolean) myClient.myInputStream.readObject();
					myViews.registrationMessage(result);
					
					
				} catch (ClassNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Receiving response from server");		
				
			}
		});;
	
		myViews.getLoginButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String user =  myViews.getUserTextField().getText();
				String pass = myViews.getPasswordTextField().getText();
				System.out.println("Writing to server for a login request, user is "+ user + "password is"+ pass );
				myClient.myWriter.println("Incoming Message");
				myClient.myWriter.println("LOGIN");
				
				try
				{
					myClient.myWriter.println(user + " " + pass);
					System.out.println("Wrote objects to server");
					
					String result = (String) myClient.myInputStream.readObject();
					System.out.println("Receiving response from server");

					switch (result)
					{
					case "Failure":
						myViews.showLoginError();
						break;

					case "Registered Buyer":
						System.out.println("Successful Login!, Registered User");
						myViews.dispose();
						RegisteredBuyer myRegisteredBuyer = new RegisteredBuyer(user, pass,myClient,myOrders);
						break;
					case "Operator":
						System.out.println("Detected correct operator login!");
						Operator myOperator = new Operator(myClient);
						myViews.dispose();
						break;
					}
					
					

				} catch (IOException | ClassNotFoundException e1)
				{
					e1.printStackTrace();
				}
			}
		});
	}
	
	void BuyerListeners(OrdinaryBuyerView myViews)
	{
		myViews.getSearchButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String getSearch = myViews.getSearchTextField().getText();
				System.out.println("Searching.. " + getSearch);
				
				if(getSearch.equals(""))
				{
				initializeViews();	
				}
				else {
				myClient.myWriter.println("SEARCH DOCUMENTS");
				myClient.myWriter.println(getSearch);
				receiveDocumentObject();
				
				}
				
				
			}
		});
		
		myViews.getMakeOrderButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				for (int i = 0; i < myViews.getOrderModel().getSize(); i++)
				{
					String[] args = myViews.getOrderModel().get(i).split(",");
					myOrders.processPayment(args);
				}
				
				boolean result = myViews.processPayment(myOrders);
				if(result)
				{
					JOptionPane.showConfirmDialog(null	, myViews, "SuccessfulPayment", JOptionPane.OK_OPTION);	
					myOrders = new Order();
					myViews.getOrderModel().clear();
					myViews.getOrderJList().setModel(myViews.getOrderModel());
					
				}
				else {
					JOptionPane.showConfirmDialog(null,myViews, "Order was unsuccessful",JOptionPane.OK_OPTION);
				}
				
			}
		});
	
		myViews.getAddToOrderButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int index = myViews.getSearchList().getSelectedIndex();
				if(index>=0)
				{
					String toAdd = myViews.getSearchModel().getElementAt(index);
					myViews.getOrderModel().addElement(toAdd);
					myViews.getOrderJList().setModel(myViews.getOrderModel());
					
				}
				
				
			}
		});
	
		myViews.getRemoveButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				myViews.removeSelected();
				
			}
		});
	}
	
	
	public void receiveDocumentObject()
	{
		try
		{
			Vector<Document> resultOfSearch = (Vector<Document>)myClient.myInputStream.readObject();
			DefaultListModel<String> myModel = new DefaultListModel<String>();
			for (int i = 0; i < resultOfSearch.size(); i++)
			{	
				String price = "$"+ resultOfSearch.get(i).getPrice().toString();
				String type = resultOfSearch.get(i).getType();
				String toAdd= "";
				switch (type)
				{
				case "Journal":
					toAdd += "Journal,";
					break;

				case "Book":
					toAdd += "Book,";
					break;
					
				case "Magazine":
					toAdd += "Magazine,";
					break;
				}
				
				toAdd += resultOfSearch.get(i).getDocumentTitle() + "," + resultOfSearch.get(i).getAuthor() + "," + price;
				myModel.addElement(toAdd);
			}
			
			myViews.setSearchModel(myModel);
			myViews.getSearchList().setModel(myModel);
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
