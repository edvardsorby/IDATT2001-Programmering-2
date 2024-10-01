package edu.ntnu.idatt2001.edvarso.model.factory;

import javafx.scene.control.Alert;

/**
 * Factory class used to show dialogs on screen
 */
public class DialogFactory {

    public static void showDialog(String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Wargames");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
