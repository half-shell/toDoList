package fr.halfshell.todolist.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * Created by John on 17/03/2016.
 */
class ButtonCell extends ListCell<String> {
    HBox hbox = new HBox();
    Label label = new Label();
    Pane pane = new Pane();
    Button button = new Button("Del");
    ButtonCell() {
        super();
        hbox.getChildren().addAll(label, pane, button);
        HBox.setHgrow(pane, Priority.ALWAYS);
        button.setStyle("-fx-background-color: Red");
        button.setOnAction(event -> ComponentController.rmSelectedTodo(getIndex()));

    }

    @Override
    protected void updateItem(String item,boolean empty){
        super.updateItem(item, empty);
        if(empty){
            setGraphic(null);
        }else{
            label.setText(getItem());
            setGraphic(hbox);
        }
    }

}