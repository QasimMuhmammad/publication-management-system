package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Frontend.OrdinaryBuyerView;
import Frontend.Views;

public class OrdinaryBuyerController
{
	ArrayList<Order> myOrders;
	OrdinaryBuyerView myViews;
	Client myClient;
	
	
	
	public OrdinaryBuyerController()
	{
	}
	
	void setClient(Client myC)
	{
		myClient = myC;
		setupViews();
	}
	
	void setupViews()
	{	
		myViews = new OrdinaryBuyerView();
		loginOrdinaryBuyer();
		BuyerListeners(myViews);
		myViews.setVisible(true);
	}
	
	
	void loginOrdinaryBuyer()
	{
		myViews.getRegisterButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				String user =  myViews.geTextField().getText();
				String pass = myViews.geTextField1().getText();
				
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
				String user =  myViews.geTextField().getText();
				String pass = myViews.geTextField1().getText();
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
						myViews.dispose();
						Operator myOperator = new Operator(myClient);
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
				myViews.getOrderModel().addElement("Hello");
				myViews.getSearchModel().addElement("Hello2");
				
				myViews.getOrderJList().setModel(myViews.getOrderModel());
				myViews.getSearchList().setModel(myViews.getSearchModel());
				
				
			}
		});
		
		myViews.getMakeOrderButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//Order myOrder = myViews.getOrder();
				
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
	
	
}
