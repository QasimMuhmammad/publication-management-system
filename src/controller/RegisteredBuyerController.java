package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Frontend.RegisteredView;

public class RegisteredBuyerController extends OrdinaryBuyerController 
{
	private RegisteredView myViews;
	private ConcreteRegisteredBuyerObserver observer;
	
	
	public RegisteredBuyerController(String user,String pass,Client oldClient, ArrayList<Order> myOldOrders)
	{
		myClient = oldClient;
		myOrders = myOldOrders;
		myViews = new RegisteredView(user,pass);
		observer = new ConcreteRegisteredBuyerObserver();
		BuyerListeners(myViews);
		RegisteredListeners();
		NotificationSetup();
		myViews.setVisible(true);

	}
	
	public void RegisteredListeners()
	{
		myViews.getUnsubscribeButton().addActionListener(new ActionListener()
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
	
	public void handlePromotionList()
	{
		
	}
}
