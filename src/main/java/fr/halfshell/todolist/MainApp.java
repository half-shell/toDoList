/**
 * Created by brick on 22/01/16.
 */
package fr.halfshell.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My Todo list App");

        showTodolistOverview();
    }

    public void showTodolistOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TodolistOverview.fxml"));
            AnchorPane todolist = loader.load();

            Scene scene = new Scene(todolist);

            primaryStage.setScene(scene);
            scene.getStylesheets().add(MainApp.class.getResource("css/style.css").toExternalForm());
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
