package controller;

import java.text.DecimalFormat;
import java.util.Vector;

public class Order
{
	private Vector<String> documents;
	private Vector<Payment> prices;
	private String address;
	private String dateReceived;
	String creditCardNum;
	
	public Order()
	{
		documents = new Vector<String>();
		prices = new Vector<Payment>();
	}
	
	
	
	
	public void processPayment(String[] args)
	{
		documents.addElement(args[0] + " " + args[1]);
		prices.addElement(new Payment(Double.valueOf(args[3].substring(1,args[3].length()))));
		
	}
	
	public Double calculateTotal()
	{
		Double result= 0.00;
		for(int i =0; i < prices.size(); i++)
		{
			result+= prices.get(i).calculateWithTax();
		}
		
		return result;
	}
	
	
}	
