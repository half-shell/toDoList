package fr.halfshell.todolist.data;

import java.util.ArrayList;

/**
 * Modified by John on 28/01/2016.
 */
public class ToDoList {
    private static ArrayList<ToDo> toDoList = new ArrayList<>();

    public ToDoList() {

    }

    public static ArrayList<ToDo> getToDoList() {
        return toDoList;
    }

    public static void addToToDoList(ToDo p_data) {
        toDoList.add(p_data);
    }

    public void add(ToDo p_data) {
        if (p_data != null) {
            toDoList.add(p_data);
        }
    }
}
