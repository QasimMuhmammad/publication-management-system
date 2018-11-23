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
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(24, 205, 131, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBounds(313, 205, 131, 29);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setBounds(167, 205, 131, 29);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Welcome Operator");
		lblNewLabel.setBounds(157, 5, 131, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBounds(327, 6, 117, 29);
		getContentPane().add(btnNewButton_3);
		
		JList list = new JList();
		list.setBounds(24, 59, 406, 134);
		getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Document System Database");
		lblNewLabel_1.setBounds(127, 31, 176, 16);
		getContentPane().add(lblNewLabel_1);
	}

}
