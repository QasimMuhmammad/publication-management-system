package Frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class RegisteredView extends OrdinaryBuyerView
{	
	String username;
	String password;
	private JButton btnUnsubscribe;
	private JList<String> promotionsDisplay;
	private DefaultListModel<String> promotionsModel;
	private JScrollPane scrollPane;
	
	public RegisteredView(String user, String pass, Vector<String> thePromotionList )
	{
		setupBeginning();
		addNormal();
		setPromotionList(thePromotionList);
		addRegisteredParts();
		username = user;
		password = pass;
	}

	void addRegisteredParts()
	{
		JLabel lblNewLabel_3 = new JLabel("Promotions");
		lblNewLabel_3.setBounds(77, 150, 81, 16);
		contentPane.add(lblNewLabel_3);
		
		scrollPane.setBounds(16, 178, 194, 77);
		contentPane.add(scrollPane);
		
		btnUnsubscribe = new JButton("Unsubscribe");
		btnUnsubscribe.setBounds(288, 145, 117, 29);
		contentPane.add(btnUnsubscribe);
	}
	
	public void setPromotionList(Vector<String> thePromotionList)
	{
		promotionsModel = new DefaultListModel<String>();
		for(int i = 0; i < thePromotionList.size(); i++)
			promotionsModel.addElement(thePromotionList.get(i));
		promotionsDisplay = new JList<String>(promotionsModel);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(promotionsDisplay);
	}
	
	public JButton getUnsubscribeButton()
	{
		return btnUnsubscribe;
	}
	
	public JList getPromotionsList()
	{
		return getPromotionsList();
	}
	
	public static void main(String[] args)
	{
		Views view = new RegisteredView("Qasim","qazxsw", null);
		view.setVisible(true);
	}
}
