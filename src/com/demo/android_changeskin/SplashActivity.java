package com.demo.android_changeskin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.demo.android_changeskin.base.BaseActivity;
import com.demo.android_changeskin.load.LoadingFile;
import com.demo.android_changeskin.staticstring.URLString;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		getElement();
		setListener();
		initData();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		refreshSkin();
	}
	
	@Override
	protected void getElement() {
	}
	
	@Override
	protected void refreshSkin() {
	}
	

	@Override
	protected void setListener() {
	}

	@Override
	protected void initData() {
		copyDB(URLString.DBname_default);
		
		copyDB(URLString.DBname);
		copyDB("aa.jpg");
		copyDB("bb.jpg");
		
		new Handler().postDelayed(new Thread(){
            public void run() {
            	gotoClass();
		   }
		}, 3000);
		
//		LoadingFile.loadingDB("http://192.168.3.46:8080/skin.db");
	}

	private void copyDB(String dbName) {
		try {
//			File file  = new File(getFilesDir(), dbName);
			File f;
			File file;
			f= new File(URLString.DBdrl);
			if(!f.exists()){
				f.mkdir();
			}
			
			file = new File(URLString.DBdrl, dbName);
			
//			if(file.exists()&&file.length()>0&&file.isFile()){
//				Log.v("*************copy DB:","数据库已经存在不需要拷贝了。。。");
//			}else{
//				InputStream is = getAssets().open(dbName);
//				
//				FileOutputStream fos = new FileOutputStream(file);
//				int len = 0;
//				byte buffer[] = new byte[1024];
//				while((len = is.read(buffer))!=-1){
//					fos.write(buffer, 0, len);
//				}
//				is.close();
//				fos.flush();
//				fos.close();
//			}
			
			if(file.exists()){
			    file.delete();
			}
			InputStream is = getAssets().open(dbName);
			FileOutputStream fos = new FileOutputStream(file);
			int len = 0;
			byte buffer[] = new byte[1024];
			while((len = is.read(buffer))!=-1){
				fos.write(buffer, 0, len);
			}
			is.close();
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			Log.v("*************copy DB:","数据拷贝异常了。。。");
			e.printStackTrace();
		}
	}
	
	private void gotoClass(){
		 Intent mainIntent;
	 	 mainIntent  = new Intent(this,MainActivity.class);
   	     startActivity(mainIntent); 
         finish();
	}
}
