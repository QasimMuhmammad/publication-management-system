package controller;

import java.util.Vector;


public class ConcreteRegisteredBuyerObserver implements RegisteredBuyerObserver
{
	private Vector<String> thePromotionList;
	
	public ConcreteRegisteredBuyerObserver(ConcretePromotionListSubject p)
	{
		p.register(this);
		thePromotionList = new Vector<>();
		this.update(p.getPromotionList());
	}
	
	@Override
	public void update(Vector<String> p)
	{
		thePromotionList = p;
		notification();
	}
	
	public void notification()
	{
		// TODO: Display notification on GUI
	}
}
