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
import javafx.scene.layout.AnchorPane;

/**
 * Created by John on 28/01/2016.
 */

public class MainController implements Initializable {

    @FXML // The main anchorPane
    private AnchorPane toDoAnchorPane;
    @FXML // List of ToDoList
    private ListView<ToDo> toDoListView;
    @FXML // TodoText to Add
    private TextField textFieldToDo;
    @FXML // Action button to add & delete
    private Button buttonAddToDo;

    // Observable list for auto-update in the list view
    private static final ObservableList<ToDo> toDoObservableList = FXCollections.observableArrayList();

    // this method is launched first
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // Displaying the ToDos
        toDoListView.setItems(toDoObservableList);
        //TODO: Change the ListView for a TableView to let it be more flexible
    }

    @FXML
    public void handleAddToDoAction(){
        addTextFieldToList();
    }

    @FXML
    public void handleListViewItemSelectedAction(){
        if(!toDoObservableList.isEmpty() & toDoListView.getFocusModel().getFocusedIndex() != -1){
            buttonAddToDo.setText("Del");
            buttonAddToDo.setOnAction(event -> rmSelectedTodo(toDoListView.getFocusModel().getFocusedIndex()));
        }
    }

    @FXML
    //TODO: Change this to the onAction event for the textField
    public void onEnter(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            addTextFieldToList();
        }
    }

    private void addTextFieldToList() {
        if (!textFieldToDo.getText().isEmpty()) {
            ToDo todo = new ToDo(textFieldToDo.getText());
            toDoObservableList.add(todo);
            textFieldToDo.clear();
            // Requesting the focus so the textField placeholder appears everytime
            toDoAnchorPane.requestFocus();
        }
    }

    public void rmSelectedTodo(int i){
        if(!toDoObservableList.isEmpty()){
            toDoObservableList.remove(i);
            buttonAddToDo.setText("Add");
            buttonAddToDo.setOnAction(event -> addTextFieldToList());
            // Reset focus
            toDoAnchorPane.requestFocus();
        }
    }
}
