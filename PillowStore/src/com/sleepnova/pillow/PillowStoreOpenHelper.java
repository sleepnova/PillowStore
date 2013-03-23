package com.sleepnova.pillow;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PillowStoreOpenHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	
	public PillowStoreOpenHelper(Context context, String name) {
		super(context, name, null, DATABASE_VERSION);
	}

	private static final String SQL_CREATE_ENTRIES = "CREATE TABLE KV (key TEXT PRIMARY KEY ASC, value BLOB)";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}
	
	private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS KV";

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
	}

}
