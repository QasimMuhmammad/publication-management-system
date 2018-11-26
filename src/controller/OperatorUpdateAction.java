package controller;

import java.io.IOException;

import Frontend.OperatorView;
import backend.database.shared.Document;

public class OperatorUpdateAction implements OperatorModifyStrategy
{

	@Override
	public void performModifyAction(Client myClient, OperatorView myView)
	{	
		int result = myView.getList().getSelectedIndex();
		
		if(result >=0)
			myClient.myWriter.println("Operator Modify");
			String val[] = myView.getModel().get(result).split(",");
			String results = val[1];
		
			Document toAdd = null;
			switch (results)
			{
			case "Magazine":
				toAdd = myView.getMagazine(true);
				break;

			case "Journal":
				toAdd = myView.getJournal(true);
				break;
			
			case "Book":
				toAdd = myView.getBook(true);
				break;
			}
		
			if(toAdd != null)
			{	try
				{	
					System.out.println("Sending a" + toAdd.getType());
					myClient.myOutputStream.writeObject(toAdd);
					myClient.myOutputStream.flush();
					myClient.myOutputStream.reset();
					
					
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		
	}

}
