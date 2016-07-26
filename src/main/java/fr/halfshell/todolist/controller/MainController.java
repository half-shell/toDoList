package fr.halfshell.todolist.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

import fr.halfshell.todolist.model.ToDo;

/**
 * Created by John on 28/01/2016.
 */

public class MainController implements Initializable {
    @FXML // List of ToDoList
    private ListView<ToDo> toDoListView;
    @FXML // TodoText to Add
    private TextField textFieldToDo;
    // Observable list for auto-update in the list view
    private static final ObservableList<ToDo> toDoObservableList = FXCollections.observableArrayList();

    @FXML
    public void handleAddToDoAction(){
        addTextFieldToList();
    }

    @FXML
    public void onEnter(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            addTextFieldToList();
        }
    }

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // Displaying the ToDos
        toDoListView.setItems(toDoObservableList);
    }

    private void addTextFieldToList() {
        if (!textFieldToDo.getText().isEmpty()) {
            ToDo todo = new ToDo(textFieldToDo.getText());
            toDoObservableList.add(todo);
            textFieldToDo.clear();
            toDoListView.requestFocus();
        }
    }

    public static void rmSelectedTodo(int i){
        if(!toDoObservableList.isEmpty()){
            System.out.println("Todo " + i +": "+toDoObservableList.get(i) +" removed.");
            toDoObservableList.remove(i);
        }
        else System.out.println("Todo list is empty.");
    }
}
