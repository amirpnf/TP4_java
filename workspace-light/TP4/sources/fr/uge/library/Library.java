package fr.uge.library;

import java.util.ArrayList;

import java.util.Objects;

public class Library {
	private final ArrayList<Book> books;
	
	public Library () {
		books = new ArrayList<Book>();
	}
	
	public void add(Book b) {
		Objects.requireNonNull(b);
		this.books.add(b);
	}
	
	public Book findByTitle(String title) {
		 for(var book : books) {
			 if(book.title().equals(title)) {
				 return book;
			 }	 
		 }
		 return null;
	}
	
	@Override
	public String toString() {
		var res = new StringBuilder();
		var separator = "";
		for(var book : books) {
			res.append(separator).append(book);
			separator = ", ";
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		var library = new Library();
		Book book1 = new Book("Da Vinci Code", "Dan Brown");
		Book book2 = new Book("Harry Potter and the Order of the Phoenix", "J.K Rowling");
		Book book3 = new Book("Grapes of Wrath", "John Steinbeck");
		library.add(book1);
		library.add(book2);
		library.add(book3);
		// System.out.println(library.findByTitle("Da Vinci Code"));
		System.out.println(library);
	}
}
