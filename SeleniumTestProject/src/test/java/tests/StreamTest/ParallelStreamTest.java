package tests.StreamTest;

import java.util.ArrayList;

import org.testng.annotations.Test;

class Books {

	private String author;
	private String title;
	
	public Books(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public String toString() {
		return ("Author: "+ author + " Titale: "+ title);
	}
}

public class ParallelStreamTest {
	
	@Test
	public  void Test1() {
		ArrayList<Books> Bookss = populateLibrary();
		
		Bookss.parallelStream().filter(Books -> {
			return Books.getAuthor().startsWith("J");
		}).filter(Books -> {
			return Books.getTitle().startsWith("E");
		}).forEach(System.out::println);
	}
	
	static ArrayList<Books> populateLibrary(){
		ArrayList<Books> books = new ArrayList<Books>();
		books.add(new Books("Alice", "Purple"));
		books.add(new Books("Alice", "Jazz"));
		books.add(new Books("Jane", "Emma"));
		books.add(new Books("Gazu", "Paradise"));
		books.add(new Books("Chinua", "Home"));
		return books;
	}
	
}
