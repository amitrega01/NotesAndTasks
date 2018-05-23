package pl.insudev.notes.Models;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    public List<Task> taskList;
    public String listTitle;

    public TaskList() {
        taskList = new ArrayList<>();
        listTitle = "Twoja lista";
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "taskList=" + taskList +
                ", listTitle='" + listTitle + '\'' +
                '}';
    }
}
