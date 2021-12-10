package com.course.ice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider{
    static final String PROVIDER_NAME = "com.course.ice.MyContentProvider";
    static final String URL = "content://" + PROVIDER_NAME + "/customers";
    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String _ID = "_id";
    static final String NAME = "name";
    static final String CUSTOMER_ID = "customer_id";
    static final String CUSTOMER_PW = "customer_pw";
    static final String PHONE = "phone_number";
    public CustomerDBManager dbManager;
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[]
            selectionArgs) {
        return dbManager.delete(selection, selectionArgs);
    }
    @Override
    public String getType(Uri uri) {
        return null;
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowid = dbManager.insert(values);
        return null;
    }
    @Override
    public boolean onCreate() {
        dbManager = CustomerDBManager.getInstance(getContext());
        return true;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String
            selection, String[] selectionArgs, String sortOrder) {
        return dbManager.query(projection, selection, selectionArgs, null, null, sortOrder);
    }
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}