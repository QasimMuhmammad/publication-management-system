package backend.database.shared;

import java.io.Serializable;

public class Promotion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String promotionString;
	
	public Promotion(int id, String promotion)
	{
		this.id = id;
		this.promotionString = promotion;
	}

	public int getId()
	{
		return id;
	}

	public String getPromotionString()
	{
		return promotionString;
	}
	
	@Override
	public String toString()
	{
		return promotionString;
	}
	
}
