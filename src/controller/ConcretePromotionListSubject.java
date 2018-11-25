package controller;

import java.util.Vector;

public class ConcretePromotionListSubject implements PromotionListSubject
{

	private Vector<String> thePromotionList;
	private Vector<RegisteredBuyerObserver> allRegisteredBuyers;
	
	public ConcretePromotionListSubject()
	{
		thePromotionList = new Vector<String>();
		allRegisteredBuyers = new Vector<RegisteredBuyerObserver>();
	}
	
	@Override
	public void register(RegisteredBuyerObserver o)
	{
		allRegisteredBuyers.addElement(o);
	}

	@Override
	public void unregister(RegisteredBuyerObserver o)
	{
		allRegisteredBuyers.remove(o);
	}

	@Override
	public void notifyAllObservers()	// notifies all registered buyers (updates their promotion list)
	{
		for(int i = 0; i < allRegisteredBuyers.size(); i++)
			allRegisteredBuyers.get(i).update(thePromotionList);
	}
	
	public void addPromotion(String promotion)
	{
		thePromotionList.add(promotion);
		notifyAllObservers();
	}
	
	public void removePromotion(String promotion)
	{
		thePromotionList.remove(promotion);
		notifyAllObservers();
	}
	
	public Vector<String> getPromotionList()
	{
		return thePromotionList;
	}

	
}
