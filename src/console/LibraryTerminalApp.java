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

		while (choice != 6) {

			System.out.println();
			choice = Validator.getInt(scan,
					" 1 - Refresh Catalog of Books\n 2 - Search Books by Author\n 3 - Search Books by Title Keyword\n 4 - Return a Book\n 5 - Add New Book to Library\n 6 - Quit",
					1, 6);
			System.out.println();

			if (choice == 1) {
				clearScreen();
				display(libraryList);
				Book.writeToFile(libraryList);
			}
			if (choice == 2) {
				Book.authorSearch(libraryList, scan);
				clearScreen();
				display(libraryList);
				Book.writeToFile(libraryList);
			}
			if (choice == 3) {
				Book.keywordSearch(libraryList, scan);
				clearScreen();
				display(libraryList);
				Book.writeToFile(libraryList);
			}
			if (choice == 4) {
				Book.returnBook(libraryList, scan);
				clearScreen();
				display(libraryList);
				Book.writeToFile(libraryList);
			}
			if (choice == 5) {
				Book.addBook(libraryList, scan);
				clearScreen();
				display(libraryList);
				Book.writeToFile(libraryList);
			}
			
			
		}	
			clearScreen();
			System.out.println("Thank you for visiting to Grand Circus Library!\nGoodbye!");
			
			Book.writeToFile(libraryList);
		
	}

	private static void display(ArrayList<Book> libraryList) {
		for (Book book : libraryList) {
			System.out.println(book);
		}
	}

	public ArrayList<Book> makeList(String name) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		return null;
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println(" ");
		}	
	}
}