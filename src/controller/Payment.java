package controller;

public class Payment
{
	Double price;
	
	public Payment(Double p)
	{
		price = p;
	}

	double calculateWithTax()
	{
		return price + (price * 0.05);
	}
}
