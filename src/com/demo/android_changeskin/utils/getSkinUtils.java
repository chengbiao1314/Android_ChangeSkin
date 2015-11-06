package com.demo.android_changeskin.utils;

import com.demo.android_changeskin.db.SkinQueryDao;

import android.content.Context;

public class getSkinUtils {
	
	public static String getColor(String name){
		return SkinQueryDao.getBackgroundColor(name);
	}
	public static String getText(String name){
		return SkinQueryDao.getText(name);
	}
	public static String getTextColor(String name){
		return SkinQueryDao.getTextColor(name);
	}
	public static int getTextSize(String name){
		return SkinQueryDao.getTextSize(name);
	}
	
	
	public static String getImageUri(String name){
		return SkinQueryDao.getImageUri(name);
	}
	
	
	public static String getColor(Context context,String indexname){
		
		if(SharedPreferencesUtils.getSkinTheme(context).equals("green")){
			return "#06B718";//green
		}else if(SharedPreferencesUtils.getSkinTheme(context).equals("blue")){
			return "#5781FB";//blue
		}else if(SharedPreferencesUtils.getSkinTheme(context).equals("red")){
			return "#FF4D4D";//red
		}else{
			return "#AAAAAA";
		}
	}
}
