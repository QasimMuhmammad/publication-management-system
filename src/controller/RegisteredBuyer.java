package controller;

import java.util.ArrayList;
import java.util.Vector;

import backend.database.shared.Promotion;

class RegisteredBuyer
{
	private String userName;
	private String password;
	private RegisteredBuyerController myController;
	
	public RegisteredBuyer(String user, String pass, Client oldClient, Order myOldOrders)
	{
		userName = user;
		password = pass;
		myController = new RegisteredBuyerController(userName, password,oldClient,myOldOrders);
		
	}

	public void setPromotionsList(Vector<Promotion> myPromotionList)
	{
		myController.setPromotionsList(myPromotionList);
	}

	public RegisteredBuyerController getRegisteredBuyerController()
	{
		return myController;
	}
}
