package controller;

public interface PromotionListSubject
{
	abstract public void register(RegisteredBuyerObserver o);
	abstract public void unregister(RegisteredBuyerObserver o);
	abstract public void notifyAllObservers();
}
