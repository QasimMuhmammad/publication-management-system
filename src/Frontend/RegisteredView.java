package Frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class RegisteredView extends OrdinaryBuyerView
{	
	String username;
	String password;
	private JButton btnUnsubscribe;
	private JList promotions_List;
	
	public RegisteredView(String user, String pass )
	{
		setupBeginning();
		addNormal();
		addRegisteredParts();
		username = user;
		password = pass;
	}

	void addRegisteredParts()
	{
		JLabel lblNewLabel_3 = new JLabel("Promotions");
		lblNewLabel_3.setBounds(77, 150, 81, 16);
		contentPane.add(lblNewLabel_3);
		
		promotions_List = new JList();
		promotions_List.setBounds(16, 178, 194, 77);
		contentPane.add(promotions_List);
		
		btnUnsubscribe = new JButton("Unsubscribe");
		btnUnsubscribe.setBounds(288, 145, 117, 29);
		contentPane.add(btnUnsubscribe);
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
		Views view = new RegisteredView("Qasim","qazxsw");
		view.setVisible(true);
	}
}
