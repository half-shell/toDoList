package fr.halfshell.todolist.controller;

import fr.halfshell.todolist.data.ToDo;
import fr.halfshell.todolist.data.ToDoList;
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
        // Action on ENTER key press
        tf1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addTf1Text();
            }
        });
    }

    // Reload the ListView with ToDoList
    public void reloadToDoList() {
        lv1.getItems().clear();
        for (ToDo item : ToDoList.getToDoList()) {
            lv1.getItems().add(item.getDescription());
        }
    }

    // Add the text of TextField on a ToDoList and reload the ListView
    public void addTf1Text() {
        if (!tf1.getText().isEmpty()) {
            ToDo newToDo = new ToDo(tf1.getText());
            tf1.setText("");
            reloadToDoList();
        }
    }


}



