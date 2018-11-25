package controller;

import java.util.Vector;

public class ConcreteRegisteredBuyerObserver implements RegisteredBuyerObserver
{
	private Vector<String> thePromotionList;
	
	public void update(Vector<String> p)
	{
		thePromotionList = p;
	}
	
	public void display()
	{
		// display promotion list on the GUI 
	}
	
	public Vector<String> getPromotionList()
	{
		return thePromotionList;
	}
}
