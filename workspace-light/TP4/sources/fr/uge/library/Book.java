package fr.uge.library;

import java.util.Objects;

public record Book(String title, String author) {

	public Book {
		Objects.requireNonNull(title);
		Objects.requireNonNull(author);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return title + " by " + author;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
