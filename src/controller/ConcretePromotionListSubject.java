package controller;

import java.util.Vector;

import backend.database.shared.Promotion;

public class ConcretePromotionListSubject implements PromotionListSubject
{

	private Vector<Promotion> thePromotionList;
	private Vector<RegisteredBuyerObserver> allRegisteredBuyers;
	
	public ConcretePromotionListSubject()
	{
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
	
	public void setPromotionList(Vector<Promotion> list)
	{
		thePromotionList = list;
		notifyAllObservers();
	}
	
	public void addPromotion(Promotion promotion)
	{
		thePromotionList.add(promotion);
		notifyAllObservers();
	}
	
	public void removePromotion(Promotion promotion)
	{
		thePromotionList.remove(promotion);
		notifyAllObservers();
	}
	
	public Vector<Promotion> getPromotionList()
	{
		return thePromotionList;
	}

	
}
