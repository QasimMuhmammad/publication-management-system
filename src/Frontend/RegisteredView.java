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
		
		JList list_2 = new JList();
		list_2.setBounds(16, 178, 194, 77);
		contentPane.add(list_2);
		
		JButton btnUnsubscribe = new JButton("Unsubscribe");
		btnUnsubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUnsubscribe.setBounds(288, 145, 117, 29);
		contentPane.add(btnUnsubscribe);
	}
	
	public static void main(String[] args)
	{
		Views view = new RegisteredView("Qasim","qazxsw");
		view.setVisible(true);
	}
}
