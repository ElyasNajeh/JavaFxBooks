package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// ObservableList to store Book objects
// to refresh table view Directly 

public class BookData {
	public static ObservableList<Book> bookList = FXCollections.observableArrayList();
}
