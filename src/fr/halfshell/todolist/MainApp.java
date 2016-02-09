<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> aa8be51e7329f94878685d28a0fd1eab8d3bf816
=======
>>>>>>> aa8be51e7329f94878685d28a0fd1eab8d3bf816
/**
 * Created by brick on 22/01/16.
 */
package fr.halfshell.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My Todo list App");

        initRootLayout();

        showTodolistOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTodolistOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
<<<<<<< HEAD
<<<<<<< HEAD
            loader.setLocation(MainApp.class.getResource("../view/TodolistOverview.fxml"));
            AnchorPane todolist = (AnchorPane) loader.load();
=======
=======
>>>>>>> aa8be51e7329f94878685d28a0fd1eab8d3bf816
>>>>>>> aa8be51e7329f94878685d28a0fd1eab8d3bf816

            rootLayout.setCenter(todolist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

