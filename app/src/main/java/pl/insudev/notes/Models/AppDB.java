package pl.insudev.notes.Models;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AppDB {

    public List<TaskList> tasks;
    public List<Note> notes;

    public AppDB() {
        tasks = new ArrayList<TaskList>();
        tasks.add(new TaskList());
        notes = new ArrayList<>();
    }

    public boolean add(Object item, @Nullable String title) {
        if (item.getClass() == Task.class && !title.isEmpty()) {
            //dodawanie task
            for (TaskList temp : tasks
                    ) {
                if (temp.listTitle == title)
                    temp.taskList.add((Task) item);
            }

        } else {
            //dodawnaie notki
            notes.add((Note) item);
        }
        return true;


    }

    @Override
    public String toString() {
        return "AppDB{" +
                "tasks=" + tasks +
                ", notes=" + notes +
                '}';
    }
}
