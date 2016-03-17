package fr.halfshell.todolist.controller;

import fr.halfshell.todolist.model.ToDo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

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
    ObservableList<String> toDoObservableList = FXCollections.observableArrayList();


    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        // Action on button click
        buttonAddToDo.setOnAction(event -> {
            if(buttonAddToDo.getText().equals("Add"))
              addTf1Text();
            else if(toDoListView.getSelectionModel() != null)
                rmSelectedTodo(toDoListView.getSelectionModel().getSelectedIndex());
        });
        buttonAddToDo.setOnMouseExited(event-> buttonAddToDo.setStyle("-fx-background-color: dimgray"));
        buttonAddToDo.setOnMouseEntered(event-> buttonAddToDo.setStyle("-fx-background-color: DarkGray") );

        // Action on ENTER key press
        textFieldToDo.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addTf1Text();
            }
        });


        textFieldToDo.setOnMouseClicked(event->buttonAddToDo.setText("Add"));
        toDoListView.setOnMouseClicked(event->{
            final MultipleSelectionModel<String> model = toDoListView.getSelectionModel();
            final int selectedIdx = model.getSelectedIndex();
            System.out.println("Todo " + model.getSelectedIndex() + " selected.");
                if (selectedIdx == -1) {
                    buttonAddToDo.setText("Add");
                }else buttonAddToDo.setText("Del");
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

    public void rmSelectedTodo(int i){
        if(!toDoObservableList.isEmpty()){
            toDoObservableList.remove(i);
            System.out.println("Todo " + i + " removed.");
        }
        else System.out.println("Todo list is empty.");
    }

}
