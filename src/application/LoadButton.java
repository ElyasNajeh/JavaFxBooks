package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LoadButton {
	Alerts a = new Alerts();

	// Method to display the file chooser and load books from the selected file
	public void Display() {
		FileChooser fc = new FileChooser();
		fc.setTitle("Select Books File");
		fc.setInitialDirectory(new File("C:\\Users\\HP\\eclipse-workspace\\FxBooks"));
		Stage stage = new Stage();
		File f = fc.showOpenDialog(stage);
		// Check if no file was selected
		if (f == null) {
			a.ErrorAlert("Error", "No file selected. Please select a file.");
			return;
		}

		try (Scanner scanner = new Scanner(f)) {

			// Clear the existing book list before loading new data
			BookData.bookList.clear();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.isEmpty()) {
					continue;
				}

				String[] data = line.split(",");

				try {
					// Extract book details from the file
					String bookId = data[0].trim();
					String title = data[1].trim();
					String author = data[2].trim();
					String category = data[3].trim();
					int publishedYear = Integer.parseInt(data[4].trim());
					String isbn = data[5].trim();

					// Create a new book object and add it to the list
					Book book = new Book(bookId, title, author, category, publishedYear, isbn);
					BookData.bookList.add(book);

				} catch (Exception e) {
					a.ErrorAlert("Error", "Cannot read this line:" + line);
				}
			}

			a.InfoAlert("Success", "File read Successfully!");
		} catch (IOException e) {
			a.ErrorAlert("Error", "Error while reading the file.");
		}
	}
}
