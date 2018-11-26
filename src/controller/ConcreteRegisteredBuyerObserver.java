package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import backend.database.shared.Promotion;


public class ConcreteRegisteredBuyerObserver implements RegisteredBuyerObserver
{
	private Vector<Promotion> thePromotionList;
	private ObjectOutputStream objectOutputStream;
	
	public ConcreteRegisteredBuyerObserver(ConcretePromotionListSubject p,
			Socket socket)
	{
		
		p.register(this);
		thePromotionList = new Vector<Promotion>();
		this.update(p.getPromotionList());
	}
	
	@Override
	public void update(Vector<Promotion> p)
	{
		thePromotionList = p;
		notification();
	}
	
	public void notification()
	{
//		try
//		{
//			objectOutputStream.writeObject(new String("UPDATE PROMOTION"));
//			objectOutputStream.writeObject(thePromotionList);
//			objectOutputStream.flush();
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// TODO: Display notification on GUI
	}
}
