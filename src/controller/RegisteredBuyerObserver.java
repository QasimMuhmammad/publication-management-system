package controller;

import java.util.Vector;

import backend.database.shared.Promotion;

public interface RegisteredBuyerObserver
{
	abstract public void update(Vector<Promotion> p);
}
