package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;

public class SaveButton {
	ObservableList<Book> bookList; // List of books to be saved
	Alerts a = new Alerts();

	// Constructor to initialize the book list
	public SaveButton(ObservableList<Book> bookList) {
		this.bookList = bookList;
	}

	// Method to save book data to a file
	public void Display() {
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\FxBooks\\UpdatedBooks.txt");
		try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
			// for Loop through each book and write its details to the file
			for (Book book : bookList) {
				writer.println(buildBookData(book));
			}
			a.InfoAlert("Success", "Books data saved successfully!");
		} catch (IOException e) {
			a.ErrorAlert("Error", "Failed to save Books data.");
		}
	}

	// method to return book information as a string
	private String buildBookData(Book book) {
		return book.getBookId() + ", " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getCategory() + ", "
				+ book.getPublishedYear() + ", " + book.getIsbn();
	}
}
