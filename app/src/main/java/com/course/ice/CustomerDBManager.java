package com.course.ice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class CustomerDBManager extends SQLiteOpenHelper {
    static final String CUSTOMER_DB = "Customers.db";
    static final String CUSTOMER_TABLE = "Customers";
    Context context = null;
    private static CustomerDBManager dbManager = null;

    static final String CREATE_DB = "CREATE TABLE " + CUSTOMER_TABLE +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "customer_id TEXT NOT NULL, " +
            "customer_pw TEXT, name TEXT NOT NULL, phone_number TEXT);";

    public static CustomerDBManager getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new CustomerDBManager(context, CUSTOMER_DB, null, 1);
        }
        return dbManager;
    }

    public CustomerDBManager(Context context, String dbName,
                             SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
    }
    public long insert(ContentValues addValue) {
        return getWritableDatabase().insert(CUSTOMER_TABLE, null, addValue);
    }
    public Cursor query(String [] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy){
        return getReadableDatabase().query(CUSTOMER_TABLE,
                columns, selection, selectionArgs, groupBy, having, orderBy);
    }
    public int delete(String whereClause, String[] whereArgs)
    {
        return getWritableDatabase().delete(CUSTOMER_TABLE,
                whereClause, whereArgs);
    }

}
