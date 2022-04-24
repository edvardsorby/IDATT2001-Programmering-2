package edu.ntnu.idatt2001.edvarso;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            URL url = getClass().getResource("/armySelection.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            stage.setTitle("Wargames");
            //stage.getIcons().add(new Image(new FileInputStream("src/main/resources/images/icon.png")));
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
