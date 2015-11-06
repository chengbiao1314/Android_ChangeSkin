package com.demo.android_changeskin.db;


import com.demo.android_changeskin.staticstring.URLString;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SkinQueryDao {
	
	public static String getImageUri(String name) {
		String color = "";
		String path;
		SQLiteDatabase db;
		Cursor cursor;
		
		path = URLString.DBdrl+URLString.DBname;
		db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		cursor = db.rawQuery("select * from image where name = ?;",new String[]{name});
		while(cursor.moveToNext()){
			color = cursor.getString(1);
			break;
		}
		
		if(color.isEmpty()){
			path = URLString.DBdrl+URLString.DBname_default;
			db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
			cursor = db.rawQuery("select * from image where name = ?;",new String[]{name});
			while(cursor.moveToNext()){
				color = cursor.getString(1);
				break;
			}
		}
		
		cursor.close();
		db.close();
		return URLString.DBdrl + color;
	}
	public static String getBackgroundColor(String name) {
		String color = "";
		String path;
		SQLiteDatabase db;
		Cursor cursor;
		
		path = URLString.DBdrl+URLString.DBname;
		db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		cursor = db.rawQuery("select * from color where name = ?;",new String[]{name});
		while(cursor.moveToNext()){
			color = cursor.getString(1);
			break;
		}
		
		if(color.isEmpty()){
			path = URLString.DBdrl+URLString.DBname_default;
			db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
			cursor = db.rawQuery("select * from color where name = ?;",new String[]{name});
			while(cursor.moveToNext()){
				color = cursor.getString(1);
				break;
			}
		}
		
		cursor.close();
		db.close();
		return color;
	}
	public static String getText(String name) {
		String color = "";
		String path;
		SQLiteDatabase db;
		Cursor cursor;
		
		path = URLString.DBdrl+URLString.DBname;
		db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		cursor = db.rawQuery("select * from text where name = ?;",new String[]{name});
		while(cursor.moveToNext()){
			color = cursor.getString(1);
			break;
		}
		
		if(color.isEmpty()){
			path = URLString.DBdrl+URLString.DBname_default;
			db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
			cursor = db.rawQuery("select * from text where name = ?;",new String[]{name});
			while(cursor.moveToNext()){
				color = cursor.getString(1);
				break;
			}
		}
		
		cursor.close();
		db.close();
		return color;
	}
	public static String getTextColor(String name) {
		String color = "";
		String path;
		SQLiteDatabase db;
		Cursor cursor;
		
		path = URLString.DBdrl+URLString.DBname;
		db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		cursor = db.rawQuery("select * from text where name = ?;",new String[]{name});
		while(cursor.moveToNext()){
			color = cursor.getString(2);
			break;
		}
		
		if(color.isEmpty()){
			path = URLString.DBdrl+URLString.DBname_default;
			db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
			cursor = db.rawQuery("select * from text where name = ?;",new String[]{name});
			while(cursor.moveToNext()){
				color = cursor.getString(2);
				break;
			}
		}
		
		cursor.close();
		db.close();
		return color;
	}
	public static int getTextSize(String name) {
		int color = 0;
		String path;
		SQLiteDatabase db;
		Cursor cursor;
		
		path = URLString.DBdrl+URLString.DBname;
		db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		cursor = db.rawQuery("select * from text where name = ?;",new String[]{name});
		while(cursor.moveToNext()){
			color = cursor.getInt(3);
			break;
		}
		
		if(color == 0){
			path = URLString.DBdrl+URLString.DBname_default;
			db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
			cursor = db.rawQuery("select * from text where name = ?;",new String[]{name});
			while(cursor.moveToNext()){
				color = cursor.getInt(3);
				break;
			}
		}
		
		cursor.close();
		db.close();
		return color;
	}
}
	
