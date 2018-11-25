package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

public class OperatorView extends Views
{

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JButton removeButton;
	JButton updateButton;
	JButton LogoutButton;
	JButton addButton;

	/**
	 * Create the frame.
	 */
	public OperatorView()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.setBounds(24, 205, 131, 29);
		getContentPane().add(addButton);
		
		removeButton = new JButton("Remove");
		removeButton.setBounds(313, 205, 131, 29);
		getContentPane().add(removeButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(167, 205, 131, 29);
		getContentPane().add(updateButton);
		
		JLabel lblNewLabel = new JLabel("Welcome Operator");
		lblNewLabel.setBounds(157, 5, 131, 16);
		getContentPane().add(lblNewLabel);
		
		LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(327, 6, 117, 29);
		getContentPane().add(LogoutButton);
		
		JList viewingList = new JList();
		viewingList.setBounds(24, 59, 406, 134);
		getContentPane().add(viewingList);
		
		JLabel lblNewLabel_1 = new JLabel("Document System Database");
		lblNewLabel_1.setBounds(127, 31, 176, 16);
		getContentPane().add(lblNewLabel_1);
	}

	
	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public JButton getLogoutButton() {
		return LogoutButton;
	}

	public JButton getAddButton() {
		return addButton;
	}
	
}
