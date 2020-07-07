package com.dnk.beginner.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dnk.beginner.model.CustomerDTO;

public class LoadDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Customer.db";
    private static final String TABLE_NAME = "Customer";
    private static final String CUST_ID = "id";
    private static final String CUST_NAME = "name";
    private static final String CUST_TELEPHONE = "tele";
    private static final String CUST_PASSWORD = "password";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE CUSTOMER ("
            + LoadDbHelper.CUST_ID +" INTEGER PRIMARY KEY,"
            + LoadDbHelper.CUST_NAME +" TEXT,"
            + LoadDbHelper.CUST_TELEPHONE +" INTEGER,"
            + LoadDbHelper.CUST_PASSWORD +" TEXT)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+TABLE_NAME;


    public LoadDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, LoadDbHelper.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }


    public boolean saveCustomer(CustomerDTO customerDTO) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(LoadDbHelper.CUST_NAME,customerDTO.getCustomer_name());
        contentValues.put(LoadDbHelper.CUST_TELEPHONE,customerDTO.getCustomer_telephone());
        contentValues.put(LoadDbHelper.CUST_PASSWORD,customerDTO.getCustomer_password());

        long newrow= db.insert(LoadDbHelper.TABLE_NAME,null,contentValues);
        db.close();
        return newrow > 0;
    }


    public CustomerDTO searchCustomer(String Custname, String password) {
        CustomerDTO customerDTO = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+LoadDbHelper.TABLE_NAME+" WHERE "+LoadDbHelper.CUST_NAME+" = ? AND "+LoadDbHelper.CUST_PASSWORD+" = ? ",new String[]{Custname,password} );
        while (cursor.moveToNext()){
            customerDTO=new CustomerDTO(cursor.getString(1),Integer.parseInt(cursor.getString(2)),cursor.getString(3));
        }
        return customerDTO;
    }
}
