package org.UI;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class Alerts {


	public static void display(String type, String title, String msg) {
Alert alert;
		
		if (type.equals("error"))
			alert = new Alert(AlertType.ERROR);
		else
			alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle(title);
		alert.setContentText(msg);
		
		alert.showAndWait();
		
	}
}
