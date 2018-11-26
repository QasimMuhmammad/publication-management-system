package controller;

public class Operator
{
	OperatorController myController;
	
	public Operator(Client toConnect)
	{
		myController = new OperatorController(toConnect);
	}
		
	
}
