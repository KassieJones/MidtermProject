import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Book {
/*	private String title;
	private String author;
	private boolean status;
	private Date dueDate;
	private String genre;
	*/
	@SerializedName("rating")
	@Expose
	public Integer rating;
	@SerializedName("title")
	@Expose
	public String title;
	@SerializedName("author")
	@Expose
	public String author;
	@SerializedName("status")
	@Expose
	public Boolean status;
	@SerializedName("dueDate")
	@Expose
	public Date dueDate;
	@SerializedName("genre")
	@Expose
	public String genre;
	@SerializedName("handsOff")
	@Expose
	public Boolean handsOff;

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
	
	public static ArrayList<Book> readFromFile(String filename) {
		
		System.out.println("Reading File...");
		ArrayList<Book> library = new ArrayList<Book>();
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
			JsonElement jsonElement = jsonParser.parse(br);
			Type type = new TypeToken<List<Book>>() {}.getType();
			
			library = gson.fromJson(jsonElement, type);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return library;

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
	
public static void writeToFile(ArrayList<Book> list) {
		
		Writer writer;
		try {
			writer = new FileWriter("Library.json");
			Gson gson = new GsonBuilder().create();
			writer.write(gson.toJson(list));
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
	
	
	
	public void checkOutBook(Book book) {
		book.setStatus(false);
	}
	
	// Methods for Importing JSON file
	
	public Book withRating(Integer rating) {
		this.rating = rating;
		return this;
		}

		public Book withTitle(String title) {
		this.title = title;
		return this;
		}

		public Book withAuthor(String author) {
		this.author = author;
		return this;
		}

		public Book withStatus(Boolean status) {
		this.status = status;
		return this;
		}

		public Book withDueDate(Date dueDate) {
		this.dueDate = dueDate;
		return this;
		}

		public Book withGenre(String genre) {
		this.genre = genre;
		return this;
		}

		public Book withHandsOff(Boolean handsOff) {
		this.handsOff = handsOff;
		return this;
		}
		
		// End of JSON methods
}

