import java.util.LinkedList;
import java.util.Scanner;

public class LibraryTerminalApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choice = 2;

		System.out.println("Welcome to the Grand Circus Library Terminal!");
		
		LinkedList<String> books = new LinkedList<String>();
		books.add("To Kill a Mockingbird\t\tHarper Lee");
		books.add("Pride & Prejuidice\t\tJane Austen");
		books.add("Animal Farm\t\t\tGeorge Orwell");
		books.add("The Book Theif\t\t\tMarkus Zusak");
		books.add("Lord of the Flies\t\tWilliam Golding");
		books.add("Wuthering Heights\t\tEmily Bronte");
		books.add("A Brief History of Time\t\tStephen Hawking");
		books.add("No Logo\t\t\t\tNaomi Klein");
		books.add("Dispatches\t\t\tMichael Herr");
		books.add("Hiroshima\t\t\tJohn Hersey");
		books.add("The Columbia Encyclopedia\tPaul Legasse");
		books.add("Roget's Thesaurus\t\tPeter Roget");
					
			
		while (choice != 6) {

			System.out.println();
			choice = Validator.getInt(scan,
					" 1 - See Catalog of Books\n 2 - Search Books by Author\n 3 - Search Books by Title Keyword\n 4 - Select a Book to Check-out\n 5 - Return a Book\n 6 - Quit",
					1, 6);
			if (choice == 1) {
				for (int i = 0; i < books.size(); i++) {
					System.out.println(books.get(i) + "\t\t" + BookStatus.AVAILABLE);
				}
		//		CountriesTextFile.readFromFile();
			} else if (choice == 2) {
				System.out.println();
				String authorName = Validator.getString(scan, "Enter the author name: ");
			} else if (choice == 3) {
				System.out.println();
				String titleKeyword = Validator.getString(scan, "Enter the title keyword: ");
			} else if (choice == 4) {
				System.out.println();
				for (int i = 0; i < books.size(); i++) {
					System.out.println(i + "\t" + books.get(i) + "\t\t" + BookStatus.AVAILABLE);
				}
				System.out.println();
				String bookTitleCO = Validator.getString(scan, "Which book would you like to check out: ");
			} else if (choice == 5) {
				System.out.println();
				String bookTitleRT = Validator.getString(scan, "Which book would you like to return: ");
			} else if (choice == 6){
				System.out.println();
				System.out.println("Thank you for visiting to Grand Circus Library Terminal!\nGoodbye!");
				
			
			}

		}

	}

}
