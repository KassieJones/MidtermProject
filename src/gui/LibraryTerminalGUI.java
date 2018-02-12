package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Book;

public class LibraryTerminalGUI {

	private JFrame frame;
	int aListPos = 0;

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
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		// Make the all important arraylist
		ArrayList<Book> library = Book.readFromFile("Library.json");
		String[] bookList = new String[library.size()];
		for (int i = 0; i < library.size(); i++) {
			bookList[i] = library.get(i).getTitle();
		}

		// JSplitPane gives us a divided window. The left displays book titles.
		// Clicking one brings the book's information to the left pane.
		// Menu bar actions will permit checkout and other activities.

		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane);

		JList list = new JList(bookList);
		splitPane.setLeftComponent(list);

		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		panel.add(lblTitle, gbc_lblTitle);

		JLabel titleLabel = new JLabel("Title");
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridx = 3;
		gbc_titleLabel.gridy = 1;
		panel.add(titleLabel, gbc_titleLabel);

		JLabel lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 1;
		gbc_lblAuthor.gridy = 3;
		panel.add(lblAuthor, gbc_lblAuthor);

		JLabel authorLabel = new JLabel("Author");
		GridBagConstraints gbc_authorLabel = new GridBagConstraints();
		gbc_authorLabel.insets = new Insets(0, 0, 5, 0);
		gbc_authorLabel.gridx = 3;
		gbc_authorLabel.gridy = 3;
		panel.add(authorLabel, gbc_authorLabel);

		JLabel lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 1;
		gbc_lblStatus.gridy = 5;
		panel.add(lblStatus, gbc_lblStatus);

		JLabel statusLabel = new JLabel("Status");
		GridBagConstraints gbc_statusLabel = new GridBagConstraints();
		gbc_statusLabel.insets = new Insets(0, 0, 5, 0);
		gbc_statusLabel.gridx = 3;
		gbc_statusLabel.gridy = 5;
		panel.add(statusLabel, gbc_statusLabel);

		JLabel lblDueDate = new JLabel("Due Date");
		GridBagConstraints gbc_lblDueDate = new GridBagConstraints();
		gbc_lblDueDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDueDate.gridx = 1;
		gbc_lblDueDate.gridy = 7;
		panel.add(lblDueDate, gbc_lblDueDate);

		JLabel dueDateLabel = new JLabel("Due Date");
		GridBagConstraints gbc_dueDateLabel = new GridBagConstraints();
		gbc_dueDateLabel.insets = new Insets(0, 0, 5, 0);
		gbc_dueDateLabel.gridx = 3;
		gbc_dueDateLabel.gridy = 7;
		panel.add(dueDateLabel, gbc_dueDateLabel);

		JLabel lblGenre = new JLabel("Genre");
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenre.gridx = 1;
		gbc_lblGenre.gridy = 9;
		panel.add(lblGenre, gbc_lblGenre);

		JLabel genreLabel = new JLabel("Genre");
		GridBagConstraints gbc_genreLabel = new GridBagConstraints();
		gbc_genreLabel.gridx = 3;
		gbc_genreLabel.gridy = 9;
		panel.add(genreLabel, gbc_genreLabel);

		// Listener changes the display on the left when a book is selected on the
		// right.

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					// titleLabel.setText(list.getSelectedValue().toString());
					// System.out.println(list.getSelectedValue().toString());
					//
					//int aListPos = 0;
					for (int i = 0; i < library.size(); i++)
						if (library.get(i).getTitle().contains((String) list.getSelectedValue())) {
							aListPos = i;
							i = (library.size());

						}
					titleLabel.setText(library.get(aListPos).getTitle());
					authorLabel.setText(library.get(aListPos).getAuthor());
					statusLabel.setText(library.get(aListPos).getStatus());
					dueDateLabel.setText(library.get(aListPos).getDueDate());
					genreLabel.setText(library.get(aListPos).getGenre());

				}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem mntmCheckOut = new JMenuItem("Check Out");
		menuBar.add(mntmCheckOut);
		mntmCheckOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				library.get(aListPos).setStatus("UNAVAILABLE");
				library.get(aListPos).setDueDate(LocalDate.now().plusWeeks(2).toString());
				statusLabel.setText(library.get(aListPos).getStatus());
				dueDateLabel.setText(library.get(aListPos).getDueDate());
			}

		});

		JMenuItem mntmReturn = new JMenuItem("Return");
		menuBar.add(mntmReturn);
		mntmReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				library.get(aListPos).setStatus("AVAILABLE");
				library.get(aListPos).setDueDate(" ");
				statusLabel.setText(library.get(aListPos).getStatus());
				dueDateLabel.setText(library.get(aListPos).getDueDate());
			}

		});
	
		// Exit Listener
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
			        public void windowClosing(WindowEvent winEvt) {
			            Book.writeToFile(library);
			            System.exit(0);
			        }
			    });
	}

	
}
