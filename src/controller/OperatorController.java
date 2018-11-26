package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frontend.OperatorView;

public class OperatorController
{
	OperatorView myView;
	Client myConnection;
	String username;
	
	OperatorModifyStrategy modifyStrategy;
	
	public OperatorController(Client myClient)
	{	
		System.out.println("In operator controller constructor!");
		myView = new OperatorView();
		myView.setVisible(true);
		setupListeners();
	}
	
	public void setupListeners()
	{
		myView.getRemoveButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				modifyStrategy = new OperatorRemoveAction();
				modifyStrategy.performModifyAction(myConnection, myView);
				
			}
		});
			
		myView.getAddButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				modifyStrategy = new OperatorAddAction();
				modifyStrategy.performModifyAction(myConnection, myView);
				
			}
		});
		
		myView.getUpdateButton().addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				modifyStrategy = new OperatorUpdateAction();
				modifyStrategy.performModifyAction(myConnection, myView);
				
			}
		});
	}
	
}
