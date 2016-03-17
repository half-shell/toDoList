package fr.halfshell.todolist.controller;

import fr.halfshell.todolist.model.ToDo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by John on 28/01/2016.
 */

public class ComponentController implements Initializable {
    @FXML // List of ToDoList
    private ListView<String> lv1;
    @FXML // Button that add the tf1 to the ToDoList(ListView lv1)
    private Button buttonAddToDo;
    @FXML // TodoText to Add
    private TextField tf1;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // Action on button click
        buttonAddToDo.setOnAction(event -> addTf1Text());
        buttonAddToDo.setOnMouseExited(event-> buttonAddToDo.setStyle("-fx-background-color: dimgray"));
        buttonAddToDo.setOnMouseEntered(event-> buttonAddToDo.setStyle("-fx-background-color: DarkGray") );
        // Action on ENTER key press
        tf1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addTf1Text();
            }
        });
        tf1.setOnMouseClicked(event->buttonAddToDo.setText("Add"));
        lv1.setOnMouseClicked(event->{
            final int selectedIdx = lv1.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                      buttonAddToDo.setText("Del");
                }else buttonAddToDo.setText("Add");
        });
    }

    // Reload the ListView with ToDoList
    public void reloadToDoList() {
        lv1.getItems().clear();
        for (ToDo item : ToDo.getToDoList()) {
            lv1.getItems().add(item.getDescription());
        }
    }

    // Add the text of TextField on a ToDoList and reload the ListView
    public void addTf1Text() {
        if (!tf1.getText().isEmpty()) {
            new ToDo(tf1.getText());
            tf1.setText("");
            reloadToDoList();
        }
    }


}
