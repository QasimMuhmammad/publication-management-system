package controller;

import java.util.Vector;

public class ConcreteRegisteredBuyerObserver implements RegisteredBuyerObserver
{
	private Vector<String> thePromotionList;
	
	public ConcreteRegisteredBuyerObserver()
	{
		// TESTING CODE
		// TODO: Remove
		thePromotionList = new Vector<>();
//		thePromotionList.add("First item");
//		thePromotionList.add("Second item");
//		thePromotionList.add("Third item");
//		thePromotionList.add("Fourth item");
//		thePromotionList.add("Fifth item");
//		thePromotionList.add("Sixth item");
	}
	
	public void update(Vector<String> p)
	{
		thePromotionList = p;
	}
	
	public Vector<String> getPromotionList()
	{
		return thePromotionList;
	}
}
