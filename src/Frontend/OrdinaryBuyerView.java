package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

public class OrdinaryBuyerView extends Views
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton loginButton;
	private JButton RegisterButton;
	private JButton removeButton;
	private JButton makeOrderButton;
	private JButton searchButton;
	private JButton addToOrderButton;
	
	/**
	 * Create the frame.
	 */
	public OrdinaryBuyerView()
	{
		
		setupBeginning();
		addLogin();
		addNormal();
		
	}
	
	void setupBeginning()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
	
	void addLogin(){
		
		
		textField = new JTextField();
		textField.setBounds(314, 163, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 194, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(250, 168, 89, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(249, 199, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		
		
		// Login
		loginButton = new JButton("Login");
		loginButton.setBounds(267, 232, 89, 29);
		contentPane.add(loginButton);
		
		// Register Button
		RegisterButton = new JButton("Register");
		RegisterButton.setBounds(355, 232, 89, 29);
		contentPane.add(RegisterButton);
	}
	
	void addNormal() {
		JLabel lblNewLabel_2 = new JLabel("Shopping Cart");
		lblNewLabel_2.setBounds(63, 11, 111, 16);
		contentPane.add(lblNewLabel_2);
		
		// Remove
		removeButton = new JButton("Remove");
		removeButton.setBounds(6, 115, 100, 29);
		contentPane.add(removeButton);
		
		// Make Order
		makeOrderButton = new JButton("Make Order");
		makeOrderButton.setBounds(118, 115, 100, 29);
		contentPane.add(makeOrderButton);
		
		JList list = new JList();
		list.setBounds(16, 33, 194, 68);
		contentPane.add(list);
		
		textField_2 = new JTextField();
		textField_2.setBounds(314, 6, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		// Search Button
		searchButton = new JButton("Search");
		searchButton.setBounds(233, 6, 77, 29);
		contentPane.add(searchButton);
		
		JList list_1 = new JList();
		list_1.setBounds(243, 44, 201, 57);
		contentPane.add(list_1);
		
		// Add to Order
		addToOrderButton = new JButton("Add to Order");
		addToOrderButton.setBounds(288, 113, 117, 29);
		contentPane.add(addToOrderButton);
		
	}
	
	public JButton getLoginButton()
	{
		return loginButton;
	}
	
	public JButton getRegisterButton()
	{
		return RegisterButton;
	}
	
	public JButton getRemoveButton()
	{
		return removeButton;
	}
	
	public JButton getMakeOrderButton()
	{
		return makeOrderButton;
	}
	
	public JButton getSearchButton()
	{
		return searchButton;
	}
	
	public JButton getAddToOrderButton()
	{
		return addToOrderButton;
	}
	
	public JTextField geTextField()
	{
		return textField;
	}
	
	public JTextField geTextField1()
	{
		return textField_1;
	}
	
	public JTextField geTextField2()
	{
		return textField_2;
	}
	
	public void showLoginError()
	{
		JOptionPane.showMessageDialog(contentPane, "Incorrect username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void registrationMessage(boolean result)
	{
		if(result)
		{
			JOptionPane.showMessageDialog(contentPane, "You have suceeded in registration!", "Registration Successful", JOptionPane.PLAIN_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Username already in use!", "Registration Failed", JOptionPane.ERROR_MESSAGE);

		}
		
	}
	
	
}
