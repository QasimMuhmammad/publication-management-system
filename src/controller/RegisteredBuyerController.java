package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import Frontend.RegisteredView;

public class RegisteredBuyerController extends OrdinaryBuyerController 
{
	private RegisteredView myViews;
	private ConcreteRegisteredBuyerObserver observer;
	private ConcretePromotionListSubject promotionList;
	
	
	public RegisteredBuyerController(String user,String pass,Client oldClient, ArrayList<Order> myOldOrders)
	{
		myClient = oldClient;
		myOrders = myOldOrders;
		promotionList = new ConcretePromotionListSubject();
		myViews = new RegisteredView(user,pass,promotionList.getPromotionList());
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
