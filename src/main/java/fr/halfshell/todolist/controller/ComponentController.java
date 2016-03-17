package fr.halfshell.todolist.controller;

import fr.halfshell.todolist.model.ToDo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by John on 28/01/2016.
 */

public class ComponentController implements Initializable {
    @FXML // List of ToDoList
    private ListView<String> toDoListView;
    @FXML // Button that add the textFieldToDo to the ToDoList(ListView toDoListView)
    private Button buttonAddToDo;
    @FXML // TodoText to Add
    private TextField textFieldToDo;
    // Observable list for auto-update in the list view
    static ObservableList<String> toDoObservableList = FXCollections.observableArrayList();


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        toDoListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell call(ListView<String> param) {
                return new ButtonCell();
            }

        });
    // Action on button click
        buttonAddToDo.setOnAction(event -> {
            if(buttonAddToDo.getText().equals("Add"))
              addTf1Text();
        });
        buttonAddToDo.setOnMouseExited(event-> buttonAddToDo.setStyle("-fx-background-color: dimgray"));
        buttonAddToDo.setOnMouseEntered(event-> buttonAddToDo.setStyle("-fx-background-color: DarkGray") );

        // Action on ENTER key press
        textFieldToDo.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addTf1Text();
            }
        });

        toDoListView.setOnMouseClicked(event->{
            System.out.println("Todo " + toDoListView.getSelectionModel().getSelectedIndex() + " selected.");
        });

        // Displaying the ToDos
        toDoListView.setItems(toDoObservableList);
    }

    // Add the text of TextField on a ToDoList and reload the ListView
    public void addTf1Text() {
        if (!textFieldToDo.getText().isEmpty()) {
            ToDo todo = new ToDo(textFieldToDo.getText());
            toDoObservableList.add(todo.getDescription());
            textFieldToDo.setText("");
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


