package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frontend.RegisteredView;

public class RegisteredBuyerController extends OrdinaryBuyerController 
{
	RegisteredView myView;
	
	public RegisteredBuyerController(String user,String pass)
	{
		myView = new RegisteredView(user,pass);
		BuyerListeners();
		RegisteredListeners();
		NotificationSetup();
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
