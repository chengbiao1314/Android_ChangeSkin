package com.demo.android_changeskin;

import com.demo.android_changeskin.base.BaseActivity;
import com.demo.android_changeskin.db.SkinQueryDao;
import com.demo.android_changeskin.staticstring.URLString;
import com.demo.android_changeskin.utils.SharedPreferencesUtils;
import com.demo.android_changeskin.utils.getSkinUtils;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener {
	TextView tv_title;
	TextView tv_index;
	TextView tv_context;
	ImageView iv_image;
	Button btn_change;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		tv_title = (TextView) findViewById(R.id.title);
		tv_index = (TextView) findViewById(R.id.index);
		tv_context = (TextView) findViewById(R.id.context);
		iv_image = (ImageView) findViewById(R.id.image);
		btn_change = (Button) findViewById(R.id.change);
	}
	
	@Override
	protected void refreshSkin() {
		tv_title.setBackgroundColor(Color.parseColor(getSkinUtils.getColor("title")));
		tv_index.setBackgroundColor(Color.parseColor(getSkinUtils.getColor("index")));
		tv_context.setBackgroundColor(Color.parseColor(getSkinUtils.getColor("context")));
		tv_title.setText(getSkinUtils.getText("text_title"));
		tv_index.setText(getSkinUtils.getText("text_index"));
		tv_context.setText(getSkinUtils.getText("text_context"));
		tv_title.setTextSize(getSkinUtils.getTextSize("text_title"));
		tv_index.setTextSize(getSkinUtils.getTextSize("text_index"));
		tv_context.setTextSize(getSkinUtils.getTextSize("text_context"));
		tv_title.setTextColor(Color.parseColor(getSkinUtils.getTextColor("text_title")));
		tv_index.setTextColor(Color.parseColor(getSkinUtils.getTextColor("text_index")));
		tv_context.setTextColor(Color.parseColor(getSkinUtils.getTextColor("text_context")));
		
		BitmapUtils bitmapUtils = new BitmapUtils(this);
		bitmapUtils.display(iv_image, getSkinUtils.getImageUri("image1"));
//		bitmapUtils.display(iv_image, "http://192.168.3.46:8080/aa.jpg");
	}
	

	@Override
	protected void setListener() {
		btn_change.setOnClickListener(this);
	}

	@Override
	protected void initData() {
		Log.v("DB************title:",SkinQueryDao.getBackgroundColor("title"));
	}

	@Override
	public void onClick(View v) {
		int x=(int)(Math.random()*3)+1;
		switch (x) {
		case 1:
			SharedPreferencesUtils.setSkinTheme(this, "green");
			break;
		case 2:
			SharedPreferencesUtils.setSkinTheme(this, "blue");
			break;
		case 3:
			SharedPreferencesUtils.setSkinTheme(this, "red");
			break;
		default:
			break;
		}
		refreshSkin();
	}
}
