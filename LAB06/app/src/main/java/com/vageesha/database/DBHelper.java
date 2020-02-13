package com.vageesha.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+UserMaster.Users.TABLE_NAME+" ("
                                +UserMaster.Users.COLUNM_NAME_ID+" INTEGER PRIMARY KEY,"
                                +UserMaster.Users.COLUMN_NAME_USERNAME+" TEXT,"
                                +UserMaster.Users.COLUMN_NAME_PASSWORD+" TEXT);";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInfo(String username,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_USERNAME,username);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD,password);

        long Row_ID = db.insert(UserMaster.Users.TABLE_NAME,null,values);
    }

    public Cursor readPassword(String username){
        SQLiteDatabase db = getReadableDatabase();
       Cursor cursor =  db.rawQuery("SELECT * FROM "+UserMaster.Users.TABLE_NAME+" WHERE "+UserMaster.Users.COLUMN_NAME_USERNAME+" ='"+username+"'",null);
       return  cursor;
    }

    public Cursor ReadAll(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {UserMaster.Users.COLUMN_NAME_USERNAME,UserMaster.Users.COLUMN_NAME_PASSWORD};

        String sortOrder = UserMaster.Users.COLUMN_NAME_USERNAME+" DESC";

        Cursor cursor = db.query(UserMaster.Users.TABLE_NAME,projection,null,null,null,null,sortOrder);
        return cursor;
    }

    public void deleteInfo(String username){
        SQLiteDatabase db = getWritableDatabase();
        String selection = UserMaster.Users.COLUMN_NAME_USERNAME+" LIKE ?";
        String[] seletionArgs = {username};

        db.delete(UserMaster.Users.TABLE_NAME,selection,seletionArgs);
    }

    public void updateInfo(String username,String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD,password);

        String selection = UserMaster.Users.COLUMN_NAME_USERNAME+" LIKE ?";
        String[] selectionArgs = {username};

        db.update(UserMaster.Users.TABLE_NAME,values,selection,selectionArgs);
    }
}
