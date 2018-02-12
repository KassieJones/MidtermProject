package model;
import java.time.LocalDate;
import java.util.Scanner;

public class CheckReturn {

	public static void checkoutBook(Book book, Scanner input) {
		System.out.print("Would you like to check this book out? (y / n)");
		String checkout = input.nextLine();
		System.out.println();

		if ((checkout.equalsIgnoreCase("y") && (book.getStatus().equals("UNAVAILABLE")))) {			
			System.out.println("I'm sorry, that book is currently checked out.\nPlease check back after " + book.getDueDate() + ".\nYou will now be taken back to the main menu.");
		}

		else if ((checkout.equalsIgnoreCase("y") && (book.getStatus().equals("AVAILABLE")))) {
			book.setStatus("UNAVAILABLE");
			LocalDate dueDate = LocalDate.now().plusWeeks(2);
			book.setDueDate(dueDate.toString());
			System.out.println("Thank you for checking out " + book.getTitle() + ".\nPlease return the book by " + book.getDueDate() + ".\nYou will now be taken back to the main menu.");		
		}
		else {
			System.out.println("You will now be taken back to the main menu.");
		}
		
	}

	public static void returnBook(Book book, Scanner input) {
		System.out.println();
		System.out.print("Would you like to return this book to the library? (y / n)");
		String checkout = input.nextLine();
		System.out.println();
		
		if ((checkout.equalsIgnoreCase("y") && (book.getStatus().equals("AVAILABLE")))) {
			System.out.println("This book has already been returned to the library.\nYou will now be taken back to the main menu.");
		}
		else if ((checkout.equalsIgnoreCase("y") && (book.getStatus().equals("UNAVAILABLE")))) {
			book.setStatus("AVAILABLE");
			book.setDueDate(" ");
			System.out.println("Thank you for returning " + book.getTitle() + "\nYou will now be taken back to the main menu.");
		}
		else {
			System.out.println("You will now be taken back to the main menu.");
		}
	}
}