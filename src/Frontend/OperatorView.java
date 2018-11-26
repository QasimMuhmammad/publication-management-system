package Frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.database.shared.Book;
import backend.database.shared.Document;
import backend.database.shared.Journal;
import backend.database.shared.Magazine;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Objects;
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


	public Journal getJournal(boolean val)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(8, 8, 8, 8);
		
		JLabel label;
		
		label = new JLabel("Journal ID");
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    panel.add(label, constraints);
		
		JTextField id = new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 0;
	    panel.add(id, constraints);
		
	    
	    label = new JLabel("Journal Title");
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    panel.add(label, constraints);
		
	    JTextField title= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 1;
	    panel.add(title, constraints);
	    
		label = new JLabel("Journal Author");
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    panel.add(label, constraints);
		
	    JTextField author= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 2;
	    panel.add(author, constraints);
	    
		label = new JLabel("Journal Creation Date, YY-MM-DD");
	    constraints.gridx = 0;
	    constraints.gridy = 3;
	    panel.add(label, constraints);
		
	    JTextField creation= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 3;
	    panel.add(creation, constraints);
	    
	    
		label = new JLabel("Last Modified, YY-MM-DD");
	    constraints.gridx = 0;
	    constraints.gridy = 4;
	    panel.add(label, constraints);
		
	    JTextField lastModified= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 4;
	    panel.add(lastModified, constraints);
		
		label = new JLabel("File Extension");
	    constraints.gridx = 0;
	    constraints.gridy = 5;
	    panel.add(label, constraints);
		
	    JTextField fileExtension= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 5;
	    panel.add(fileExtension, constraints);
	    
		label = new JLabel("Price");
	    constraints.gridx = 0;
	    constraints.gridy = 6;
	    panel.add(label, constraints);
		
	    JTextField Price= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 6;
	    panel.add(Price, constraints);
		
	    if(val)
	    {
	    	Journal toShow = (Journal) myDocuments.get(viewingList.getSelectedIndex());
	    	id.setText(String.valueOf(toShow.getDocumentId()));
	    	id.setEditable(false);
	    	title.setText(toShow.getDocumentTitle());
	    	author.setText(toShow.getAuthor());
	    	creation.setText(toShow.getCreationDate().toString());
	    	lastModified.setText(toShow.getLastModifiedDate().toString());
	    	fileExtension.setText(toShow.getFileExtension());
	    	Price.setText(toShow.getPrice().toString());
	    }
	    
	    
	    
	    Object[] options = {"OK", "CANCEL"};
	    int result = JOptionPane.showOptionDialog(null, panel, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    
	    if(result == 0)
	    {
	    	int docID = Integer.valueOf(id.getText());
	    	String ti = title.getText();
	    	String au = author.getText();
	    	Date create = new Date(0, 1, 2);
	    	Date modify = new Date(0,1,2);
	    	String extension = fileExtension.getText();
	    	Double pDouble = Double.valueOf(Price.getText());
	    	
	    	Journal myJournal = new Journal(docID, ti, au, create, modify, extension, pDouble);
	    	return myJournal;
	    }
	    
		return null;
	}


	
	public Magazine getMagazine(boolean val)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(8, 8, 8, 8);
		
		JLabel label;
		
		label = new JLabel("Magazine ID");
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    panel.add(label, constraints);
		
		JTextField id = new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 0;
	    panel.add(id, constraints);
		
	    
	    label = new JLabel("Magazine Title");
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    panel.add(label, constraints);
		
	    JTextField title= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 1;
	    panel.add(title, constraints);
	    
		label = new JLabel("Magazine Author");
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    panel.add(label, constraints);
		
	    JTextField author= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 2;
	    panel.add(author, constraints);
	    
		label = new JLabel("Magazine Creation Date, YY-MM-DD");
	    constraints.gridx = 0;
	    constraints.gridy = 3;
	    panel.add(label, constraints);
		
	    JTextField creation= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 3;
	    panel.add(creation, constraints);
	    
	    
		label = new JLabel("Last Modified, YY-MM-DD");
	    constraints.gridx = 0;
	    constraints.gridy = 4;
	    panel.add(label, constraints);
		
	    JTextField lastModified= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 4;
	    panel.add(lastModified, constraints);
		
		label = new JLabel("File Extension");
	    constraints.gridx = 0;
	    constraints.gridy = 5;
	    panel.add(label, constraints);
		
	    JTextField fileExtension= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 5;
	    panel.add(fileExtension, constraints);
	    
		label = new JLabel("Price");
	    constraints.gridx = 0;
	    constraints.gridy = 6;
	    panel.add(label, constraints);
		
	    JTextField Price= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 6;
	    panel.add(Price, constraints);
	    
	    label = new JLabel("Issue ID");
	    constraints.gridx = 0;
	    constraints.gridy = 7;
	    panel.add(label, constraints);
		
	    JTextField issue= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 7;
	    panel.add(issue, constraints);
		
	    if(val)
	    {
	    	Magazine toShow = (Magazine) myDocuments.get(viewingList.getSelectedIndex());
	    	id.setText(String.valueOf(toShow.getDocumentId()));
	    	title.setText(toShow.getDocumentTitle());
	    	author.setText(toShow.getAuthor());
	    	creation.setText(toShow.getCreationDate().toString());
	    	lastModified.setText(toShow.getLastModifiedDate().toString());
	    	fileExtension.setText(toShow.getFileExtension());
	    	Price.setText(toShow.getPrice().toString());
	    	issue.setText(String.valueOf(toShow.getIssueId()));
	    }
	    
	    Object[] options = {"OK", "CANCEL"};
	    int result = JOptionPane.showOptionDialog(null, panel, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    
	    if(result == 0)
	    {
	    	int docID = Integer.valueOf(id.getText());
	    	id.setEditable(false);
	    	String ti = title.getText();
	    	String au = author.getText();
	    	Date create = new Date(0, 1, 2);
	    	Date modify = new Date(0,1,2);
	    	String extension = fileExtension.getText();
	    	Double pDouble = Double.valueOf(Price.getText());
	    	int issueID = Integer.valueOf(issue.getText());
	    	
	    	
	    	Magazine myMag = new Magazine(docID, ti, au, create, modify, extension, issueID,pDouble);
	    	System.out.println("Returning price of magazine " + myMag.getPrice());
	    	return myMag;
	    }
	    
		return null;
	}



	public Book getBook(boolean val)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(8, 8, 8, 8);
		
		JLabel label;
		
		label = new JLabel("Book ID");
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    panel.add(label, constraints);
		
		JTextField id = new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 0;
	    panel.add(id, constraints);
		
	    
	    label = new JLabel("Book Title");
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    panel.add(label, constraints);
		
	    JTextField title= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 1;
	    panel.add(title, constraints);
	    
		label = new JLabel("Book Author");
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    panel.add(label, constraints);
		
	    JTextField author= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 2;
	    panel.add(author, constraints);
	    
		label = new JLabel("Book Creation Date, YY-MM-DD");
	    constraints.gridx = 0;
	    constraints.gridy = 3;
	    panel.add(label, constraints);
		
	    JTextField creation= new JTextField(15);
	    constraints.gridx = 1;
	    constraints.gridy = 3;
	    panel.add(creation, constraints);
	    
	    
		label = new JLabel("Last Modified, YY-MM-DD");
	    constraints.gridx = 0;
	    constraints.gridy = 4;
	    panel.add(label, constraints);
		
	    JTextField lastModified= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 4;
	    panel.add(lastModified, constraints);
		
		label = new JLabel("File Extension");
	    constraints.gridx = 0;
	    constraints.gridy = 5;
	    panel.add(label, constraints);
		
	    JTextField fileExtension= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 5;
	    panel.add(fileExtension, constraints);
	    
		label = new JLabel("Price");
	    constraints.gridx = 0;
	    constraints.gridy = 6;
	    panel.add(label, constraints);
		
	    JTextField Price= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 6;
	    panel.add(Price, constraints);
	    
	    label = new JLabel("Genre");
	    constraints.gridx = 0;
	    constraints.gridy = 7;
	    panel.add(label, constraints);
		
	    JTextField Genre= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 7;
	    panel.add(Genre, constraints);
	    
	    label = new JLabel("ISBN");
	    constraints.gridx = 0;
	    constraints.gridy = 8;
	    panel.add(label, constraints);
		
	    JTextField bisbn= new JTextField(15);
		constraints.gridx = 1;
	    constraints.gridy = 8;
	    panel.add(bisbn, constraints);
	    
	    label = new JLabel("Fiction/Non-Fiction");
	    constraints.gridx = 0;
	    constraints.gridy = 9;
	    panel.add(label, constraints);
		
	    Object[] xObjects = {"Fiction","nonFiction"};
	    JComboBox Fiction= new JComboBox<>(xObjects) ;
		constraints.gridx = 1;
	    constraints.gridy = 9;
	    panel.add(Fiction, constraints);
	    
	    label = new JLabel("Hard/Soft Cover");
	    constraints.gridx = 0;
	    constraints.gridy = 10;
	    panel.add(label, constraints);
		
	    Object[] xObjects1 = {"Hard Cover","Soft Cover"};
	    JComboBox cover= new JComboBox<>(xObjects1) ;
		constraints.gridx = 1;
	    constraints.gridy = 10;
	    panel.add(cover, constraints);


	    if(val)
	    {
	    	Book toShow = (Book) myDocuments.get(viewingList.getSelectedIndex());
	    	id.setText(String.valueOf(toShow.getDocumentId()));
	    	id.setEditable(false);
	    	title.setText(toShow.getDocumentTitle());
	    	author.setText(toShow.getAuthor());
	    	creation.setText(toShow.getCreationDate().toString());
	    	lastModified.setText(toShow.getLastModifiedDate().toString());
	    	fileExtension.setText(toShow.getFileExtension());
	    	Price.setText(toShow.getPrice().toString());
	    boolean f =	toShow.isFiction();
	    boolean c = toShow.isHardCover();
	    int fVal = 0;
	    int cVal = 0;
	    
	    if(!f)
	    {
	    		fVal = 1;
	    }
	    if(!c)
	    {
	    		cVal =1;
	    }
	    
	    	Fiction.setSelectedIndex(fVal);
	    	cover.setSelectedIndex(cVal);
	    	Genre.setText(toShow.getGenre());
	    	bisbn.setText(String.valueOf(toShow.getIsbn()));
	    }
		
	    Object[] options = {"OK", "CANCEL"};
	    int result = JOptionPane.showOptionDialog(null, panel, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    
	    if(result == 0)
	    {
	    	int selectedIndex = Fiction.getSelectedIndex();
	    	int selectedIndex1 = cover.getSelectedIndex();
	    	boolean fic = true;
	    	boolean cov = true;
	    	
	    	if(selectedIndex == 1)
	    	{
		   fic = false;
	    	}
	    	
	    	if(selectedIndex1 ==1)
	    	{
	    		cov = false;
	    	}
	    	
	    	int docID = Integer.valueOf(id.getText());
	    	String ti = title.getText();
	    	String au = author.getText();
	    	Date create = new Date(0, 1, 2);
	    	Date modify = new Date(0,1,2);
	    	String extension = fileExtension.getText();
	    	Double pDouble = Double.valueOf(Price.getText());
	    	String gen = Genre.getText();
	    	int isbn = Integer.valueOf(bisbn.getText());
	    	
	    	Book myBook = new Book(docID, ti, au, create, modify, extension,fic,fic,gen,isbn, pDouble);
	    	return myBook;
	    }
	    
		return null;
	}

}
