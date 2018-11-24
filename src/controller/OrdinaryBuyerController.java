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
		loginOrdinaryBuyer();
		BuyerListeners();
		myViews.setVisible(true);
	}
	
	
	void loginOrdinaryBuyer()
	{
		myViews.getRegisterButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				
			}
		});;
	
		myViews.getLoginButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void BuyerListeners()
	{
		myViews.getSearchButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		myViews.getMakeOrderButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	
		myViews.getAddToOrderButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	
		myViews.getRemoveButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
