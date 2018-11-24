package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Frontend.RegisteredView;

public class RegisteredBuyerController extends OrdinaryBuyerController 
{
	RegisteredView myView;
	
	public RegisteredBuyerController(String user,String pass,Client oldClient, ArrayList<Order> myOldOrders)
	{
		myClient = oldClient;
		myOrders = myOldOrders;
		myView = new RegisteredView(user,pass);
		BuyerListeners();
		RegisteredListeners();
		NotificationSetup();
		myView.setVisible(true);
	}
	
	public void RegisteredListeners()
	{
		myView.getUnsubscribeButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	public void NotificationSetup()
	{
		
		
		
		
	}
}
