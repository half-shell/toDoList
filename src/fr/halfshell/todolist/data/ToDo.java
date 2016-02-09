package fr.halfshell.todolist.data;

import java.util.ArrayList;

/**
 * Created by John on 28/01/2016.
 */
public class ToDo {
    private static ArrayList<ToDo> toDoList = new ArrayList();
    private String description;

    public ToDo() {
    }

    public ToDo(String p_description) {
        this.description = p_description;
        toDoList.add(this);
    }

    public static ArrayList<ToDo> getToDoList() {
        return toDoList;
    }

    public static void setToDoList(ArrayList<ToDo> toDoList) {
        ToDo.toDoList = toDoList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addToToDoList() {

    }

}
