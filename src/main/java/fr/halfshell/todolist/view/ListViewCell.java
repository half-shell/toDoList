package fr.halfshell.todolist.view;

import fr.halfshell.todolist.model.ToDo;
import javafx.scene.control.ListCell;
import javafx.scene.control.ToggleButton;

public class ListViewCell extends ListCell<ToDo> {
    private final ToggleButton todoDoneButton = new ToggleButton("Done");

    @Override
    protected void updateItem(ToDo todo, boolean empty) {
        super.updateItem(todo, empty);

        todoDoneButton.setOnAction((e) -> {
            todo.switchDone();
            switchButton(todo.isDone());
        });

        if (todo == null || empty) {
            // Reset the cell's content
            setText("");
            setGraphic(null);
        } else {
            setText(todo.getDescription());
            switchButton(todo.isDone());
            todoDoneButton.setSelected(todo.isDone());
            setGraphic(todoDoneButton);
        }
    }

    private void switchButton(boolean isDone){
        todoDoneButton.setText(isDone ? "Done!" : "To Do");
        todoDoneButton.setStyle(isDone ? "-fx-background-color: green" : "-fx-background-color: red");
    }
}
