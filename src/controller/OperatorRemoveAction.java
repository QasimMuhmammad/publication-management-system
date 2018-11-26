package controller;

import java.io.IOException;

import Frontend.OperatorView;

public class OperatorRemoveAction implements OperatorModifyStrategy
{

	@Override
	public void performModifyAction(Client myClient, OperatorView myView)
	{
		// TODO Auto-generated method stub
		int toDelete = myView.getList().getSelectedIndex();
		if(toDelete >=0)
		{
			myClient.myWriter.println("Operator Remove");
			String[] args = myView.getModel().getElementAt(toDelete).split(",");
			
			String toSend = args[0] + "," + args[1];
			myClient.myWriter.println(toSend);
		}
					

	}

	
}