package com.demo.android_changeskin.base;

import android.app.Activity;
import android.view.KeyEvent;

public abstract class BaseActivity extends Activity {
	
	protected abstract void getElement();
	protected abstract void refreshSkin();
	protected abstract void setListener();
	protected abstract void initData();
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
			break;
		case KeyEvent.KEYCODE_SEARCH:
			break;
		case KeyEvent.KEYCODE_BACK:
			finish();
			break;
		case KeyEvent.KEYCODE_HOME:
			break;
		}
		return true;
	}
}
