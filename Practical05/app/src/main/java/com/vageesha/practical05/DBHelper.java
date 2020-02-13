package com.vageesha.practical05;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "OrderInfo.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            String SQL_CREATE_ENTRIES =
                    "CREATE TABLE " + UsersMaster.order.TABLE_NAME + " (" +
                            UsersMaster.order.COLUMN_NAME_ORDER_ID + " TEXT PRIMARY KEY," +
                            UsersMaster.order.COLUMN_NAME_DESCRIPTION + " TEXT," +
                            UsersMaster.order.COLUMN_NAME_CUSTOMER_ID + " TEXT," +
                            UsersMaster.order.COLUMN_NAME_PRODUCT_ID + " TEXT," +
                            UsersMaster.order.COLUMN_NAME_QUANTITY + " TEXT," +
                            UsersMaster.order.COLUMN_NAME_TOTAL_PRICE + " TEXT)";

            db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInfo(String orderID,String description,String cusID,String pID,String qty,String tPrice){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.order.COLUMN_NAME_ORDER_ID,orderID);
        values.put(UsersMaster.order.COLUMN_NAME_DESCRIPTION,description);
        values.put(UsersMaster.order.COLUMN_NAME_CUSTOMER_ID,cusID);
        values.put(UsersMaster.order.COLUMN_NAME_PRODUCT_ID,pID);
        values.put(UsersMaster.order.COLUMN_NAME_QUANTITY,qty);
        values.put(UsersMaster.order.COLUMN_NAME_TOTAL_PRICE,tPrice);

        long newRowId = db.insert(UsersMaster.order.TABLE_NAME,null,values);
    }

    public Cursor readAllInfo(){

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.order.COLUMN_NAME_ORDER_ID,
                UsersMaster.order.COLUMN_NAME_DESCRIPTION,
                UsersMaster.order.COLUMN_NAME_CUSTOMER_ID,
                UsersMaster.order.COLUMN_NAME_PRODUCT_ID,
                UsersMaster.order.COLUMN_NAME_QUANTITY,
                UsersMaster.order.COLUMN_NAME_TOTAL_PRICE
        };

        String sortOrder = UsersMaster.order.COLUMN_NAME_ORDER_ID + "DESC";

        Cursor cursor = db.query(
                UsersMaster.order.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        /*List userNames = new ArrayList<>();
        List passwords = new ArrayList<>();

        while(cursor.moveToNext()){
            String username = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_USERNAME));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));
            userNames.add(username);
            passwords.add(password);
        }
        cursor.close();
        return userNames;*/
        return cursor;
    }

    public void deleteInfo(String oID){

        SQLiteDatabase db = getReadableDatabase();

        String selection = UsersMaster.order.COLUMN_NAME_ORDER_ID + " LIKE ?";

        String[] selectionArgs = { oID };

        db.delete(UsersMaster.order.TABLE_NAME,selection,selectionArgs);
    }

    public void updateInfo(String orderID,String description,String cusID,String pID,String qty,String tPrice){

        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.order.COLUMN_NAME_DESCRIPTION,description);
        values.put(UsersMaster.order.COLUMN_NAME_CUSTOMER_ID,cusID);
        values.put(UsersMaster.order.COLUMN_NAME_PRODUCT_ID,pID);
        values.put(UsersMaster.order.COLUMN_NAME_QUANTITY,qty);
        values.put(UsersMaster.order.COLUMN_NAME_TOTAL_PRICE,tPrice);

        String selection = UsersMaster.order.COLUMN_NAME_ORDER_ID + " LIKE ?";
        String[] selectionArgs = {orderID};

        int count = db.update(
                UsersMaster.order.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }

    public void deleteAllInfo(){

        SQLiteDatabase db = getReadableDatabase();

        db.delete(UsersMaster.order.TABLE_NAME,null,null);
        //db.execSQL("delete from "+ UsersMaster.order.TABLE_NAME);
    }

    public String OrderMax(){
        SQLiteDatabase db = getReadableDatabase();
        String s = "";
        Cursor cursor = db.rawQuery("SELECT MAX(orderID) FROM orders",null);
        return s;
    }
}
