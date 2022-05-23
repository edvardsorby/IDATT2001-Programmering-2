package edu.ntnu.idatt2001.edvarso;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;

public class Application extends javafx.application.Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Application.stage = stage;
            URL url = getClass().getResource("/edu/ntnu/idatt2001/edvarso/view/armySelection.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            stage.setTitle("Wargames");
            stage.getIcons().add(new Image(new FileInputStream("src/main/resources/edu/ntnu/idatt2001/edvarso/styles/icon.png")));
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
