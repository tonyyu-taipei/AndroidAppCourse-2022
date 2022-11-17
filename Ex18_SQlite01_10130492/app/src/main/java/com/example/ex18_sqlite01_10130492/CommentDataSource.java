package com.example.ex18_sqlite01_10130492;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CommentDataSource {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {SQLiteHelper.COLUMN_ID, SQLiteHelper.TABLE_COMMENTS};

    public CommentDataSource(Context context){
        dbHelper = new SQLiteHelper(context,null);
    }
    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public void deleteComment(Comment comment){
        long id = comment.getId();
        System.out.println("Comment deleted with id: "+ id);
        database.delete(SQLiteHelper.TABLE_COMMENTS,SQLiteHelper.COLUMN_ID+" = "+id, null);
    }
    public List<Comment> getAllComments(){
        List<Comment> comments = new ArrayList<>();
        Cursor cursor = database.query(SQLiteHelper.TABLE_COMMENTS,allColumns,null,null,null,null,null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        return comments;

    }

    private Comment cursorToComment(Cursor cursor){
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }
    public Comment createComment(String comment){
        ContentValues val = new ContentValues();
        val.put(SQLiteHelper.COLUMN_COMMENTS, comment);
        long insertId = database.insert(SQLiteHelper.TABLE_COMMENTS,null,val);
        Cursor cursor = database.query(SQLiteHelper.TABLE_COMMENTS,allColumns,SQLiteHelper.COLUMN_ID+" = "+insertId,null,null,null,null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

}
