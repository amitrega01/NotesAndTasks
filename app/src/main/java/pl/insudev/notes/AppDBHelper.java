package pl.insudev.notes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import pl.insudev.notes.Models.AppDB;
import pl.insudev.notes.Models.TaskList;

public class AppDBHelper {

    public static AppDB appDB;
    private ObjectMapper objectMapper;
    private Context mContext;

    public AppDBHelper(Context mContext) {
        appDB = new AppDB();
        this.objectMapper = new ObjectMapper();
        this.mContext = mContext;
        loadData();
    }

    private void loadData() {
        try {
            appDB = objectMapper.readValue(new File(mContext.getFilesDir(), "appDB.json"), AppDB.class);
            if (appDB.tasks.isEmpty()) appDB.tasks.add(new TaskList());
            Log.d("APPDB", appDB.toString());
        } catch (IOException e) {

            Log.d("MAPPER", e.toString());
        }

    }

    public void Save() {

        try {
            objectMapper.writeValue(new File(mContext.getFilesDir(), "appDB.json"), appDB);
            loadData();
        } catch (IOException e) {
            Log.d("MAPPER", e.toString());
        }
    }

    public void addItem(Object item, @Nullable String title) {
        if (appDB.add(item, title)) Save();

    }
}
