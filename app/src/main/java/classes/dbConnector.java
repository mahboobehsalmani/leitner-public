package classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Mahboobeh on 7/20/2019.
 */



public class dbConnector extends SQLiteOpenHelper {

    public dbConnector(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);



        create_Tables();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void create_Tables(){

        Log.e(app.main.TAG , "creating table");
        String query = "CREATE TABLE IF NOT EXISTS card (    " +
                "id     INTEGER PRIMARY KEY AUTOINCREMENT,   "+
                "front  TEXT,                                "+
                "back   TEXT,                                "+
                "sdate1  DATE,                                "+
                "sdate2  DATE,                                "+
                "sdate3  DATE,                                "+
                "sdate4  DATE,                                "+
                "sdate5  DATE,                                "+
                "fdate1  DATE,                                "+
                "fdate2  DATE,                                "+
                "fdate3  DATE,                                "+
                "fdate4  DATE,                                "+
                "fdate5  DATE,                                "+
                "boxno  INTEGER                              "+
                "done   BOOLEAN                              "+
                ");";

        this.exec(query);

    }

    public void exec(String query){
        try {
            this.getWritableDatabase().execSQL(query);
        }
        catch (Exception e){

        }

    }

    public Boolean insert(String table , ContentValues values){

        try {
            this.getWritableDatabase().insert(table, null, values);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


    public Cursor select(String query){

        Cursor c = null;
        c = this.getWritableDatabase().rawQuery(query , null);
        return c;

    }
}


