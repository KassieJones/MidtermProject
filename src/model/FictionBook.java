package model;
import java.util.Date;

public class FictionBook extends Book {
	private int rating;

	public FictionBook() {

	}

	public FictionBook(String title, String author, boolean status, String dueDate, String genre, int rating) {
		super(title, author, status, dueDate, genre);
		this.rating = rating;
	}
	
	public FictionBook(String title, String author, boolean status, String dueDate, String genre) {
		super(title, author, status, dueDate, genre);
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
		return String.format("Title: %-10s Author: %-10s Genre: %-10s Rating: %-10s Status: %-10s Due Date: %-10s",
				super.getTitle(), super.getAuthor(), super.getGenre(), rating, super.isStatus(), super.getDueDate());
	}

}
