import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


	public static void readFromFile() {
		Path writeFile = Paths.get("terminal.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There were no books!");
		}

	}
	
	
	
	public static void writeToFile(String name) {
		Path writeFile = Paths.get("terminal.txt");
		File file = writeFile.toFile();

		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			out.println( name);
			out.close();
		} catch (FileNotFoundException e) {
			createFile("terminal.txt");
			try {
				PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
				out.println( name);
				out.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void createFile(String fileString) {
		Path filePath = Paths.get(fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was cerated successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with file creation ");
				e.printStackTrace();
			}
		}
	}
	
	
	
}