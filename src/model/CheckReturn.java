package model;
import java.time.LocalDate;
import java.util.Scanner;

public class CheckReturn {

	public static void checkoutBook(Book book, Scanner input) {
		System.out.print("Would you like to check this book out? (y / n)");
		String checkout = input.nextLine();
		System.out.println();

		if (checkout.equalsIgnoreCase("y")) {
			book.setStatus("UNAVAILABLE");
			
			LocalDate dueDate = LocalDate.now().plusWeeks(2);

			book.setDueDate(dueDate.toString());
			System.out.println("Please return the book by " + book.getDueDate() + ". ");
		}
		
	}

	public static void returnBook(Book book, Scanner input) {
		System.out.print("Would you like to return this book out? (y / n)");
		String checkout = input.nextLine();
		System.out.println();

		if (checkout.equalsIgnoreCase("y")) {
			book.setStatus("AVAILABLE");
		}
	}
}