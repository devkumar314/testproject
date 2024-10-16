package tests.StreamTest;

import java.util.ArrayList;


/*A stream in Java is a sequence of objects that supports various methods 
 * which can be pipelined to produce the desired result. 
 * 
 * Different Operations On Streams
 * 1. Intermediate Operations  - map(),  filter(), sorted()
 * 2. Terminate Operations - collect(), forEach(), reduce()
 * 
 * https://www.geeksforgeeks.org/stream-in-java/
 * 
 * 
 * 
 */

import org.testng.annotations.Test;

class Book {

	private String author;
	private String title;
	
	public Book(String author, String title) {
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

public class StreamTest {
	
	@Test
	public  void Test1() {
		ArrayList<Book> books = populateLibrary();
		
		books.stream().filter(book -> {
			return book.getAuthor().startsWith("J");
		}).filter(book -> {
			return book.getTitle().startsWith("E");
		}).forEach(System.out::println);
	}
	
	static ArrayList<Book> populateLibrary(){
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("Alice", "Purple"));
		books.add(new Book("Alice", "Jazz"));
		books.add(new Book("Jane", "Emma"));
		books.add(new Book("Gazu", "Paradise"));
		books.add(new Book("Chinua", "Home"));
		return books;
	}
	
}
