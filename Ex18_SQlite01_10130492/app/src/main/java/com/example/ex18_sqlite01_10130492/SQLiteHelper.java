package com.example.ex18_sqlite01_10130492;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "comments2.db"; //資料庫一定要.db
    private static final int DATABASE_VERSION = 0;
    public static final String COLUMN_ID = "_id";
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_COMMENTS = "comment";

    private static final String DATABASE_CREATE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL);", TABLE_COMMENTS,COLUMN_ID,COLUMN_COMMENTS);
    public SQLiteHelper(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
