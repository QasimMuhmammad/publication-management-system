package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultListModel;

import Frontend.OperatorView;
import backend.database.shared.Document;

public class OperatorController
{
	OperatorView myView;
	Client myConnection;
	String username;
	
	OperatorModifyStrategy modifyStrategy;
	
	public OperatorController(Client myClient)
	{	
		System.out.println("In operator controller constructor!");
		myConnection = myClient;
		myView = new OperatorView();
		myView.setVisible(true);
		setupListeners();
		initializeView();
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
				initializeView();
				
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
	
	public void initializeView()
	{
		myConnection.myWriter.println("INITIALIZE DOCUMENTS");
		try
		{
			Vector<Document> resultOfSearch = (Vector<Document>)myConnection.myInputStream.readObject();
			DefaultListModel<String> myModel = new DefaultListModel<String>();
			for (int i = 0; i < resultOfSearch.size(); i++)
			{	
				String type = resultOfSearch.get(i).getType();
				String toAdd= "";
				toAdd+= resultOfSearch.get(i).getDocumentId()  + ",";
				switch (type)
				{
				case "Journal":
					toAdd += "Journal,";
					break;

				case "Book":
					toAdd += "Book,";
					break;
					
				case "Magazine":
					toAdd += "Magazine,";
					break;
				}
				
				toAdd += resultOfSearch.get(i).getDocumentTitle() + "," + resultOfSearch.get(i).getAuthor();
				myModel.addElement(toAdd);
			}
			
			myView.setModel(myModel);
			myView.getList().setModel(myModel);
			myView.setDocuments(resultOfSearch);
			
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
