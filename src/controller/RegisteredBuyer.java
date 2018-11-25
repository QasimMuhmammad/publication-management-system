package controller;

import java.util.ArrayList;

class RegisteredBuyer
{
	String userName;
	String password;
	RegisteredBuyerController myController;
	
	public RegisteredBuyer(String user, String pass, Client oldClient, Order myOldOrders)
	{
		userName = user;
		password = pass;
		myController = new RegisteredBuyerController(userName, password,oldClient,myOldOrders);
		
	}
	

}
