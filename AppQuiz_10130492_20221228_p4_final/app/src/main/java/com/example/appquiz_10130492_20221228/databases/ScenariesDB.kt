package com.example.appquiz_10130492_20221228.databases

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.appquiz_10130492_20221228.Scenary

class ScenariesDB(context: Context?) {
    private val dbHelper = SQLiteHelper(context);
    val db: SQLiteDatabase = dbHelper.readableDatabase


    fun readAll(): ArrayList<Scenary>{
        val assList = ArrayList<Scenary>()
        try {
            val cursor =
                db.query(false, dbHelper.assignTableName, null, null, null, null, null, null, null)
            if (cursor!=null && cursor.moveToFirst())
                while(!cursor.isAfterLast){
                    // _id note title assignedDate dueDate courseName
                    val name = cursor.getString(0)
                    val cityName = cursor.getString(1)
                    val closeDate = cursor.getString(2)
                    val address = cursor.getString(3)
                    val description = cursor.getString(4)
                    val assignment = Scenary(name,cityName,closeDate,address,description)
                    cursor.moveToNext()
                    assList.add(assignment)
                }
        }catch(e:Exception){

        }

        return assList
    }
    fun deleteOne(id: Int): Boolean{
        val res = db.delete(dbHelper.assignTableName,"_id = $id",null)
        return res > 0
    }
    fun insert(scenary: Scenary): Boolean{
        val toInsert = ContentValues()
        toInsert.put("name", scenary.name)
        toInsert.put("cityName",scenary.cityName)
        toInsert.put("description",scenary.description)
        toInsert.put("address",scenary.address)
        toInsert.put("tel",scenary.tel)

        val res = db.insert(dbHelper.assignTableName,null,toInsert)
        return res != (-1).toLong()
    }

}