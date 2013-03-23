package com.sleepnova.pillow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class KeyValueStore {

	final String TAG = KeyValueStore.class.getSimpleName();
	private SQLiteDatabase db;
	
	public KeyValueStore(Context context, String name) {
		PillowStoreOpenHelper mDbHelper = new PillowStoreOpenHelper(context, name);
        db = mDbHelper.getWritableDatabase();
	}

	public void put(String key, String value){
        ContentValues values = new ContentValues();
        values.put("key", key);
        values.put("value", value);
        if(value != null)
	        if(has(key)) {
	        	db.replace("KV", null, values);
	        } else {
	        	db.insert("KV", null, values);
	        }
        else
        	del(key);
	}
	
	public void del(String key){
		db.delete ("KV", "key = ?", new String[]{key});
	}
	
	public String get(String key){
		Cursor cursor = db.rawQuery ("SELECT * from KV WHERE key = ?", new String[]{key});
        return cursor.moveToFirst() ? cursor.getString(1) : null;
	}
	
	public boolean has(String key){
		Cursor cursor = db.rawQuery ("SELECT * from KV WHERE key = ?", new String[]{key});
        return cursor.moveToFirst();
	}
	
	public void close(){
		db.close();
	}

}
