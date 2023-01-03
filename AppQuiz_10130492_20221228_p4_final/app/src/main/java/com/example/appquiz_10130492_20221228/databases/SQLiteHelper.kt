package com.example.appquiz_10130492_20221228.databases

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLiteHelper(context: Context?): SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION ) {
    val assignTableName = "Assignments"
    private val SQL_CREATE_ENTRIES_COURSES = "CREATE TABLE $assignTableName (name TEXT,"+
            " cityName TEXT, "+
            " tel TEXT, "+
            " address TEXT, "+
            "description TEXT)"
    private val SQL_DELETE_ENTRIES_ASSIGN = "DROP TABLE IF EXISTS $assignTableName"
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES_COURSES)
        Log.d("DB","Creating Databases")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES_ASSIGN)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "School.db"

    }
}