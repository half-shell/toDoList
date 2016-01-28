package fr.halfshell.todolist.data;

/**
 * Created by John on 28/01/2016.
 */
public class ToDo {
    private String description;

    public ToDo() {
    }

    public ToDo(String p_description) {
        this.description = p_description;
        ToDoList.addToToDoList(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
