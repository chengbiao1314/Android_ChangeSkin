package com.demo.android_changeskin.load;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import com.demo.android_changeskin.staticstring.URLString;
import android.util.Log;

public class LoadingFile {
	public static void loadingDB(String urlstring){
		URL url;
		int contentLength = 0;
		
		String dirName = URLString.DBdrl;
		File f = new File(dirName);
		if(!f.exists()){
		    f.mkdir();
		}
		
		String newFilename = urlstring.substring(urlstring.lastIndexOf("/")+1);
		
		newFilename = dirName + newFilename;
		File file = new File(newFilename);
		if(file.exists()){
		    file.delete();
		}
		
		try {
			url = new URL(urlstring);
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
			contentLength = con.getContentLength();
			
			Log.v("loading DataBase, and file length is......:",contentLength+"");
			
			byte[] bs = new byte[1024];   
	        int len;   
	        OutputStream os = new FileOutputStream(file);   
            while ((len = is.read(bs)) != -1) {
            	os.write(bs, 0, len);   
            }  
            
	         os.close();  
	         is.close();
			
		} catch (Exception e) {
			Log.v("***********loading:", "loading failed...");
			e.printStackTrace();
		}
	}
}
