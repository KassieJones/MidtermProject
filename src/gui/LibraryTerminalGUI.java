package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.Book;
import javax.swing.JLabel;

public class LibraryTerminalGUI {

	private JFrame frame;
	private JTable tableView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryTerminalGUI window = new LibraryTerminalGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryTerminalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menu, submenu;
		JMenuItem menuItem;

		// Build Menus
		JMenu menuExit = new JMenu("Exit");
		JMenu menuCheckOut = new JMenu("CheckOut");
		JMenu menuReturn = new JMenu("Return");
		JMenuItem menuSearchKW = new JMenuItem("By Title Keyword");
		JMenuItem menuSearchAuthor = new JMenuItem("By Author");
		JMenu menuSearch = new JMenu("Search");
		JMenu menuAdd = new JMenu("Add Book(s)");
		JMenuItem menuAddOne = new JMenuItem("Add One");
		JMenuItem menuAddFile = new JMenuItem("Add from File");

		menuBar.add(menuExit);
		menuBar.add(menuCheckOut);
		menuBar.add(menuReturn);
		menuBar.add(menuSearch);
		menuSearch.add(menuSearchAuthor);
		menuSearch.add(menuSearchKW);
		menuBar.add(menuAdd);
		menuAdd.add(menuAddOne);
		menuAdd.add(menuAddFile);
		
		tableView = new JTable();
		tableView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(tableView, BorderLayout.SOUTH);

	
		ArrayList<Book> library = Book.readFromFile("Library.json");
		//frame.getContentPane().add(displayTable, BorderLayout.CENTER);

		/*
		  DefaultTableModel model = new DefaultTableModel();
		 
	

		//String[] columnTitles = { "Title", "Author", "Status", "Due Date", "Genre" };
		//model.setColumnIdentifiers(columnTitles);
		model.addColumn("Title");
		model.addColumn("Author");
		model.addColumn("Status");
		model.addColumn("Due Date");
		model.addColumn("Genre");
		for (Book book : library) {
			String[] string = { book.getTitle(), book.getAuthor(), book.getStatus(), book.getDueDate(),
					book.getGenre() };
			model.addRow(string);
		}
		//lblNewLabel.setText(model.toString());
		//displayTable.setModel(model);
		//displayTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//frame.getContentPane().add(displayTable, BorderLayout.CENTER);
*/
	
		String[] columns = new String[] {
	            "Title", "Author", "Status", "Due Date", "Genre"
	        };
	         
	        //actual data for the table in a 2d array
	        String[][] data = new String[library.size()][5];
	        for (int i = 0; i < library.size(); i++) {
	        	data[i][0] = library.get(i).getTitle();
	        	data[i][1] = library.get(i).getAuthor();
	        	data[i][2] = library.get(i).getStatus();
	        	data[i][3] = library.get(i).getDueDate();
	        	data[i][4] = library.get(i).getGenre();
	        }
	        	//create table with data
	        tableView = new JTable(data, columns);
	        frame.add(tableView);
	        
	         

	
	}

}
