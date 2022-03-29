package edu.ntnu.idatt2001.edvarso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            URL url = getClass().getResource("/ApplicationView.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);

            stage.setTitle("Cardgame");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public void stop() {
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }


}

