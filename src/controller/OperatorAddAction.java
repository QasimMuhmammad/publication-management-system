package controller;

import java.io.IOException;

import Frontend.OperatorView;
import backend.database.shared.Document;

public class OperatorAddAction implements OperatorModifyStrategy
{

	@Override
	public void performModifyAction(Client myClient, OperatorView myView)
	{
		
		String result = myView.chooseDocumentAddType();
		if(result !=null)
			myClient.myWriter.println("Operator Add");
		
			try
			{
				//myClient.myOutputStream.writeObject(modifiedDocument);
				myClient.myOutputStream.flush();
				myClient.myOutputStream.reset();
			
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	}
	
	
	

}
