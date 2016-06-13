package com.example.chukc.shadowtitle;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	getMenuInflater().inflate(R.menu.menu_main, menu);
	menu.findItem(R.id.action_edit).setVisible(false);
	menu.findItem(R.id.action_share).setVisible(false);
	menu.findItem(R.id.action_settings).setVisible(false);
	return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
//	getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
		Window window = getWindow();
	    window.setFlags(
	        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
	        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//	    window.setFlags(
//	        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
//	        WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	}
    }


}
