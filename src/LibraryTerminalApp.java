
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTerminalApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choice = 2;

		ArrayList<Book> libraryList = new ArrayList<Book>();
		libraryList = Book.readFromFile("Library.json");

		System.out.println("Welcome to the Grand Circus Library Terminal!");
		

		while (choice != 6) {

			System.out.println();
			choice = Validator.getInt(scan,
					" 1 - See Catalog of Books\n 2 - Search Books by Author\n 3 - Search Books by Title Keyword\n 4 - Select a Book to Check-out\n 5 - Return a Book\n 6 - Quit",
					1, 6);
			
			if (choice == 1) {
				Book.readFromFile();
			}
			if (choice == 2) {
				System.out.println();
			//	String authorName = Validator.getString(scan, "Enter the author name: ");
				Book.authorSearch(libraryList, scan);
				
			}
			
			if (choice == 3) {
				System.out.println();
			//	String titleKeyword = Validator.getString(scan, "Enter the title keyword: ");
				Book.keywordSearch(libraryList, scan);
				
			}
			
			if (choice == 4) {
				System.out.println();
				String bookTitleCO = Validator.getString(scan, "Which book would you like to check out: ");
			}
			if (choice == 5) {
				System.out.println();
				String bookTitleRT = Validator.getString(scan, "Which book would you like to return: ");
				
				
				
			}
			if (choice == 6){
				System.out.println();
				System.out.println("Thank you for visiting to Grand Circus Library Terminal!\nGoodbye!");
			}

		}


		
	}
	
	public ArrayList<Book> makeList (String name) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		return null;
	}
	
	
	
/*	public static searchList {
		
		LinkedList<Book> books = new LinkedList<Book>();
	        books.add("To Kill a Mockingbird", "Harper Lee");
	        books.add("Pride & Prejudice", "Jane Austen");
	        books.add("Animal Farm", "George Orwell");
	        books.add("The Book Theif", "Markus Zusak");
	        books.add("Lord of the Flies", "William Golding");
	        books.add("Wuthering Heights", "Emily Bronte");
	        books.add("A Brief History of Time", "Stephen Hawking");
	        books.add("No Logo", "Naomi Klein");
	        books.add("Dispatches", "Michael Herr");
	        books.add("Hiroshima", "John Hersey");
	        books.add("The Columbia Encyclopedia", "Paul Legasse");
	        books.add("Roget's Thesaurus", "Peter Roget");
		
	}*/
}


