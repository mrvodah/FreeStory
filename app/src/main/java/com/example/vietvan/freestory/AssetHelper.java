package com.example.vietvan.freestory;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by VietVan on 04/03/2018.
 */

public class AssetHelper extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "short_story.db";
    public static final int VERSION = 1;

    public AssetHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

}
