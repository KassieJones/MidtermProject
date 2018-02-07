import java.util.Date;

public class Book {
	private String title;
	private String author;
	private boolean status;
	private Date dueDate;
	private String genre;

	public Book() {

	}

	public Book(String title, String author, boolean status, Date dueDate, String genre) {
		this.title = title;
		this.author = author;
		this.status = status;
		this.dueDate = dueDate;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return String.format("Title: %-10s Author: %-10s Genre: %-10s Status: %-10s Due Date: %-10s", title, author,
				genre, status, dueDate);
	}
	
	public void returnBook(Book book) {
			book.setStatus(true);
				}

	public void checkOutBook(Book book) {
		book.setStatus(false);
	}
}
