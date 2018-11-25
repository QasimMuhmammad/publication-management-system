package controller;

import java.io.IOException;

import Frontend.OperatorView;
import backend.database.shared.Document;

public class OperatorAddAction implements OperatorModifyStrategy
{

	@Override
	public void performModifyAction(Client myClient, OperatorView myView)
	{
		// TODO Auto-generated method stub
		//Document modifiedDocument = myView.getNewDocument();
		myClient.myWriter.println("");
		myClient.myWriter.println("");
		
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
