package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Client;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

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
	private JList<String> myOrderlist;
	private JList<String> serachList; 
	private DefaultListModel<String> myOrderModel;
	private DefaultListModel<String> mySearchModel;
	
	
	/**
	 * Create the frame.
	 */
	public OrdinaryBuyerView()
	{
		
		setupBeginning();
		addLogin();
		addNormal();
		myOrderModel = new DefaultListModel<String>();
		mySearchModel = new DefaultListModel<String>();
		
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
		
		myOrderlist = new JList<String>();
		myOrderlist.setBounds(16, 33, 194, 68);
		myOrderlist.setFont(new Font("Courier New", Font.PLAIN, 8));
		myOrderlist.setVisibleRowCount(30);
		myOrderlist.setPrototypeCellValue("123456789123456789123456789123456789123456789");
		
		JScrollPane myScrollBar = new JScrollPane(myOrderlist);
		myScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(myOrderlist);
		
		textField_2 = new JTextField();
		textField_2.setBounds(314, 6, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		// Search Button
		searchButton = new JButton("Search");
		searchButton.setBounds(233, 6, 77, 29);
		contentPane.add(searchButton);
		
		serachList  = new JList<String>();
		serachList.setBounds(243, 44, 201, 57);
		serachList.setFont(new Font("Courier New", Font.PLAIN, 8));
		serachList.setPrototypeCellValue("123456789123456789123456789123456789123456789");
		
		JScrollPane searchScroll = new JScrollPane(serachList);
		searchScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		searchScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		searchScroll.setPreferredSize(new Dimension(20, 40));
		serachList.setVisibleRowCount(8);
		
		contentPane.add(serachList);
		contentPane.add(searchScroll);
		
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
	
	public JList<String> getOrderJList()
	{
		return myOrderlist;
	}
	
	public JList<String> getSearchList()
	{
		return serachList;
	}
	
	public DefaultListModel<String> getOrderModel()
	{
		return myOrderModel;
	}
	
	public DefaultListModel<String> getSearchModel()
	{
		return mySearchModel;
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
	

	public void removeSelected()
	{
		int index = myOrderlist.getSelectedIndex();
		if(index >= 0)
		{
			myOrderModel.removeElementAt(index);
			myOrderlist.setModel(myOrderModel);
		}
		
	}

	
}
