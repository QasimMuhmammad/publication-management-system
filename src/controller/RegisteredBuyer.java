package controller;

import java.util.ArrayList;

class RegisteredBuyer
{
	private String userName;
	private String password;
	private RegisteredBuyerController myController;
	
	public RegisteredBuyer(String user, String pass, Client oldClient, ArrayList<Order> myOldOrders)
	{
		userName = user;
		password = pass;
		myController = new RegisteredBuyerController(userName, password,oldClient,myOldOrders);
		
	}

}
