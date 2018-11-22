package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;

public class OrdinaryBuyerView extends Views
{
	JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;



	/**
	 * Create the frame.
	 */
	public OrdinaryBuyerView()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(267, 232, 89, 29);
		contentPane.add(btnNewButton);
		
		// Register Button
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(355, 232, 89, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Shopping Cart");
		lblNewLabel_2.setBounds(63, 11, 111, 16);
		contentPane.add(lblNewLabel_2);
		
		// Remove
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(6, 115, 100, 29);
		contentPane.add(btnNewButton_2);
		
		// Make Order
		JButton btnNewButton_3 = new JButton("Make Order");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(118, 115, 100, 29);
		contentPane.add(btnNewButton_3);
		
		JList list = new JList();
		list.setBounds(16, 33, 194, 68);
		contentPane.add(list);
		
		textField_2 = new JTextField();
		textField_2.setBounds(314, 6, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		// Search Button
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(233, 6, 77, 29);
		contentPane.add(btnNewButton_4);
		
		JList list_1 = new JList();
		list_1.setBounds(243, 44, 201, 57);
		contentPane.add(list_1);
		
		// Add to Order
		JButton btnNewButton_5 = new JButton("Add to Order");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(288, 113, 117, 29);
		contentPane.add(btnNewButton_5);
	}
	
	
}
