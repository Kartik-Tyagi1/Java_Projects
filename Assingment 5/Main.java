/*
 * Kartik Tyagi
 * Assignment 5
 * 
 * Main 
 * 
 * This file runs the whole thing. I also added a line here to give the application a title
 * 
 */

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            // This following line sets title
            primaryStage.setTitle("Assignment 5 - Kartik Tyagi");
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}