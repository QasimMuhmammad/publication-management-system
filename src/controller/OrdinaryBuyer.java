package controller;

class OrdinaryBuyer
{
	private OrdinaryBuyerController myController;
	
	public OrdinaryBuyer()
	{
		myController = new OrdinaryBuyerController();
		myController.setClient(new Client("localhost", 8087));
	}
	
	
	public static void main(String[] args)
	{
		OrdinaryBuyer startUp = new OrdinaryBuyer();
	}
}
