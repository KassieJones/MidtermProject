package console;

import java.util.ArrayList;
import java.util.Scanner;

import model.Book;
import model.CheckReturn;
import utility.Validator;

public class LibraryTerminalApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choice = 2;

		ArrayList<Book> libraryList = new ArrayList<Book>();
		libraryList = Book.readFromFile("Library.json");

		System.out.println("Welcome to the Grand Circus Library!");
		System.out.println();
		
		display(libraryList);
		System.out.println();
		

		while (choice != 5) {

			System.out.println();
			choice = Validator.getInt(scan,
					" 1 - Refresh Catalog of Books\n 2 - Search Books by Author\n 3 - Search Books by Title Keyword\n 4 - Return a Book\n 5 - Quit",
					1, 5);
			System.out.println();
			
			if (choice == 1) {
				display(libraryList);
			}
			if (choice == 2) {
				Book.authorSearch(libraryList, scan);	
			}
			if (choice == 3) {
				Book.keywordSearch(libraryList, scan);	
			}
			if (choice == 4) {

				//return a book?
				
			}
		}
		System.out.println();
		System.out.println("Thank you for visiting to Grand Circus Library!\nGoodbye!");	
	}


	private static void display(ArrayList<Book> libraryList) {
		for (Book book: libraryList) {
			System.out.println(book);
		}
	}
	
	public ArrayList<Book> makeList (String name) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		return null;
	}
	
}