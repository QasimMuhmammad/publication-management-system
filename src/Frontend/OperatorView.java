package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import backend.database.shared.Document;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class OperatorView extends Views
{

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private JButton removeButton;
	private JButton updateButton;
	private JButton LogoutButton;
	private JButton addButton;
	private JList<String> viewingList;
	private DefaultListModel<String> allDocuments;
	private JScrollPane documentScroll;
	private Vector<Document> myDocuments;
	/**
	 * Create the frame.
	 */
	public OperatorView()
	{
		allDocuments = new DefaultListModel<String>();
		myDocuments = new Vector<Document>();
		
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
		
		viewingList = new JList();
		viewingList.setFont(new Font("Courier New", Font.PLAIN, 8));
		viewingList.setVisibleRowCount(30);
		
		documentScroll = new JScrollPane();
		documentScroll.setBounds(24, 59, 406, 134);
		documentScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		documentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		documentScroll.setViewportView(viewingList);
		
		contentPane.add(documentScroll);
		
		//viewingList.setBounds(24, 59, 406, 134);
		//getContentPane().add(viewingList);
		
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
	
	public DefaultListModel<String> getModel()
	{
		return allDocuments;
	}
	
	public JList<String> getList()
	{
		return viewingList;
	}
	
	public void setModel(DefaultListModel<String> model)
	{
		allDocuments = model;
	}

	public void setDocuments(Vector<Document> docs)
	{
		myDocuments = docs;
	}
	
	public Vector<Document> getDocInfo()
	{
		return myDocuments;
	}


	public String chooseDocumentAddType()
	{
		JPanel myPanel = new JPanel();
		JComboBox<String> options = new JComboBox<String>();
		
		options.addItem("Journal");
		options.addItem("Magazine");
		options.addItem("Book");
		myPanel.add(options);
		
		int option = JOptionPane.showConfirmDialog(null	, myPanel, "Choose Document to Add", JOptionPane.OK_OPTION);
		if(option == JOptionPane.OK_OPTION && options.getSelectedIndex() >=0)
		{
			return String.valueOf(options.getSelectedItem());
		}
		
		return null;
	}
	
}
