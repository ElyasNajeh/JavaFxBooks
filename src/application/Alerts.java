package application;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

//To make the Alert making process easier

public class Alerts {
// constructor to give the alert title and content text
	public boolean ConfiramtionAlert(String title, String messege) {
		Alert a1 = new Alert(AlertType.CONFIRMATION);
		a1.setTitle(title);
		a1.setContentText(messege);
		Optional<ButtonType> res = a1.showAndWait();
		return res.isPresent() && res.get() == ButtonType.OK;
	}

	public void ErrorAlert(String title, String messege) {
		Alert a2 = new Alert(AlertType.ERROR);
		a2.setTitle(title);
		a2.setContentText(messege);
		a2.showAndWait();
	}

	public void InfoAlert(String title, String messege) {
		Alert a3 = new Alert(AlertType.INFORMATION);
		a3.setTitle(title);
		a3.setContentText(messege);
		a3.showAndWait();
	}
}
