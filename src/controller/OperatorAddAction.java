package controller;

import java.io.IOException;
import java.util.Date;

import Frontend.OperatorView;
import backend.database.shared.Document;
import backend.database.shared.Magazine;

public class OperatorAddAction implements OperatorModifyStrategy
{

	@Override
	public void performModifyAction(Client myClient, OperatorView myView)
	{
		
		String result = myView.chooseDocumentAddType();
		if(result !=null)
			myClient.myWriter.println("Operator Add");
			Document toAdd = null;
			switch (result)
			{
			case "Magazine":
				toAdd = myView.getMagazine(false);
				break;

			case "Journal":
				toAdd = myView.getJournal(false);
				break;
			
			case "Book":
				toAdd = myView.getBook(false);
				break;
			}
		
			if(toAdd != null)
			{	try
				{	System.out.println("Seinding an " + toAdd.getType());
					myClient.myOutputStream.reset();
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
