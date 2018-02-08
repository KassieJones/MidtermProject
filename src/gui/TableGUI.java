package gui;
//package net.codejava.swing;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableGUI extends JFrame
{
    
	
	/*
	 * public void TableBuild()
	 
    {
        //headers for the table
        String[] columns = new String[] {
            "Title", "Author", "Status", "Due Date", "Genre"
        };
        
        Book[] books = new Book[]()
        //actual data for the table in a 2d array
        //Object[] data = new Book[] {
        //  {1, "John", 40.0, false },
        //    {2, "Rambo", 70.0, false },
        //    {3, "Zorro", 60.0, true },
        //};
        
        final Class[] columnClass = new Class[] {
            Integer.class, String.class, Double.class, Boolean.class
        };
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return columnClass[columnIndex];
            }
        };
        
        JTable table = new JTable(model);
        
        //add the table to the frame
        this.add(new JScrollPane(table));
        
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample();
            }
        });
    }  
    */
}