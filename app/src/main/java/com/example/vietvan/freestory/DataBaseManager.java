package com.example.vietvan.freestory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VietVan on 04/03/2018.
 */

public class DataBaseManager {
    private static final String TABLE_NAME = "tbl_short_story";
    private static final String TAG = "TAG";
    public static DataBaseManager db;
    AssetHelper assetHelper;
    SQLiteDatabase sqLiteDatabase;

    public DataBaseManager(Context context) {
        assetHelper = new AssetHelper(context);
        sqLiteDatabase = assetHelper.getReadableDatabase();
    }

    public static DataBaseManager get(Context context){
        if(db == null)
            db =  new DataBaseManager(context);
        return db;
    }

    public List<Story> getListStory() {
        List<Story> list = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(new Story(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6)));
            cursor.moveToNext();
        }
        Log.d(TAG, "getListStory: " + list);

        return list;
    }

    public void updateMark(Story story, int mark){
        sqLiteDatabase = assetHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("bookmark", mark);

        sqLiteDatabase.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(story.id)});
    }

}
