package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Frontend.OrdinaryBuyerView;
import Frontend.Views;

public class OrdinaryBuyerController
{
	ArrayList<Order> myOrders;
	OrdinaryBuyerView myViews;
	
	
	
	public OrdinaryBuyerController()
	{
		myViews = new OrdinaryBuyerView();
		registerOrdinaryBuyer();
		
	}
	
	
	void registerOrdinaryBuyer()
	{
		myViews.getRegisterButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				
			}
		});;
	}
	
	
}
