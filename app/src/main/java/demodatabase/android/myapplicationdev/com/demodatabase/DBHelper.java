package demodatabase.android.myapplicationdev.com.demodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "";

    private static final String TABLE_NAME = "";
    private static final String COLUMN_ID = "";
    private static final String COLUMN_2 = "";
    private static final String COLUMN_3 = "";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_NAME +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                //DOUBLE CHECK DATA TYPES TEXT/INTEGER/REAL/BLOB
                + COLUMN_2 + " TEXT,"
                + COLUMN_3 + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");


    }

    //Insert Method (Create)

    public void insertTask(String column_2, String column_3){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_2, column_2);
        // Store the column name as key and the date as value
        values.put(COLUMN_3, column_3);
        // Insert the row into the TABLE_NAME
        db.insert(TABLE_NAME, null, values);
        // Close the database connection
        db.close();
    }

    // Get Column 2 Content ONLY (Read)

    public ArrayList<String> getTaskContent() {
        // Create an ArrayList that holds String objects
        ArrayList<String> tasks = new ArrayList<String>();
        // Select all the tasks' description
        String selectQuery = "SELECT " + COLUMN_2
                + " FROM " + TABLE_NAME;

        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);

        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  0 in getString(0) return the data in the first
                //  column in the Cursor object. getString(1)
                //  return second column data and so on.
                //  Use getInt(0) if data is an int
                tasks.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return tasks;
    }

    //Get ALL Tasks (Read)

    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_2 + ", "
                + COLUMN_3
                + " FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String column_2 = cursor.getString(1);
                String column_3 = cursor.getString(2);
                Task obj = new Task(id, column_2, column_3);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }


    //Delete Existing Table

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create table(s) again
        onCreate(db);

    }
}
