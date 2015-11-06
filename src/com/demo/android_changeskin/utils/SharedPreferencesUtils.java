package com.demo.android_changeskin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtils {

	//get IP
	public static String getSkinTheme(Context ct){
		return getStringFromShares(ct, "skin", "");
	}
	public static boolean setSkinTheme(Context ct,String value){
		return setStringToShares(ct, "skin", value);
	}

	/**
	 * util method
	 * @param ct
	 * @param key
	 * @param value
	 * @return
	 */
	private static boolean setStringToShares(Context ct, String key,String value) {
		if (key.isEmpty() || value.isEmpty())
			return false;
		@SuppressWarnings("deprecation")
		SharedPreferences shares = ct.getSharedPreferences("config",Context.MODE_WORLD_WRITEABLE);
		Editor editor = shares.edit();
		editor.putString(key.trim(), value.trim());
		editor.commit();
		return true;
	}
	
	private static String getStringFromShares(Context ct, String key,
			String defaultValue) {
		if (key.isEmpty())
			return "";
		SharedPreferences shares = ct.getSharedPreferences("config",Context.MODE_PRIVATE);
		String returnValue = shares.getString(key.trim(), defaultValue);
		return returnValue;
	}
}
