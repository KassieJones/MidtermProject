import java.util.Date;

public class NonFictionBook extends Book {
	private boolean handsOff;
	
	public NonFictionBook() {
		
	}
	
	public NonFictionBook(String title, String author, boolean status, Date dueDate, String genre, boolean handsOff) {
		super(title, author, status, dueDate, genre);
		this.handsOff = handsOff;
	}

	public boolean isHandsOff() {
		return handsOff;
	}

	public void setHandsOff(boolean handsOff) {
		this.handsOff = handsOff;
	}
	public String toString() {
		return String.format("Title: %-10s Author: %-10s Genre: %-10s Status: %-10s Due Date: %-10s Restricted Access: %-10s",
				super.getTitle(), super.getAuthor(), super.getGenre(), super.isStatus(), super.getDueDate(), handsOff);
	}

}
