package mobile.cantusolutions.tasker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DCantu on 17/05/16.
 */
public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public ArrayList<Task_element> getTasks() {
        ArrayList<Task_element> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Task", null);
        cursor.moveToFirst();
        Log.v("DATABASE", "Registros: " + cursor.getCount());
        while (!cursor.isAfterLast()) {
            Task_element t = new Task_element();
            t.setID(cursor.getInt(0));
            t.setName(cursor.getString(1));
            Log.v("DATABASE", "Nombre de tarea: " + cursor.getString(1));
            t.setDesc(cursor.getString(2));
            t.setDate(cursor.getString(3));
            t.setRemind(cursor.getInt(4));
            t.setProgress(cursor.getInt(5));
            t.setCategory(cursor.getInt(6));
            list.add(t);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public void addTask(Task_element t){
        String name = t.getName();
        String desc = t.getDesc();
        String date = t.getDate();
        int remind = t.getRemind();
        int progress = t.getProgress();
        int category = t.getCategory();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Desc", desc);
        values.put("Date", date);
        values.put("Remind", remind);
        values.put("Progress", progress);
        values.put("Category", category);
        database.insert("Task", null, values);
    }

}
