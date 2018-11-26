package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


import Frontend.RegisteredView;
import backend.database.shared.Promotion;

public class RegisteredBuyerController extends OrdinaryBuyerController 
{
	private RegisteredView myViews;
	
	
	public RegisteredBuyerController(String user,String pass,Client oldClient, Order myOldOrders)
	{
		myClient = oldClient;
		myOrders = myOldOrders;
		myViews = new RegisteredView(user,pass);
		System.out.println("constructor 1");
		BuyerListeners(myViews);
		RegisteredListeners();
		System.out.println("constructor 2");
		NotificationSetup();
		initializeViews(myViews);
		System.out.println("constructor 3");
		myViews.setVisible(true);
		System.out.println("RB VISIBLE YES:" );
	}
	
	public void RegisteredListeners()
	{
		myViews.getUnsubscribeButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				myClient.myWriter.println("UNSUBSCRIBE");
				myViews.dispose();
				OrdinaryBuyerController ordinaryBuyerController = new OrdinaryBuyerController();
				ordinaryBuyerController.setClient(new Client("localhost", 9000));
				ordinaryBuyerController.setupViews();
				ordinaryBuyerController.initializeViews(myViews);
				
			}
		});
		
		
	}
	
	public void NotificationSetup()
	{
		
		
		
		
	}
	
	public void handlePromotionList()
	{
		
	}

	public void setPromotionsList(Vector<Promotion> myPromotionList)
	{
		myViews.setPromotionList(myPromotionList);
	}
}
