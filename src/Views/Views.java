package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Views extends JFrame
{
	//JPanel contentPane;
	
	void chooseView(String userType)
	{
		switch (userType)
		{
		case "OrdinaryBuyer":
			
			break;
		case "RegisteredBuyer":
			break;
			
		case "Opertor":
			break;
		}
		
	}
	
	public static void main(String[] args)
	{
		OrdinaryBuyerView myViews= new OrdinaryBuyerView();
		myViews.setVisible(true);
		
	}
}
