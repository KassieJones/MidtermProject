import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class LibraryTerminalGUI {

	private JFrame frame;
	private JTable table;

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
		
		
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		
		
		
	}

}
