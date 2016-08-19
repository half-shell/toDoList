package fr.halfshell.todolist.model;

/**
 * Created by John on 28/01/2016.
 */
public class ToDo {
    private String description;
    private boolean done = false;

    public ToDo(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone(){ return done; }

    public void switchDone(){
        done = !done;
    }
}
